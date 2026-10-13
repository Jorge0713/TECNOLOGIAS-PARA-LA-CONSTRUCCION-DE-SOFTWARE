using System;
using System.Collections.Generic;
using System.Threading;
using System.Threading.Tasks;

namespace StoreApp;

// ───────────── Entidades (solo datos) ─────────────
public sealed record Cliente(string Username);
public sealed record Producto(string Id, string Nombre, decimal Precio, int Stock);
public sealed record Pedido(string Username, string ProductoId, int Cantidad, decimal Total);

// ───────────── Configuración (adiós números mágicos) ─────────────
public static class PricingPolicy
{
    public const decimal IvaRate = 0.16m;
}

// ───────────── Abstracciones ─────────────
public interface ILogger
{
    void Info(string message);
    void Error(string message);
}

public interface IDatabaseManager
{
    void Execute(string query, Dictionary<string, object> parameters);
}

public interface IClienteRepository
{
    void Save(Cliente cliente);
}

public interface IProductoRepository
{
    Producto? GetById(string id);
    void ReduceStock(string id, int quantity);
}

public interface IPedidoRepository
{
    void Save(Pedido pedido);
}

public interface IPaymentMethod
{
    bool Pay(decimal amount);
}

public interface IOrderService
{
    void CreateOrder(string username, string productId, int quantity);
}

// ───────────── Singleton: conexión SIMULADA ─────────────
public sealed class PostgresConnectionManager : IDatabaseManager
{
    // Lazy<T> es thread-safe: solo se crea una instancia aunque haya hilos concurrentes
    private static readonly Lazy<PostgresConnectionManager> _instance =
        new(() => new PostgresConnectionManager());

    public static PostgresConnectionManager Instance => _instance.Value;

    private PostgresConnectionManager()
    {
        Console.WriteLine("[DB] Inicializando conexión simulada a PostgreSQL...");
    }

    public void Execute(string query, Dictionary<string, object> parameters)
    {
        Console.WriteLine($"[DB] {query}");
        foreach (var p in parameters)
            Console.WriteLine($"     {p.Key} = {p.Value}");
        Thread.Sleep(100); // simula la latencia de la base de datos
    }
}

public sealed class ConsoleLogger : ILogger
{
    public void Info(string message) => Console.WriteLine($"[INFO] {message}");
    public void Error(string message) => Console.WriteLine($"[ERROR] {message}");
}

// ───────────── Repositorios ─────────────
public sealed class ClienteRepository : IClienteRepository
{
    private readonly IDatabaseManager _db;
    private readonly ILogger _logger;

    public ClienteRepository(IDatabaseManager db, ILogger logger)
    {
        _db = db;
        _logger = logger;
    }

    public void Save(Cliente cliente)
    {
        _db.Execute(
            "INSERT INTO clientes(username) VALUES(@username)",
            new Dictionary<string, object> { ["@username"] = cliente.Username });

        _logger.Info($"Cliente registrado: {cliente.Username}");
    }
}

public sealed class ProductoRepository : IProductoRepository
{
    private readonly IDatabaseManager _db;
    private readonly ILogger _logger;

    // Catálogo en memoria: sustituye a la tabla "productos" de la BD simulada
    private static readonly Dictionary<string, Producto> _catalogo = new()
    {
        ["prod_101"] = new Producto("prod_101", "Teclado", 250m, 10),
        ["prod_205"] = new Producto("prod_205", "Mouse", 120m, 3)
    };

    public ProductoRepository(IDatabaseManager db, ILogger logger)
    {
        _db = db;
        _logger = logger;
    }

    public Producto? GetById(string id)
    {
        _db.Execute(
            "SELECT * FROM productos WHERE id=@id",
            new Dictionary<string, object> { ["@id"] = id });

        return _catalogo.TryGetValue(id, out var producto) ? producto : null;
    }

    public void ReduceStock(string id, int quantity)
    {
        _db.Execute(
            "UPDATE productos SET stock=stock-@quantity WHERE id=@id",
            new Dictionary<string, object>
            {
                ["@quantity"] = quantity,
                ["@id"] = id
            });

        _logger.Info($"Stock actualizado: {id} (-{quantity})");
    }
}

public sealed class PedidoRepository : IPedidoRepository
{
    private readonly IDatabaseManager _db;
    private readonly ILogger _logger;

    public PedidoRepository(IDatabaseManager db, ILogger logger)
    {
        _db = db;
        _logger = logger;
    }

    public void Save(Pedido pedido)
    {
        _db.Execute(
            "INSERT INTO pedidos(username, producto_id, cantidad, total) " +
            "VALUES(@username, @productoId, @cantidad, @total)",
            new Dictionary<string, object>
            {
                ["@username"] = pedido.Username,
                ["@productoId"] = pedido.ProductoId,
                ["@cantidad"] = pedido.Cantidad,
                ["@total"] = pedido.Total
            });

        _logger.Info($"Pedido guardado para {pedido.Username}");
    }
}

// ───────────── Métodos de pago ─────────────
public sealed class CardPayment : IPaymentMethod
{
    public bool Pay(decimal amount)
    {
        Console.WriteLine($"[PAYMENT] Tarjeta: {amount:C}");
        return true;
    }
}

public sealed class CashPayment : IPaymentMethod
{
    public bool Pay(decimal amount)
    {
        Console.WriteLine($"[PAYMENT] Efectivo: {amount:C}");
        return true;
    }
}

// ───────────── Servicio de pedidos ─────────────
public sealed class OrderService : IOrderService
{
    private readonly IClienteRepository _clientes;
    private readonly IProductoRepository _productos;
    private readonly IPedidoRepository _pedidos;
    private readonly IPaymentMethod _payment;
    private readonly ILogger _logger;

    public OrderService(
        IClienteRepository clientes,
        IProductoRepository productos,
        IPedidoRepository pedidos,
        IPaymentMethod payment,
        ILogger logger)
    {
        _clientes = clientes;
        _productos = productos;
        _pedidos = pedidos;
        _payment = payment;
        _logger = logger;
    }

    public void CreateOrder(string username, string productId, int quantity)
    {
        if (quantity <= 0)
        {
            _logger.Error("La cantidad debe ser mayor a cero.");
            return;
        }

        var producto = _productos.GetById(productId);
        if (producto is null)
        {
            _logger.Error("El producto no existe.");
            return;
        }

        if (producto.Stock < quantity)
        {
            _logger.Error($"Stock insuficiente de {producto.Nombre}.");
            return;
        }

        decimal total = producto.Precio * quantity * (1 + PricingPolicy.IvaRate);

        if (!_payment.Pay(total))
        {
            _logger.Error("Pago rechazado.");
            return;
        }

        _clientes.Save(new Cliente(username));
        _productos.ReduceStock(productId, quantity);
        _pedidos.Save(new Pedido(username, productId, quantity, total));

        _logger.Info($"Pedido completado. Total: {total:C}");
    }
}

// ───────────── Composition root ─────────────
public static class Program
{
    public static void Main()
    {
        IDatabaseManager db = PostgresConnectionManager.Instance;
        ILogger logger = new ConsoleLogger();

        IClienteRepository clientes = new ClienteRepository(db, logger);
        IProductoRepository productos = new ProductoRepository(db, logger);
        IPedidoRepository pedidos = new PedidoRepository(db, logger);
        IPaymentMethod payment = new CardPayment(); // cámbialo por CashPayment y nada más se toca

        IOrderService orders = new OrderService(clientes, productos, pedidos, payment, logger);

        Console.WriteLine("\n--- PEDIDOS CONCURRENTES ---");

        Parallel.Invoke(
            () => orders.CreateOrder("cliente_a", "prod_101", 2),
            () => orders.CreateOrder("cliente_b", "prod_205", 1),
            () => orders.CreateOrder("cliente_c", "prod_101", 5)
        );

        Console.WriteLine("\n--- SINGLETON ---");

        var db1 = PostgresConnectionManager.Instance;
        var db2 = PostgresConnectionManager.Instance;

        Console.WriteLine($"¿Misma instancia? {ReferenceEquals(db1, db2)}");
    }
}
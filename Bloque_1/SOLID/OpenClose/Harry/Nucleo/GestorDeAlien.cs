using System.ComponentModel;
using System.IO.Pipes;
using System.Transactions;
using Harry.Alien;
using Harry.Extensiones;
namespace Harry.Nucleo;

public class GestorDeAlien
{
    private List<(string Nombre, Func<IAlien> Crear, bool Desbloqueado)> _catalogo = new()
    {
        ("Fuego", () => new Fuego() as IAlien, true),
        ("Humungosaurio", () => new Humungosaurio() as IAlien, true),
        ("Cuatro Brazos", () => new CuatroBrazos() as IAlien, true)
    };
    private readonly List<(string Nombre, Func<IAlien> Crear)> _escanearADN = new();
    private readonly Dictionary<Type, Func<IAlien>> _supremos = new()
    {
        {typeof(HumungosaurioSupremo), () => new HumungosaurioSupremo() as IAlien}
    };
    private readonly List<(string Nombre, Func<IAlien>Crear)> _fusiones = new()
    {
        ("Humungosaurio + Cuatro Brazos", () => new Fusion<Humungosaurio,CuatroBrazos> () as IAlien),
        ("Fuego + Cuatro Brazos", () => new Fusion<Fuego,CuatroBrazos> () as IAlien),
        ("Fuego + Humungosaurio", () => new Fusion<Fuego,Humungosaurio> () as IAlien),
    };
    public List <(string Nombre, Func<IAlien> Crear)> ObtenerDesbloqueados()
    {
        var lista = _catalogo
            .Where(a => a.Desbloqueado)
            .Select(a=>(a.Nombre,a.Crear))
            .ToList();
        lista.AddRange(_escanearADN);
        return lista; 
    }
    public List<string> ObtenerNombresDesbloqueados() => _catalogo.Where(a => a.Desbloqueado).Select(a => a.Nombre).ToList();

    public bool TieneSupremo(IAlien alien) => _supremos.ContainsKey(alien.GetType());


    

}
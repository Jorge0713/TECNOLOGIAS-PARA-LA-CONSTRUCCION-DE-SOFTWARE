package Bloque_1.SOLID.Liskov.Evelyn;

public class Cliente {
    private String nombre;
    private String id;
    private CuentaBancaria cuenta;

    public Cliente(String nombre, String id, CuentaBancaria cuenta) {
        this.nombre = nombre;
        this.id = id;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getId() {
        return this.id;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void depositar(double cantidad) {
        cuenta.depositar(cantidad);
    }

    public void retirar(double cantidad) {
        cuenta.retirar(cantidad);
    }
    public double consultarDatos(){
        return cuenta.consultarSaldo();
    }
    public double calcularIntereses(){
        return cuenta.calcularInteres();
    }

    public void pagarDeuda(double cantidad){
        cuenta.pagarDeuda(cantidad);
    }
    public void mostrarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Id: " + id  );
        System.out.println("Cuenta: " + cuenta);
    }
}

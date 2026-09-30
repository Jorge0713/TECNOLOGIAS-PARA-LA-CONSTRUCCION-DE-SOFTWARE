package Bloque_1.SOLID.Liskov.Evelyn;

public abstract class CuentaBancaria {
    protected String numeroCuenta;
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, double saldo){
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    public void depositar(double cantidad){
        this.saldo += cantidad;
    }
    public void retirar(double cantidad){
        this.saldo -= cantidad;
    }
    public double consultarSaldo(){
        return this.saldo;
    }
    public String getNumeroCuenta(){
        return this.numeroCuenta;
    } 
    public abstract double
     calcularInteres();

    public abstract void pagarDeuda(double cantidad);
    protected void validarCantidad(double cantidad){    
        if (cantidad < 0){
            throw new IllegalArgumentException("La cantidad no puede ser menor a 0");
        }
    }
}

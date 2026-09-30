package Bloque_1.SOLID.Liskov.Evelyn;

public class CuentaAhorro extends CuentaBancaria{
    private double tasaIntereses;
    public CuentaAhorro(String numeroCuenta, double saldoInicial){
        super(numeroCuenta, saldoInicial);
        this.tasaIntereses = 0.05;
    }
    @Override 
    public double calcularInteres(){
        return saldo * tasaIntereses;
    }
    @Override 
    public void pagarDeuda(double cantidad){
        throw new IllegalArgumentException("No hay deuda que pagar");
    }

}

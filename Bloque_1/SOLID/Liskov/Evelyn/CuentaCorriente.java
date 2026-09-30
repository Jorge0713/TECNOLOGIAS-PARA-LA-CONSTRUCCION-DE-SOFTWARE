package Bloque_1.SOLID.Liskov.Evelyn;

public class CuentaCorriente extends CuentaBancaria{
    private double limiteSobreGiro;
    private double tasaIntereses;

    public CuentaCorriente(String numeroCuenta, double saldo, double limiteSobreGiro){
        super(numeroCuenta, saldo);

        if(limiteSobreGiro < 0){
            throw new IllegalArgumentException("El limite Sobregiro no debe ser menor a 0");
        }
  
        this.limiteSobreGiro = limiteSobreGiro;      
        this.tasaIntereses = 0.02;
    }
    @Override
    public void retirar(double cantidad){
        validarCantidad(cantidad);
        if(cantidad > saldo + limiteSobreGiro){
            throw new IllegalArgumentException("La operacion excede el limite ");
        }
        saldo -= cantidad;
    }
    @Override 
    public double calcularInteres(){
        if(saldo<0){
            limiteSobreGiro = Math.abs(saldo);
            return limiteSobreGiro * tasaIntereses;
        }
        return 0.0;
    }

    public double consultarSobreGiroUtilizado(){
        if (saldo < 0){
            return Math.abs(saldo);
        }
        return 0.0;
    }
    @Override 
    public void pagarDeuda(double cantidad){
        return;
    }
    public double getLimiteSeguro(){
        return limiteSobreGiro;
    }

}

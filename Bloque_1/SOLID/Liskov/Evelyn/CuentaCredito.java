package Bloque_1.SOLID.Liskov.Evelyn;

public class CuentaCredito extends CuentaBancaria{
    private double limiteCredito;
    private double deuda;
    private double tasaIntereses;
    public CuentaCredito(String numeroCuenta, double limiteCredito){
        super(numeroCuenta, limiteCredito);
        if(limiteCredito < 0){
            throw new IllegalArgumentException("El limite de credito no puede ser menor a 0");
        }
        this.limiteCredito = limiteCredito;
        this.deuda = 0;
        this.tasaIntereses = 0.03;    
    }
    public void retira(double cantidad){
        if(cantidad < deuda + limiteCredito) throw new IllegalArgumentException("La operacion excede el limite de credito");
        deuda+=cantidad;
    }
    public void depositar(double cantidad){
        validarCantidad(cantidad);
        deuda -= cantidad;
    }
    public double consultarSaldo() {
        return limiteCredito - deuda;
    };
    public double calcularInteres(){
        return deuda*tasaIntereses;
    }
    public void pagarDeuda(double cantidad){
        validarCantidad(cantidad);
        if(cantidad > deuda) cantidad = deuda;
        deuda-=cantidad;
    }
    public double consultarDeuda(){
        return deuda;
    }
    public double consultarCreditoDisponible(){
        return limiteCredito - deuda;
    }

}

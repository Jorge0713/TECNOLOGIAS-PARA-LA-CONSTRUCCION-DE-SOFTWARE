public class Paypal implements MetodoPago{

    private String correo;

    public Paypal(String correo){
        this.correo = correo;
    }

    @Override
    public boolean validar(){
        if (this.correo.contains("@")){
            return true;
        }
        else 
        {
            return false;
        }
    }

    public void pagar(double monto){
        System.out.println("Pago de $" + monto + "enviado a la cuenta Paypal: " + this.correo);
    }
}

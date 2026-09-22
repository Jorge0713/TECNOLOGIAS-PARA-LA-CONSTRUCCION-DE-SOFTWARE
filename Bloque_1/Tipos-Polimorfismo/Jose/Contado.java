public class Contado implements MetodoPago{
   
    private boolean estadoBillete;

    
    public Contado(boolean estadoBillete){
        this.estadoBillete = estadoBillete;
    }


    @Override
    public boolean validar(){
        return estadoBillete;
    }
    @Override
    public void pagar(double monto){
        System.out.println("El billete esta en buen estado y se pago de forma correcta");
    }

}
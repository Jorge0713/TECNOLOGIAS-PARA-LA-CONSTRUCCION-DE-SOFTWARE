public class Caja{
    public void cobrar(MetodoPago metodo, double monto){
        if (metodo.validar()){
            metodo.pagar(monto);
        }
    }
    
}

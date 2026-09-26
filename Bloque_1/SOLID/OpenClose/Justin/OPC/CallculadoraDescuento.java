package Bloque_1.SOLID.OpenClose.Justin.OPC;

public class CallculadoraDescuento {
    public double aplicarDecuento(String tipoDescuento, double subtotal){
        if(tipoDescuento.equals("descuentoNavidad"))
            return subtotal*0.90;
        else if (tipoDescuento.equals("sinDescuento"))
            return subtotal;
        else 
            throw new IllegalArgumentException("Descuento no valido");
    }
}

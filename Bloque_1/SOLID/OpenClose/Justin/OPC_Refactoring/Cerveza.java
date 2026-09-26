package Bloque_1.SOLID.OpenClose.Justin.OPC_Refactoring;

public class Cerveza extends Bebida{

    private final double IEPS = 1.25;

    public Cerveza(String nombre, double precioBase){
        super (nombre, Etiqueta.CON_IEPS , precioBase);
    }
    @Override 
    public boolean requiereINE(){
        return true;
    }
    @Override
    public double calcularTotal(){
        return getPrecioBase();
    }
}

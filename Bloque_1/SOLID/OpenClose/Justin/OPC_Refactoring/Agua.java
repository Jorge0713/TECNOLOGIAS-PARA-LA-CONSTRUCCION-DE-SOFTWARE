package Bloque_1.SOLID.OpenClose.Justin.OPC_Refactoring;

public class Agua extends Bebida{
    public Agua(String nombre, double precioBase){
        super (nombre,Etiqueta.SIN_IVA , precioBase);
    }
    @Override 
    public boolean requiereINE(){
        return false;
    }
    public double calcularTotal(){
        return getPrecioBase();
    }
}

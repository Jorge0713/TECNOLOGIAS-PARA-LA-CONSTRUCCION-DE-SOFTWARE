package Bloque_1.SOLID.OpenClose.Justin.OPC_Refactoring;

public class Refresco extends Bebida{


    public Refresco(String nombre, double precioBase){
        super (nombre,Etiqueta.CON_IVA , precioBase);
    }
    @Override 
    public boolean requiereINE(){
        return false;
    }
    @Override 
    public double calcularTotal(){
        return getPrecioBase();
    }
}


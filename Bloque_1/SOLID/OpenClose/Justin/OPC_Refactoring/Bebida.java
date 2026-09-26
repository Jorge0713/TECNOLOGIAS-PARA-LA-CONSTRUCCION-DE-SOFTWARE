package Bloque_1.SOLID.OpenClose.Justin.OPC_Refactoring;


public abstract class Bebida{
    private static final double IVA = 0.16;
    private final String nombre;
    private double precioBase;
    private final Etiqueta etiqueta;

    protected Bebida(String nombre, Etiqueta etiqueta, double precioBase) {
        if(precioBase <= 0) throw new IllegalArgumentException("Precio Invalido");
        this.nombre= nombre;

        this.precioBase =precioBase;
        this.etiqueta=etiqueta;
    }
    public abstract boolean requiereINE();
    public abstract boolean calcularTotal();

    public double getPrecioBase(){
        return precioBase;
    }
    public String getNombre(){
        return nombre;
    }
    public String getEtiqueta(){
        return nombre + " " + etiqueta;
    } 

}
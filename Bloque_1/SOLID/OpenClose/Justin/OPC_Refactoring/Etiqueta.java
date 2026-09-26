package Bloque_1.SOLID.OpenClose.Justin.OPC_Refactoring;

public enum Etiqueta {

    SIN_IVA("Libre de impuesto"),
    CON_IVA("IVA incluido"),
    CON_IEPS("IVA + IEPS INCLUIDO");

    private final String descripcion;

    Etiqueta(String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripion(){
        return descripcion;
    }
}

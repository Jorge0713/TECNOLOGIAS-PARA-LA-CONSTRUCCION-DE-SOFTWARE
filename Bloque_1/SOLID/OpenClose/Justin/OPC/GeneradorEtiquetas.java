package Bloque_1.SOLID.OpenClose.Justin.OPC;

public class GeneradorEtiquetas {
    public String generarEtiqueta(String tipoBebida){
        if (tipoBebida.equals("agua")) {
            return "Agua (Libre de impuestos)";
        } else if (tipoBebida.equals("refresco")) {
            return "Refresco (IVA incluido)";
        } else if (tipoBebida.equals("cerveza")) {
            return "Cerveza (IVA + IEPS incluido )";
        } else if (tipoBebida.equals("tepache")) {
            return "Tepache (IVA incluido)";
        }
        else 
            throw new IllegalArgumentException("Tipo no valido");
    }    
}

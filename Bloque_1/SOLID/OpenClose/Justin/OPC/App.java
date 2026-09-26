package Bloque_1.SOLID.OpenClose.Justin.OPC;
public class App{
    public static void main(String [] args){
        Caja caja = new Caja();
        VerificadorEdad edad = new VerificadorEdad();
        GeneradorEtiquetas etiqueta = new GeneradorEtiquetas();
        CallculadoraDescuento descuento = new CallculadoraDescuento();
        String[] bebidas = {"agua", "refresco", "tepache", "cerveza"};
        double subtotal = 0;
        for (String bebida : bebidas) {
            double precioBebida  = caja.calcularPrecio(bebida, 25.0);
            System.out.println(
                etiqueta.generarEtiqueta(bebida) + "-> $" + precioBebida + "| Requiere INE " + edad.requiereINE(bebida)
            );             
            subtotal+= precioBebida;
        }
        System.out.println("Subtotal: " +subtotal);
        System.out.println("Descuento de navidad");
        System.out.println("Total: " + descuento.aplicarDecuento("descuentoNavidad", subtotal));
    }
}



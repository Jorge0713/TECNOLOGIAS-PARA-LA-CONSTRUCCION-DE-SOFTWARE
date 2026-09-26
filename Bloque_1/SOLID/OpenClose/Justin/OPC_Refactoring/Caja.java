package Bloque_1.SOLID.OpenClose.Justin.OPC_Refactoring;

public class Caja {
    double subtotal;
    public void cobrar(Bebida[] bebidas, Dsscuento descuento, double efectivo){
        for (Bebida bebida : bebidas) {
            System.out.println(bebida.getEtiqueta() +  " $ " + bebida.calcularTotal());
            if(bebida.requiereINE()) System.out.println("Requiere INE");
            subtotal += bebida.calcularTotal();
        }
        double total = descuento.aplicar(subtotal);
        if(efectivo<total){
            System.out.println("efectivo insuficiente");
            return;
        }
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Descuento: " + descuento.getDescripcion());
        System.out.println("Total: " + total);
        System.out.println("cambio: " + (efectivo - total));
    }
}

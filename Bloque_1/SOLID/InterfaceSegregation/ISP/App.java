package Bloque_1.SOLID.InterfaceSegregation.ISP;

public class App {
    public static void main(String[] args) {
        DonRamon ramon = new DonRamon();
        DoñaFlorinda doñaFlorinda = new DoñaFlorinda();
        Ñoño ñoño = new Ñoño();
        System.out.println("==La vecindad del shavo==");

        ramon.darGolpe();
        try {
            ramon.cobrarRenta();
            ramon.pagarRenta();
            ramon.llorar();
            ramon.jugar();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
        doñaFlorinda.darGolpe();
        doñaFlorinda.pagarRenta();
        try {
            doñaFlorinda.cobrarRenta();
            doñaFlorinda.llorar();
            doñaFlorinda.jugar();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
        ñoño.llorar();
        ñoño.jugar();
        try {
            ñoño.cobrarRenta();
            ñoño.pagarRenta();
            ñoño.darGolpe();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}

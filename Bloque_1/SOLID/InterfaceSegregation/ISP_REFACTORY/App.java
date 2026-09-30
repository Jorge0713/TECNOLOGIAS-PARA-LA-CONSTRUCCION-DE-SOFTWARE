package Bloque_1.SOLID.InterfaceSegregation.ISP_REFACTORY;
import java.util.List;

public class App {
    public static void main(String [] args) throws Exception{
        Ñoño ñoño = new Ñoño();
        DonRamon ramon = new DonRamon();
        ProfesorJirafales jirafales = new ProfesorJirafales();
        List<Educador> educadorws = List.of(jirafales);
        for (Educador e : educadorws) {
            e.impartirClase();
            e.pasarLista();
            e.hacerCoraje();
        }

        List<Inquilino> inquilinos = List.of(ramon);
        for (Inquilino i : inquilinos) {
            i.pagarRenta();
        }
        List<Habitante> habitantes = List.of(ramon, jirafales);
        for (Habitante h : habitantes) {
            h.interactuarConElChavo();
        }
        List<Niño> niños = List.of(ñoño);
        for (Niño n : niños) {
            n.llorar();
            n.cantar();
        }
    }
}

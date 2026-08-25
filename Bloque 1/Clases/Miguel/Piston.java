package Miguel;

public class Piston implements ActivablePorRedstone {
    @Override
    public void activar(){
        System.out.println("Piston se activa y empuja un bloque");
    }    
    @Override
    public void desactivar(){
        System.out.println("Piston se desactiva y retrasa el bloque");
    }
}

package Bloque_1.SOLID.InterfaceSegregation;

public class Ñoño implements AccionesPersonaje {
    
    public final String nombre = "Ñoño que rico aprietas";
    
    @Override 
    public void darGolpe(){
        throw new UnsupportedOperationException(nombre + ": Es un niño, no pega");
    }
    @Override 
    public void cobrarRenta(){
        throw new UnsupportedOperationException(nombre + ": No es dueño de la vencidad ");
    }
    @Override 
    public void jugar(){
        throw new UnsupportedOperationException(nombre + ": Juega con su pelota en la playa");
    }
    @Override 
    public void llorar(){
        throw new UnsupportedOperationException(nombre + ": Ajai, Ajai");
    }
    @Override 
    public void pagarRenta(){
        throw new UnsupportedOperationException(nombre + ": no paga renta, su papa es el dueño");
    }
}

package Bloque_1.SOLID.InterfaceSegregation.ISP;

public class DonRamon implements AccionesPersonaje {
    
    public final String nombre = "Don ramon";
    
    @Override 
    public void darGolpe(){
        System.out.println(nombre + ": Toma!, toma! ");
    }
    @Override 
    public void cobrarRenta(){
        throw new UnsupportedOperationException(nombre + ": No es dueño de la vencidad ");
    }
    @Override 
    public void jugar(){
        throw new UnsupportedOperationException(nombre + ": Nunca paga juega");
    }

    
    @Override 
    public void llorar(){
        throw new UnsupportedOperationException(nombre + ": Los hombres no lloran");
    }
    @Override 
    public void pagarRenta(){
        throw new UnsupportedOperationException(nombre + ": no paga renta");
    }
}

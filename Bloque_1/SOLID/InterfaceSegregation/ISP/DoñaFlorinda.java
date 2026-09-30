package Bloque_1.SOLID.InterfaceSegregation.ISP;

public class DoñaFlorinda implements AccionesPersonaje {
    
    public final String nombre = "Doña florinda";
    
    @Override 
    public void darGolpe(){
        System.out.println(nombre + ": le da un cachetadon a don ramon! ");
    }
    @Override 
    public void pagarRenta(){
        throw new UnsupportedOperationException(nombre + ": paga la renta de 5k");
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
        throw new UnsupportedOperationException(nombre + ": no llora");
    }
    
}



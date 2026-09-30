package Bloque_1.SOLID.InterfaceSegregation.ISP_REFACTORY;

public class ProfesorJirafales implements Educador, Habitante{
    private String nombre = "Profesor jirafales";
    @Override 
    public void pasarLista(){
        System.out.println(nombre + " pasa la lista de la clase");
    }
    @Override 
    public void impartirClase(){
        System.out.println(nombre + " da una clase de historia aburrida");
    }
    @Override 
    public void hacerCoraje(){
        System.out.println("TA TA TA TA TA TA");
    }
    @Override 
    public void interactuarConElChavo(){
        System.out.println("Chavito avisame con tiempo, llevo rato esperando aqui cabron");
    }
}

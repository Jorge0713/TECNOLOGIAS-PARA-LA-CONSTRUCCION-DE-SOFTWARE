package Bloque_1.SOLID.InterfaceSegregation.ISP_REFACTORY;

public class DonRamon implements Inquilino, Habitante, Educador {
    private String nombre = "Don Ramon";
    @Override 
    public void pagarRenta(){
        System.out.println(nombre +" le jura al señor barriga que le paga la proxima semana");
    }
    @Override 
    public void interactuarConElChavo(){
        System.out.println(nombre +" le mete un vergazo al chavo");
    }
    @Override 
    public void pasarLista(){
        System.out.println(nombre +" pasa lista de los que se acuerda");
    }
    @Override 
    public void impartirClase(){
        System.out.println(nombre +" esto significa PELIGRO");
    }
    @Override 
    public void hacerCoraje(){
        System.out.println(nombre +" le grita al chavo REPROBADO");
    }
}

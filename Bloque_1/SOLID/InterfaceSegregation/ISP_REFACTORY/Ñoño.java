package Bloque_1.SOLID.InterfaceSegregation.ISP_REFACTORY;

public class Ñoño implements Niño, Habitante{

    private String nombre = "Ñoño";
    @Override 
    public void llorar(){
        System.out.println(nombre + "llora por paty Ajai, Ajai, Ajai");
    }
    @Override 
    public void interactuarConElChavo(){
        System.out.println("Le da su torta de jamon al chavito");
    }
    @Override 
    public void cantar(){
        System.out.println("Soy todo lo que dicen que soy\r\n" + //
                        "[00:20.88]Soy peor que eso y soy mejor\r\n" + //
                        "[00:24.99]A veces me da miedo a dónde voy\r\n" + //
                        "[00:28.81]Y sigo caminando con valor\r\n" + //
                        "[00:32.86]Yo soy solamente lo que soy\r\n" + //
                        "[00:36.97]Ni más, ni menos, solo eso soy\r\n" + //
                        "[00:40.08]A veces me arrepiento de lo que doy\r\n" + //
                        "[00:44.66]Y siempre entrego de mí lo mejor\r\n" + //
                        "[00:48.09]Y soy solamente un perdedor\r\n" + //
                        "[00:55.28]Pronto será un ganador\r\n" + //
                        "[00:59.03]Siempre buscando triunfar y triunfar\r\n" + //
                        "[01:04.77]Y estoy orgulloso de quién soy\r\n" + //
                        "[01:17.12]\r\n" + //
                        "[01:24.99]Nunca tengo miedo a fracasar\r\n" + //
                        "[01:28.78]Y gano cuando tengo que ganar\r\n" + //
                        "[01:32.79]A veces quiero dejar de cantar\r\n" + //
                        "[01:36.67]Si caigo me tendré que levantar\r\n" + //
                        "[01:40.90]Y soy solamente un perdedor\r\n" + //
                        "[01:47.04]Pronto será un ganador\r\n" + //
                        "[01:50.96]Siempre buscando triunfar y triunfar\r\n" + //
                        "[01:56.84]Y soy aquello que nadie esperaba\r\n" + //
                        "[02:03.04]Soy el que todo gano\r\n" + //
                        "[02:06.81]Siempre buscando luchar y luchar\r\n" + //
                        "[02:12.71]Y esto");
    }
}

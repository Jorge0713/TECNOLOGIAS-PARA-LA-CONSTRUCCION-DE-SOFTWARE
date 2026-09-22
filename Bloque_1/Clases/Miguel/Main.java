package Miguel;

public class Main {
    public static void main(String [] args){
        Piston miPiston = new Piston();
        Puerta miPuerta = new Puerta();
        Lampara miLampara = new Lampara();
        BloqueMusical miBloqueMusical = new BloqueMusical();

        System.out.println("Se activa la palanca");
        miPiston.activar();
        miPuerta.activar();
        miLampara.activar();
        miBloqueMusical.activar();

        System.out.println("Se desactiva la palanca");
        miPiston.desactivar();
        miPuerta.desactivar();
        miLampara.desactivar();
        miBloqueMusical.desactivar();

        Zombie miZombie = new Zombie();
        Esqueleto miEsqueleto = new Esqueleto();

        miZombie.quemarEnLava();
        miEsqueleto.quemarEnLava();

        miZombie.atacar();
        miEsqueleto.atacar();

    }
    
}

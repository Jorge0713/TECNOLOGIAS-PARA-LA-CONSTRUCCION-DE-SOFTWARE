package Bloque_1.SOLID.OpenClose.Justin.OPC_Refactoring;

public class App {
    public  static void main(String[] args){
        Bebida[] bebidas = {
            new Agua("Ciel",20) 
            , new Refresco("coca", 25)
            , new Cerveza("Coronita", 30)
        };
        Caja caja = new Caja();
        caja.cobrar(bebidas, null, 1200000);
    }
}

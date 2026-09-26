package Bloque_1.SOLID.OpenClose.Justin.OPC;

public class VerificadorEdad {
    public boolean requiereINE(String tipoBebida){
        if(tipoBebida.equals("cerveza"))
            return true;
        else return false;
    }
}

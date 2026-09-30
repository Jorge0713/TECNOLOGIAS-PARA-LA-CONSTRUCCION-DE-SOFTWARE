package Bloque_1.SOLID.Liskov.Evelyn;

public class SistemaBancario {
    public static void main(String[] args){
        System.out.println("Sistema Bancario LSP MALO");
        CuentaBancaria ahorro = new CuentaAhorro("CA-001", 10000);
        CuentaBancaria corriente = new CuentaCorriente("C-002", 5000, 10);
        CuentaBancaria credito = new CuentaCredito("C-003", 6700);
        Cliente cliente1 = new Cliente("Alexa", "001", ahorro);
        Cliente cliente2 = new Cliente("Pamela", "002", corriente);
        Cliente cliente3 = new Cliente("Vanessa", "003", credito);


        cliente1.depositar(5000);

        
        cliente2.retirar(2000);
        cliente3.consultarDatos();
        System.out.println("Cuentas Ahorro");

    }
}

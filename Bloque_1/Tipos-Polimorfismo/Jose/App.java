public class App {
    public static void main(String[] args) {
        Caja caja = new Caja();
        MetodoPago tarjeta = new Tarjeta("1245678910111111");
        MetodoPago paypal = new Paypal("usuario@gmail.com");
        MetodoPago contado = new Contado(true);

        caja.cobrar(tarjeta, 500);
        caja.cobrar(paypal,1000);
        caja.cobrar(contado, 200); 
   }
}

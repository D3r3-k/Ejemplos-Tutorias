package hilos2;

public class Hilos2 {

    public static void main(String[] args) {
        //Crear hilos
        Thread hilo1 = new Hilo("1");
        Thread hilo2 = new Hilo("2");
        
        //Iniciar los hilos
        hilo1.start();
        hilo2.start();
    }
}
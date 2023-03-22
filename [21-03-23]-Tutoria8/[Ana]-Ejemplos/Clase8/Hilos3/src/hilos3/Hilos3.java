package hilos3;

public class Hilos3 {

    public static void main(String[] args) {
        //Objeto de la clase Proceso
        Proceso runnable1 = new Proceso();
        
        //Crear hilos
        Thread hilo1 = new Thread(runnable1);

        //Iniciar los hilos
        hilo1.start();

    } 
}
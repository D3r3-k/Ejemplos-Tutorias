package hilos1;

public class Hilos1 {

    public static void main(String[] args) {
        //Crear hilos (el parámetro es el nombre del hilo)
        Thread hilo = new Proceso("Proceso 1");
        Thread hilo2 = new Proceso("Proceso 2");
        //Iniciar los procesos o hilos
        hilo.start();
        hilo2.start();
    }
}
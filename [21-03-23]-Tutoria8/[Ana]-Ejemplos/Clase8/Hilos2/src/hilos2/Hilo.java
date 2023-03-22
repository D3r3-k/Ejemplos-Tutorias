package hilos2;

public class Hilo extends Thread {
    
    String nombre;

    //Constructor con parámetro
    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    //Método implementado
    @Override
    public void run() {
        while(true){
            System.out.println("Proceso: " + this.nombre);
        }
    }
}

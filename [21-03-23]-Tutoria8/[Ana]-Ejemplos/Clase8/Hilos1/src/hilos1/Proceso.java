package hilos1;

public class Proceso extends Thread{
    
    //Constructor con parámetro
    public Proceso(String nombre){
        //Se heredan propiedades de Thread
        super(nombre);
    }
    
    //Método que se va a ejecutar al iniciar el hilo
    public void run(){
        //Código a ejecutar
        for(int i = 0; i <= 20; i++){
            //Imprimir el nombre del proceso
            System.out.println(this.getName());
        }
    }
}
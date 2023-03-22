package hilos3;

public class Proceso implements Runnable{

    int segundos = 0;
    int minutos = 0;

    //Constructor vacío
    public Proceso() {
    }

    //Método implementado
    @Override
    public void run() {
        while (true) {
            //Código a ejecutar
            if(segundos == 60){
                minutos++;
                segundos = 0;
            }
            if(segundos < 10){
                System.out.println(minutos + ":0" + segundos);
            }else{
                System.out.println(minutos + ":" + segundos);
            }
            try {
                //Suspende la ejecución del hilo por un tiempo definido en milisegundos
                Thread.sleep(1000);
                segundos++;
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
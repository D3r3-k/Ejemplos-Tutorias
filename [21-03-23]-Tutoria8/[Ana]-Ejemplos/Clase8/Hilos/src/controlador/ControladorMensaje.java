package controlador;

import ventana.FrmReloj;

public class ControladorMensaje extends Thread {

    FrmReloj vReloj;

    //Constructor con parámetro
    public ControladorMensaje(FrmReloj vReloj) {
        this.vReloj = vReloj;
    }

    //Método implementado
    @Override
    public void run() {
        while (true) {
            this.vReloj.lblMensaje.setText("Holaaaa :D");
            try {
                //Suspende la ejecución del hilo por un tiempo definido en milisegundos
                Thread.sleep(8000);
                this.vReloj.lblMensaje.setText("Espero tengas un buen día :3");
                Thread.sleep(12000);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}

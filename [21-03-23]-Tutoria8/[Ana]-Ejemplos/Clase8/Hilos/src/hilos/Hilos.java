package hilos;

import controlador.ControladorMensaje;
import controlador.ControladorReloj;
import ventana.FrmReloj;

public class Hilos {

    public static void main(String[] args) {
        //Crear un objeto tipo ventana
        FrmReloj vReloj = new FrmReloj();
        //Crear un objeto de la clase que controlará las acciones de la ventana
        ControladorReloj cReloj = new ControladorReloj(vReloj);
        ControladorMensaje cMensaje = new ControladorMensaje(vReloj);
        
        //Configuraciones iniciales de la ventana
        vReloj.setVisible(true);
        vReloj.setLocationRelativeTo(null);
        vReloj.setResizable(false);
    }
}
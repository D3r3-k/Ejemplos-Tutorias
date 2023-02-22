package clase4;

import controlador.ControladorConcurso;
import controlador.ControladorInicio;
import vista.FrmConcurso;
import vista.FrmInicio;

public class Clase4 {

    public static void main(String[] args) {

        //Creamos una ventana del JFrame FrmInicio
        FrmInicio vInicio = new FrmInicio();

        //Creamos una ventana del JFrame FrmConcurso
        FrmConcurso vConcurso = new FrmConcurso();

        /*
        Creamos un objeto de las clases ControladorInicio y ControladorConcurso,
        las cuales contendrán el código relacionado al funcionamiento de las ventanas
        vInicio y vConcurso respectivamente. Estas ventanas se envían como parámetros
        para que en cInicio y cConcurso podamos acceder a los componentes de estas
        (como botones, text fields, etc)
         */
        ControladorInicio cInicio = new ControladorInicio(vInicio, vConcurso);
        ControladorConcurso cConcurso = new ControladorConcurso(vConcurso);

        /*
        Configuraciones de la ventana vInicio:
        - setLocationRelativeTo(null) -> coloca la ventana al centro de la pantalla
        - setResizable(false) -> evita que la ventana pueda cambiar de tamaño
        - setSize(x, y) -> para establecer el tamaño de la ventana
        - setVisible(true) -> hace visible la ventana
         */
        vInicio.setLocationRelativeTo(null);
        vInicio.setResizable(false);
        vInicio.setSize(760, 600);
        vInicio.setVisible(true);
    }
}
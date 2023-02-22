package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmConcurso;
import vista.FrmInicio;

/*
Implementamos el ActionListener para poder controlar los eventos relacionados a clics,
también debemos importar el ActionListener e implementar sus métodos abstractos (en este
caso es solo 1)
 */
public class ControladorInicio implements ActionListener {

    /*
    Atributos de la clase, que serían las ventanas
     */
    FrmInicio vInicio;
    FrmConcurso vConcurso;

    /*
    Constructor con parámetros, el cual recibe la ventana de inicio y la de concurso,
    y estas se asignan a los atributos de la clase (vInicio y vConcurso).
    Para que nuestro listener (escuchador -> ActionListener) reconozca que se ha dado
    clic al botón de participar, se debe agregar el escuchador al botón con la línea de código:
    this.vInicio.btnParticipar.addActionListener(this);
     */
    public ControladorInicio(FrmInicio vInicio, FrmConcurso vConcurso) {
        this.vInicio = vInicio;
        this.vConcurso = vConcurso;
        this.vInicio.btnParticipar.addActionListener(this);
    }

    /*
    Método que controlará los eventos del ActionListener
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        /*
        En este caso se está comparando que si la fuente/origen o el componente al que se
        ha dado clic es igual al botón 'Participar' de mi ventana de inicio, entonces
        que ejecute las sentencias dentro del if, las cuales serían para hacer visible
        la ventana de concurso con las configuraciones presentes
         */
        if (ae.getSource() == this.vInicio.btnParticipar) {
            this.vConcurso.setLocationRelativeTo(null);
            this.vConcurso.setResizable(false);
            this.vConcurso.setSize(800, 700);
            this.vConcurso.setVisible(true);
        }
    }
}
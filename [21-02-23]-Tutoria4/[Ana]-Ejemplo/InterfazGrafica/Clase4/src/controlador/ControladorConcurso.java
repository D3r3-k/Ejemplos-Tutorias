package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmConcurso;

/*
Implementamos el ActionListener para poder controlar los eventos relacionados a clics,
también debemos importar el ActionListener e implementar sus métodos abstractos (en este
caso es solo 1)
 */
public class ControladorConcurso implements ActionListener {

    /*
    Atributo de la clase, que sería la ventana de concurso
     */
    FrmConcurso vConcurso;

    /*
    Constructor con parámetros, el cual recibe la ventana de concurso,
    y esta se asigna al atributo de la clase (vConcurso).
    Para que nuestro listener (escuchador -> ActionListener) reconozca que se ha dado
    clic al botón de enviar, se debe agregar el escuchador al botón con la línea de código:
    this.vConcurso.btnEnviar.addActionListener(this);
     */
    public ControladorConcurso(FrmConcurso vConcurso) {
        this.vConcurso = vConcurso;
        this.vConcurso.btnEnviar.addActionListener(this);
    }

    /*
    Método que controlará los eventos del ActionListener
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        /*
        En este caso se está comparando que si la fuente/origen o el componente al que se
        ha dado clic es igual al botón 'Enviar' de mi ventana de concurso, entonces
        que ejecute las sentencias dentro del if.
         */
        if (ae.getSource() == this.vConcurso.btnEnviar) {
            /*
            En este if se revisa si los text fields (campos de texto) de vConcurso están vacíos,
            es decir, si no se ha ingresado ningún valor en estos. En caso de que uno de estos se
            encuentre vacío, aparecerá una ventana de diálogo (Option Pane)
            con el texto "Debe llenar todos los campos".
             */
            if (this.vConcurso.txtNombre.getText().isEmpty()
                    || this.vConcurso.txtApellido.getText().isEmpty()
                    || this.vConcurso.txtEdad.getText().isEmpty()
                    || this.vConcurso.txtCorreo.getText().isEmpty()) {
                this.vConcurso.jopMensaje.showMessageDialog(vConcurso, "Debe llenar todos los campos");
            } 
            /*
            En el caso contrario (donde sí se hayan llenado todos los campos de texto), se va a verificar
            con otro if que el checkBox esté activo (con el cheque). isSelected() devolverá true (verdadero)
            si el checkBox fue activado (tiene el cheque) y false (falso) si no ha sido activado (sin cheque)
             */ 
            else {
                /*
                Si el checkBox tiene el cheque, entonces se imprimirá en consola los valores ingresados
                por el usuario y el elemento seleccionado en el comboBox. getSelectedItem() devuelve el
                elemento seleccionado de un comboBox
                 */
                if (this.vConcurso.chbTerminos.isSelected()) {
                    System.out.println("Nombre: " + this.vConcurso.txtNombre.getText() + ""
                            + "\nApellido: " + this.vConcurso.txtApellido.getText() + ""
                            + "\nEdad: " + this.vConcurso.txtEdad.getText() + ""
                            + "\nCorreo: " + this.vConcurso.txtCorreo.getText());
                    System.out.println("\nPais: " + this.vConcurso.cmbPais.getSelectedItem());
                } 
                /*
                Si no está activo el checkBox, aparecerá una ventana de diálogo (Option Pane)
                con el texto "Debe aceptar los términos y condiciones".
                 */ 
                else {
                    this.vConcurso.jopMensaje.showMessageDialog(vConcurso, "Debe aceptar los términos y condiciones");
                }
            }
        }
    }
}
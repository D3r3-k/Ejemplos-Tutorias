package controlador;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import modelo.Persona;
import vista.InfoUsuario;
import vista.MenuCliente;

/*
Se implementan el WindowListener para manejar eventos
relacionados a acciones como cerrar o abrir una
ventana o JFrame
*/
public class ControladorInfoUsuario implements WindowListener {

    //Atributos de la clase (son ventanas)
    MenuCliente vMenuCliente;
    InfoUsuario vInfoUsuario;
    
    //Atributo de la clase, es el arreglo que contiene objetos tipo Persona
    ArrayList<Persona> personasRegistradas;

    /*
    Objeto tipo Persona que contendrá la información (nombre, apellido, correo, etc)
    de la persona que inició sesión
    */
    Persona usuarioActivo = null;

    //Método constructor con parámetros, donde se reciben las ventanas o JFrames y el arreglo de personas registradas
    public ControladorInfoUsuario(MenuCliente vMenuCliente, InfoUsuario vInfoUsuario, ArrayList<Persona> personasRegistradas) {
        this.vMenuCliente = vMenuCliente;
        this.vInfoUsuario = vInfoUsuario;
        this.personasRegistradas = personasRegistradas;
        /*
        Se agrega un escuchador a la ventana para que el WindowListener
        entienda qué JFrame o ventana se está cerrando o abriendo, para
        ejecutar determinadas acciones
        */
        this.vInfoUsuario.addWindowListener(this);
    }
    
    //Se asigna el objeto tipo Persona correspondiente al objeto usuarioActivo
    public void establecerUsuario() {
        for (Persona datos : this.personasRegistradas) {
            if (datos.getUsuario() == this.vInfoUsuario.lblUsuarioActivo.getText()) {
                this.usuarioActivo = datos;
                break;
            }
        }
    }

    /*
    Se llenan las etiquetas de la ventana con la información del usuario activo,
    que sería el Usuario, Nombre, Apellido, Correo y Foto
    */
    public void setInfoUsuario() {
        this.vInfoUsuario.lblUsuario.setText(this.usuarioActivo.getUsuario());
        this.vInfoUsuario.lblNombre.setText(this.usuarioActivo.getNombre());
        this.vInfoUsuario.lblApellido.setText(this.usuarioActivo.getApellido());
        this.vInfoUsuario.lblCorreo.setText(this.usuarioActivo.getCorreo());
        String ruta = this.usuarioActivo.getFoto();
        if (ruta != null) {
            Image foto = new ImageIcon(ruta).getImage();
            ImageIcon miFoto = new ImageIcon(foto.getScaledInstance(this.vInfoUsuario.lblFoto.getWidth(), this.vInfoUsuario.lblFoto.getHeight(), Image.SCALE_SMOOTH));
            this.vInfoUsuario.lblFoto.setIcon(miFoto);
        }else{
            this.vInfoUsuario.lblFoto.setIcon(null);
        }
    }

    //Métodos del WindowListener
    //Cuando la ventana se abra
    @Override
    public void windowOpened(WindowEvent we) {
        establecerUsuario();
        setInfoUsuario();
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    //Cuando la ventana se cierre
    @Override
    public void windowClosed(WindowEvent we) {
        this.vMenuCliente.setVisible(true);
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    //Cuando la ventana está activa
    @Override
    public void windowActivated(WindowEvent we) {
        establecerUsuario();
        setInfoUsuario();
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
}

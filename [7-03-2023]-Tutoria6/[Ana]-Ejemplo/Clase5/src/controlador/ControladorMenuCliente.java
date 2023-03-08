package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import vista.InfoUsuario;
import vista.Login;
import vista.MenuCliente;
import vista.MetodoPago;

/*
Se implementan el ActionListener y WindowListener para manejar eventos
relacionados a los clic en botones y acciones a realizar al cerrar o abrir una
ventana o JFrame
*/
public class ControladorMenuCliente implements ActionListener, WindowListener{
    
    //Atributos de la clase (son ventanas)
    Login vLogin;
    MenuCliente vMenuCliente;
    MetodoPago vMetodoPago;
    InfoUsuario vInfoUsuario;

    //Método constructor con parámetros, donde se reciben las ventanas o JFrames
    public ControladorMenuCliente(Login vLogin, MenuCliente vMenuCliente, MetodoPago vMetodoPago, InfoUsuario vInfoUsuario) {
        this.vLogin = vLogin;
        this.vMenuCliente = vMenuCliente;
        this.vMetodoPago = vMetodoPago;
        this.vInfoUsuario = vInfoUsuario;
        /*
        Se agrega un escuchador a los botones para que el ActionListener
        entienda a qué botón se está dando clic
        */
        this.vMenuCliente.btnMetodosPago.addActionListener(this);
        this.vMenuCliente.btnInfoUsuario.addActionListener(this);
        /*
        Se agrega un escuchador a la ventana para que el WindowListener
        entienda qué JFrame o ventana se está cerrando o abriendo, para
        ejecutar determinadas acciones
        */
        this.vMenuCliente.addWindowListener(this);
    }

    //Método del ActionListener para administrar los clics en componentes
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Si se pulsa el botón de ADMINISTRAR MÉTODOS DE PAGO, se ejecuta lo del if
        if (ae.getSource() == this.vMenuCliente.btnMetodosPago){
            //Se hace visible la ventana de Método de Pago y se oculta el menú clientes
            this.vMetodoPago.setVisible(true);
            this.vMetodoPago.setLocationRelativeTo(null);
            this.vMetodoPago.setResizable(false);
            this.vMetodoPago.lblUsuarioActivo.setText(this.vMenuCliente.lblUsuarioActivo.getText());
            this.vMenuCliente.setVisible(false);
        }
        //Si se pulsa el botón de INFORMACIÓN USUARIO, se ejecuta lo del if
        if (ae.getSource() == this.vMenuCliente.btnInfoUsuario){
            //Se hace visible la ventana de Información Usuario y se oculta el menú clientes
            this.vInfoUsuario.setVisible(true);
            this.vInfoUsuario.setLocationRelativeTo(null);
            this.vInfoUsuario.setResizable(false);
            this.vInfoUsuario.lblUsuarioActivo.setText(this.vMenuCliente.lblUsuarioActivo.getText());
            this.vMenuCliente.setVisible(false);
        }
    }

    //Métodos del WindowListener
    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    //Método para cuando se cierre la ventana
    @Override
    public void windowClosed(WindowEvent we) {
        //Hace visible la ventana de Login al cerrarse el menú clientes
        this.vLogin.setVisible(true);
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
}
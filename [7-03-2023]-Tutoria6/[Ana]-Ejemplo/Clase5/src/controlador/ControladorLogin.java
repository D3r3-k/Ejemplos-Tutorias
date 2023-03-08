package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Persona;
import vista.InfoUsuario;
import vista.Login;
import vista.MenuCliente;
import vista.MetodoPago;
import vista.RegistroUsuario;

/*
Se implementan el ActionListener para manejar eventos
relacionados a los clic en botones
*/
public class ControladorLogin implements ActionListener {

    //Atributos de la clase (son ventanas)
    Login vLogin;
    RegistroUsuario vRegistro;
    MenuCliente vMenuCliente;
    MetodoPago vMetodoPago;
    InfoUsuario vInfoUsuario;
    
    //Atributo de la clase, es el arreglo que contiene objetos tipo Persona
    ArrayList<Persona> personasRegistradas;
    
    /*
    Objeto tipo Persona que contendrá la información (nombre, apellido, correo, etc)
    de la persona que inició sesión
    */
    Persona usuarioActivo = null;

    //Método constructor con parámetros, donde se reciben las ventanas o JFrames y el arreglo de personas registradas
    public ControladorLogin(Login vLogin, RegistroUsuario vRegistro, ArrayList<Persona> personasRegistradas, MenuCliente vMenuCliente, MetodoPago vMetodoPago, InfoUsuario vInfoUsuario) {
        this.vLogin = vLogin;
        this.vRegistro = vRegistro;
        this.vMenuCliente = vMenuCliente;
        this.vMetodoPago = vMetodoPago;
        this.vInfoUsuario = vInfoUsuario;
        this.personasRegistradas = personasRegistradas;
        /*
        Se agrega un escuchador a los botones para que el ActionListener
        entienda a qué botón se está dando clic
        */
        this.vLogin.btnLogin.addActionListener(this);
        this.vLogin.btnRegistrar.addActionListener(this);
    }

    //Vaciamos los cuadros de texto de la ventana
    public void limpiarCampos() {
        this.vLogin.txtUsuario.setText("");
        this.vLogin.txtContrasena.setText("");
        this.vLogin.lblMensaje.setText("");
    }

    /*
    Se verifica que el usuario y contraseña ingresados en los cuadros de texto
    correspondan al usuario y contraseña de algún objeto tipo Persona del arreglo
    de personas registradas. Se retorna el objeto tipo persona que coincida
    */
    public Persona verificarExistenciaUsuario(String usuario, String contrasena) {
        for (Persona persona : personasRegistradas) {
            if (persona.getUsuario().equals(usuario) && persona.getContrasena().equals(contrasena)) {
                return persona;
            }
        }
        return null;
    }

    //Método del ActionListener para administrar los clics en componentes
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.vLogin.btnLogin) {
            String usuario = this.vLogin.txtUsuario.getText();
            String contrasena = this.vLogin.txtContrasena.getText();
            if (!usuario.isEmpty() && !contrasena.isEmpty()) {
                usuarioActivo = verificarExistenciaUsuario(usuario, contrasena);
                if (usuario.equals("admin") && contrasena.equals("admin123")) {
                    System.out.println("Entrar como admin");
                }
                else if (verificarExistenciaUsuario(usuario, contrasena) != null) {
                    if(usuarioActivo.getRol().equals("Cliente")){
                        limpiarCampos();
                        this.vMenuCliente.setVisible(true);
                        this.vMenuCliente.setLocationRelativeTo(null);
                        this.vMenuCliente.setResizable(false);
                        this.vMenuCliente.lblUsuarioActivo.setText(String.valueOf(usuarioActivo.getUsuario()));
                        this.vLogin.setVisible(false);
                    }else{
                        System.out.println("Entrar como vendedor");
                    }
                } else {
                    limpiarCampos();
                    this.vLogin.lblMensaje.setText("Usuario o contraseña erróneas");
                }
            } else {
                this.vLogin.jopMensaje.showMessageDialog(vLogin, "Debe llenar todos los campos");
            }
        }
        //Si se pulsa el botón de Registrar
        if (ae.getSource() == this.vLogin.btnRegistrar) {
            limpiarCampos();
            //Se abre la ventana de Registro y se desaparece la ventana de Login
            this.vRegistro.setVisible(true);
            this.vRegistro.setResizable(false);
            this.vRegistro.setLocationRelativeTo(null);
            this.vLogin.setVisible(false);
        }
    }
}

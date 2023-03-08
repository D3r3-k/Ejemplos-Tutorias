package clase5;

import controlador.ControladorInfoUsuario;
import controlador.ControladorLogin;
import controlador.ControladorMenuCliente;
import controlador.ControladorMetodoPago;
import controlador.ControladorRegistroUsuario;
import java.util.ArrayList;
import modelo.Persona;
import vista.InfoUsuario;
import vista.Login;
import vista.MenuCliente;
import vista.MetodoPago;
import vista.RegistroUsuario;

public class Clase5 {

    public static void main(String[] args) {
        //Se crea un arreglo de objetos tipo Persona, que contendrá todas las personas registradas
        ArrayList<Persona> personasRegistradas = new ArrayList<>();
        
        //Creamos objetos tipo ventana de los distintos JFrames
        Login vLogin = new Login();
        RegistroUsuario vRegistro = new RegistroUsuario();
        MenuCliente vMenuCliente = new MenuCliente();
        MetodoPago vMetodoPago = new MetodoPago();
        InfoUsuario vInfoUsuario = new InfoUsuario();
        
        //Creamos objetos de cada uno de los controladores los cuales administrarán las acciones realizadas en las ventanas
        ControladorLogin cLogin = new ControladorLogin(vLogin, vRegistro, personasRegistradas, vMenuCliente, vMetodoPago, vInfoUsuario);
        ControladorRegistroUsuario cRegistro = new ControladorRegistroUsuario(vLogin, vRegistro, personasRegistradas);
        ControladorMenuCliente cMenuCliente = new ControladorMenuCliente(vLogin, vMenuCliente, vMetodoPago, vInfoUsuario);
        ControladorMetodoPago cMetodoPago = new ControladorMetodoPago(vMenuCliente, vMetodoPago, personasRegistradas);
        ControladorInfoUsuario cInfoUsuario = new ControladorInfoUsuario(vMenuCliente, vInfoUsuario, personasRegistradas);
        
        
        //Configuraciones de la ventana inicial
        vLogin.setVisible(true);
        vLogin.setResizable(false);
        vLogin.setLocationRelativeTo(null);
    }
}
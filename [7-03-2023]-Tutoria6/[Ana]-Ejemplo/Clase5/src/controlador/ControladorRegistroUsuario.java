package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Persona;
import vista.Login;
import vista.RegistroUsuario;

/*
Se implementan el ActionListener y WindowListener para manejar eventos
relacionados a los clic en botones y acciones a realizar al cerrar o abrir una
ventana o JFrame
*/
public class ControladorRegistroUsuario implements ActionListener, WindowListener {

    //Atributos de la clase (son ventanas)
    Login vLogin;
    RegistroUsuario vRegistro;
    
    //Atributo de la clase, es el arreglo que contiene objetos tipo Persona
    ArrayList<Persona> personasRegistradas;
    
    //Variable para almacenar la ruta de la imagen
    String ruta;

    //Método constructor con parámetros, donde se reciben las ventanas o JFrames y el arreglo de personas registradas
    public ControladorRegistroUsuario(Login vLogin, RegistroUsuario vRegistro, ArrayList<Persona> personasRegistradas) {
        this.vLogin = vLogin;
        this.vRegistro = vRegistro;
        this.personasRegistradas = personasRegistradas;
        /*
        Se agrega un escuchador a los botones para que el ActionListener
        entienda a qué botón se está dando clic
        */
        this.vRegistro.btnSubir.addActionListener(this);
        this.vRegistro.btnRegistrar.addActionListener(this);
        /*
        Se agrega un escuchador a la ventana para que el WindowListener
        entienda qué JFrame o ventana se está cerrando o abriendo, para
        ejecutar determinadas acciones
        */
        this.vRegistro.addWindowListener(this);
    }

    //Vaciamos los cuadros de texto de la ventana y se quita la imagen del label
    public void limpiarCampos() {
        this.vRegistro.txtNombre.setText("");
        this.vRegistro.txtApellido.setText("");
        this.vRegistro.txtCorreo.setText("");
        this.vRegistro.txtUsuario.setText("");
        this.vRegistro.txtContrasena.setText("");
        this.vRegistro.cmbRol.setSelectedIndex(0);
        this.vRegistro.lblFoto.setIcon(null);
    }

    /*
    Se verifica que los valores de correo y usuario de los cuadros de texto no
    sean iguales a los de algún objeto tipo Persona del arreglo de personas
    registradas. Si coinciden, se retorna true (porque está duplicado), y si no,
    false
    */
    public boolean verificarDuplicado(String correo, String usuario) {
        for (Persona datos : this.personasRegistradas) {
            if (datos.getCorreo().equals(correo) || datos.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    /*
    Se verifica que la contraseña ingresada en el cuadro de texto contenga al menos
    1 mayúscula, 1 minúscula, 1 número y 1 símbolo. Se devuelve true si se cumple y
    false si no cumple
    */
    public boolean verificarContrasenaSegura(String contrasena) {
        int contadorMinusculas = 0;
        int contadorMayusculas = 0;
        int contadorNumeros = 0;
        int contadorSimbolos = 0;
        for (int i = 0; i < contrasena.length(); i++) {
            int numeroAscii = (int) (contrasena.charAt(i));
            if (numeroAscii >= 48 && numeroAscii <= 57) {
                contadorNumeros++;
            } else if (numeroAscii >= 65 && numeroAscii <= 90) {
                contadorMayusculas++;
            } else if (numeroAscii >= 97 && numeroAscii <= 122) {
                contadorMinusculas++;
            } else if ((numeroAscii >= 33 && numeroAscii <= 47)
                    || (numeroAscii >= 58 && numeroAscii <= 64)
                    || (numeroAscii >= 91 && numeroAscii <= 96)
                    || (numeroAscii >= 123 && numeroAscii <= 126)) {
                contadorSimbolos++;
            }
        }
        if (contadorNumeros != 0 && contadorMayusculas != 0
                && contadorMinusculas != 0 && contadorSimbolos != 0) {
            return true;
        } else {
            return false;
        }
    }

    //Método del ActionListener para administrar los clics en componentes
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.vRegistro.btnRegistrar) {
            String nombre = this.vRegistro.txtNombre.getText();
            String apellido = this.vRegistro.txtApellido.getText();
            String correo = this.vRegistro.txtCorreo.getText();
            String usuario = this.vRegistro.txtUsuario.getText();
            String contrasena = this.vRegistro.txtContrasena.getText();
            if (!nombre.isEmpty() && !apellido.isEmpty() && !correo.isEmpty()
                    && !usuario.isEmpty() && !contrasena.isEmpty()) {
                if (!verificarDuplicado(correo, usuario)) {
                    if (verificarContrasenaSegura(contrasena)) {
                        String rol = String.valueOf(this.vRegistro.cmbRol.getSelectedItem());
                        Persona persona = new Persona(nombre, apellido, correo, usuario, contrasena, rol);
                        if (ruta != null) {
                            persona.setFoto(ruta);
                        }
                        boolean algo = verificarContrasenaSegura(contrasena);
                        this.personasRegistradas.add(persona);
                        this.vRegistro.jopMensaje.showMessageDialog(vRegistro, "¡Usuario registrado con éxito!");
                        System.out.println("\n--- Personas registradas por el momento ---");
                        for (Persona datos : this.personasRegistradas) {
                            System.out.println("Nombre: " + datos.getNombre());
                            System.out.println("Apellido: " + datos.getApellido());
                            System.out.println("Correo: " + datos.getCorreo());
                            System.out.println("Usuario: " + datos.getUsuario());
                            System.out.println("Contraseña: " + datos.getContrasena());
                            System.out.println("Rol: " + datos.getRol());
                            System.out.println("Foto: " + datos.getFoto());
                        }
                        limpiarCampos();
                    }else{
                        this.vRegistro.jopMensaje.showMessageDialog(vRegistro, "La contraseña debe contener por lo menos un número,"
                                + "una letra minúscula, una mayúscula y un símbolo");
                    }
                } else {
                    this.vRegistro.jopMensaje.showMessageDialog(vRegistro, "El correo o usuario ya han sido registrado anteriormente");
                }
            } else {
                this.vRegistro.jopMensaje.showMessageDialog(vRegistro, "Debe llenar todos los campos");
            }
        }
        //Si pulsamos el botón para subir una imagen
        if (ae.getSource() == this.vRegistro.btnSubir) {
            //Establecemos un filtro para los archivos a subir (que sean tipo imagen)
            FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG, JPEG & PNG", "jpg", "jpeg", "png");
            //Se asigna el filtro al FileChooser
            this.vRegistro.flcFoto.setFileFilter(filtrado);
            //Índice de la respuesta
            int respuesta = this.vRegistro.flcFoto.showOpenDialog(this.vRegistro.flcFoto);
            //Si la respuesta es aprobatoria (De que sí se va a cargar determinada imagen)
            if (respuesta == this.vRegistro.flcFoto.APPROVE_OPTION) {
                //Establecer la imagen en el label
                ruta = this.vRegistro.flcFoto.getSelectedFile().getPath();
                Image foto = new ImageIcon(ruta).getImage();
                ImageIcon miFoto = new ImageIcon(foto.getScaledInstance(this.vRegistro.lblFoto.getWidth(), this.vRegistro.lblFoto.getHeight(), Image.SCALE_SMOOTH));
                this.vRegistro.lblFoto.setIcon(miFoto);
            }
        }
    }

    //Métodos del WindowListener
    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    //Cuando se cierra la ventana
    @Override
    public void windowClosed(WindowEvent we) {
        limpiarCampos();
        //Se hace visible la ventana de Login
        vLogin.setVisible(true);
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

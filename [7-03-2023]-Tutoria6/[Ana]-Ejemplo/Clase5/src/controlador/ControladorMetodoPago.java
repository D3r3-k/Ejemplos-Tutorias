package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Persona;
import modelo.Tarjeta;
import vista.MenuCliente;
import vista.MetodoPago;

/*
Se implementan el ActionListener y WindowListener para manejar eventos
relacionados a los clic en botones y acciones a realizar al cerrar o abrir una
ventana o JFrame
*/
public class ControladorMetodoPago implements ActionListener, WindowListener {

    //Atributos de la clase (son ventanas)
    MenuCliente vMenuCliente;
    MetodoPago vMetodoPago;
    
    //Atributo de la clase, es el arreglo que contiene objetos tipo Persona
    ArrayList<Persona> personasRegistradas;
    
    /*
    Objeto tipo Persona que contendrá la información (nombre, apellido, correo, etc)
    de la persona que inició sesión
    */
    Persona usuarioActivo = null;

    //Método constructor con parámetros, donde se reciben las ventanas o JFrames y el arreglo de personas registradas
    public ControladorMetodoPago(MenuCliente vMenuCliente, MetodoPago vMetodoPago, ArrayList<Persona> personasRegistradas) {
        this.vMenuCliente = vMenuCliente;
        this.vMetodoPago = vMetodoPago;
        this.personasRegistradas = personasRegistradas;
        /*
        Se agrega un escuchador a los botones para que el ActionListener
        entienda a qué botón se está dando clic
        */
        this.vMetodoPago.btnRegistrar.addActionListener(this);
        this.vMetodoPago.btnCargar.addActionListener(this);
        /*
        Se agrega un escuchador a la ventana para que el WindowListener
        entienda qué JFrame o ventana se está cerrando o abriendo, para
        ejecutar determinadas acciones
        */
        this.vMetodoPago.addWindowListener(this);
    }

    //Se asigna el objeto tipo Persona correspondiente al objeto usuarioActivo
    public void establecerUsuario() {
        for (Persona datos : this.personasRegistradas) {
            if (datos.getUsuario() == this.vMetodoPago.lblUsuarioActivo.getText()) {
                this.usuarioActivo = datos;
                break;
            }
        }
    }

    //Vaciamos los cuadros de texto de la ventana
    public void limpiarCampos() {
        this.vMetodoPago.txtNombre.setText("");
        this.vMetodoPago.txtNumero.setText("");
        this.vMetodoPago.txtFecha.setText("");
        this.vMetodoPago.txtaTarjetas.setText("");
    }

    /*
    Se verifica que el número de tarjeta ingresado no contenga valores
    distintos a números enteros. Si contiene un valor distinto a un dígito,
    retorna false; si está compuesto únicamente por enteros, retorna true
    */
    public boolean verificarNumero(String numero) {
        try {
            for (int i = 0; i < numero.length(); i++) {
                int numeroAscii = (int) (numero.charAt(i));
                if (numeroAscii < 48 || numeroAscii > 57) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    Se verifica que la fecha ingresada en el cuadro de texto contenga el formato
    estipulado; si no lo tiene, retorna null, si sí lo tiene, retorna el valor pero
    como tipo Date (fecha)
    */
    public Date verificarFecha(String fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaVencimiento = formato.parse(fecha);
            return fechaVencimiento;
        } catch (Exception e) {
            return null;
        }
    }

    /*
    Se verifica si el número de tarjeta ya se encuentra agregado en la lista
    de tarjetas de la persona; si no coincide con ningún valor almacenado, retorna
    false (porque no está duplicada), y en el caso contrario retorna true
    */
    public boolean verificarTarjetaDuplicada(String numero) {
        ArrayList<Tarjeta> tarjetas = this.usuarioActivo.getTarjetas();
        if (tarjetas != null) {
            for (Tarjeta datos : tarjetas) {
                if (datos.getNumero().equals(numero)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Se concatena en una cadena llamada tarjetas los valores de cada tarjeta registrada
    por el usuario, teniendo el nombre, número (con valores ocultos) y fecha. Se retorna
    el String con los valores de todas las tarjetas del cliente
    */
    public String devolverTarjetas() {
        String tarjetas = "";
        for (Tarjeta datos : this.usuarioActivo.getTarjetas()) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fechaVencimiento = formato.format(datos.getFechaVencimiento());
            tarjetas += datos.getNombre() + " - " + esconderTarjeta(datos.getNumero()) + " - " + fechaVencimiento + "\n";
        }
        return tarjetas;
    }

    /*
    Se recorre el número de tarjeta, digito por digito. Si el número se encuentra antes
    de los últimos 4 números de la tarjeta, se concatenará X en una variable llamada
    numeroOculto (con el fin de esconder los números); y si el número es de los últimos 4,
    entonces se concatenará el número sin ocultar. El método retorna el número de la tarjeta
    con valores ocultos
    */
    public String esconderTarjeta(String numero) {
        String numeroOculto = "";
        for (int i = 0; i < numero.length(); i++) {
            if (i > (numero.length() - 5)) {
                numeroOculto += String.valueOf(numero.charAt(i));
            } else {
                numeroOculto += "X";
            }
        }
        return numeroOculto;
    }

    //Método del ActionListener para administrar los clics en componentes
    @Override
    public void actionPerformed(ActionEvent ae) {
        establecerUsuario();
        //Si se pulsa el botón de Registrar
        if (ae.getSource() == this.vMetodoPago.btnRegistrar) {
            String nombre = this.vMetodoPago.txtNombre.getText();
            String numero = this.vMetodoPago.txtNumero.getText();
            String fecha = this.vMetodoPago.txtFecha.getText();
            if (!nombre.isEmpty() && !numero.isEmpty() && !fecha.isEmpty()) {
                if (numero.length() < 16) {
                    this.vMetodoPago.jopMensaje.showMessageDialog(vMetodoPago, "Número de tarjeta inválido");
                } else {
                    if (verificarNumero(numero)) {
                        if (!verificarTarjetaDuplicada(numero)) {
                            Date fechaVencimiento = verificarFecha(fecha);
                            if (fechaVencimiento != null) {
                                this.usuarioActivo.agregarTarjetas(nombre, numero, fechaVencimiento);
                                this.vMetodoPago.txtaTarjetas.setText(devolverTarjetas());
                                this.vMetodoPago.jopMensaje.showMessageDialog(vMetodoPago, "¡Tarjeta agregada exitósamente!");
                            } else {
                                this.vMetodoPago.jopMensaje.showMessageDialog(vMetodoPago, "Ingreso de fecha en formato incorrecto");
                            }
                        } else {
                            this.vMetodoPago.jopMensaje.showMessageDialog(vMetodoPago, "Ya ha ingresado la tarjeta con anterioridad");
                        }
                    } else {
                        this.vMetodoPago.jopMensaje.showMessageDialog(vMetodoPago, "El número de tarjeta debe ser un entero");
                    }
                }
            } else {
                this.vMetodoPago.jopMensaje.showMessageDialog(vMetodoPago, "Debe llenar todos los campos");
            }
        }
        //Si pulsamos el botón Cargar, se llenará el cuadro de texto con los datos de las tarjetas registradas del cliente
        if (ae.getSource() == this.vMetodoPago.btnCargar) {
            this.vMetodoPago.txtaTarjetas.setText(devolverTarjetas());
        }
    }

    //Métodos de WindowListener
    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    //Cuando la ventana se cierra
    @Override
    public void windowClosed(WindowEvent we) {
        limpiarCampos();
        this.vMenuCliente.setVisible(true);
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

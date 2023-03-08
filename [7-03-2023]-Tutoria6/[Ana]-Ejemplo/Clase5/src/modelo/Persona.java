package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Persona {
    
    //Atributos de la clase Persona
    String nombre;
    String apellido;
    String correo;
    String usuario;
    String contrasena;
    String rol;
    String foto;
    ArrayList<Tarjeta> tarjetas;

    //Constructor con parámetros
    public Persona(String nombre, String apellido, String correo, String usuario, String contrasena, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.tarjetas = new ArrayList<>();
    }

    //Constructor vacío
    public Persona() {
    }

    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public ArrayList<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    //Método para agregar al arreglo de tarjetas un nuevo objeto tipo Tarjeta
    public void agregarTarjetas(String nombre, String numero, Date fecha) {
        this.tarjetas.add(new Tarjeta(nombre, numero, fecha));
    }
}
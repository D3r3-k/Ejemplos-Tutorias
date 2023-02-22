package poo;

public class Persona {

    //Atributos
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;

    //Constructor vacío
    public Persona() {
    }

    //Constructor con parámetros
    public Persona(String nombre, String apellido, int edad, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
    }

    //Métodos Getter & Setter
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //Imprime el valor de los atributos
    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre + ""
                + "\nApellido: " + apellido + ""
                + "\nEdad: " + edad + ""
                + "\nCorreo: " + correo);
    }
}

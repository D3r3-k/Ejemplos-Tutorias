package alanp.ejemploclases;

public class Persona {

    private String nombre;
    private String apellido;
    private String genero;
    private int edad;

    Persona (){
        this.nombre = "";
        this.apellido = "";
        this.genero = "";
        this.edad = 0;
    }
    Persona(String nombre, String apellido, String genero, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getGenero(){
        return genero;
    }
    public int getEdad(){
        return edad;
    }
    public String getAnioNacimiento(){
        int anio_nacimiento = 2023 - this.edad;
        return String.valueOf(anio_nacimiento);
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }

}

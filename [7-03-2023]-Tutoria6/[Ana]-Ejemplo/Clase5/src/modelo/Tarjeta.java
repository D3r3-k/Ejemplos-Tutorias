package modelo;

import java.util.Date;

public class Tarjeta {
    
    //Atributos de la clase Tarjeta
    String nombre;
    String numero;
    Date fechaVencimiento;

    //Constructor vacío
    public Tarjeta() {
    }

    //Constructor con parámetros
    public Tarjeta(String nombre, String numero, Date fechaVencimiento) {
        this.nombre = nombre;
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
    }

    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
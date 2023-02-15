/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.d3r3k.clase3;

/**
 *
 * 
 * 
 * @author D3r3k
 */
public class Clase3 {

    public static void main(String[] args) {
        Hijo h = new Hijo();
        h.acceder();
    }

    public void mensaje() {
        System.out.println("Bienvenidos a la tutoria xd");
    }

    private int suma(int x, int y) {
        return x + y;
    }

    protected int suma(int w, int x, int y, int z) {
        return w + x + y + z;
    }

}

class Padre {
    private int numero = 100;
}

class Hijo extends Padre{
    public void acceder() {
        System.out.println("El numero es: " + numero);
    }
}

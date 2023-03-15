package Listas;

import Objetos.Compra;
import Objetos.Usuario;
import java.util.ArrayList;

public class Datos {

    /*
        ArrayList donde guardaremos todos los usuarios
    
        Como es estatico, podemos acceder a la variable "listaDeUsuarios" desde cualquier lugar
            sin crear una instancia.
     */
    public static ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
    public static ArrayList<Compra> listaDeCompras = new ArrayList<>();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.d3r3k.tutorias;

import java.util.Scanner;

/**
 *
 * @author D3r3k
 */
public class Tutorias {

    public static void main(String[] args) {
        // ARRAY DE NUMEROS INICIALIZADA
        int numeros[] = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Mostrando el Array numeros[]");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Numero: " + numeros[i]);
        }

        // ARRAY DE LETRAS INICIALIZADA
        String[] abcdario = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        System.out.println("\nMostrando el Array abcedario[]");
        for (int i = 0; i < abcdario.length; i++) {
            System.out.println("Letra del  Abcdario: " + abcdario[i]);
        }

        // ARRAY  DE OBJETOS CON TAMAÑO DEFINIDO.
        Carros[] lista_carros = new Carros[5];
        lista_carros[0] = new Carros("Carro 1", 2500.50, 2010); //Carro 1/5
        lista_carros[1] = new Carros("Carro 2", 7500.50, 2015); //Carro 2/5
        lista_carros[2] = new Carros("Carro 3", 5500.50, 2017); //Carro 3/5
        lista_carros[3] = new Carros("Carro 4", 3500.50, 2019); //Carro 4/5
        //lista_carros[4] = null                                              //Carro 5/5

        //EJEMPLO CON LA CLASE MATH
        // ELEVAR UN NUMERO X A UN NUMERO Y
        int x = 5;
        int y = 2;
        System.out.println("\nNumero: " + x + " Elevado a " + y);
        Double total = Math.pow(x, y);
        System.out.println("Es:: " + total);

        // NUMERO RANDOM
        /*
            Math.floot(...) -> Aproxima al numero mayor.
            Math.Random() -> Genera un numero aleatorio (ej: 0.21316546)
            ...()*X -> Numero aleatorio de 0 a un numero X
                            ej: 0 a 25
            ...()*X +Y -> Numero aleatorio de Y a un numero X
                            ej: 5 a 25
         */
        System.out.println("\nNumero aleatorio de 0 a 10");
        int random = (int) Math.floor(Math.random()*10);
        System.out.println("Numero Random: " + random);

        System.out.println("\nEjemplo practico, Adivinar un numero aleatorio de 0 a 5");
        //  EJEMPLO PRACTICO | ADIVINA EL NUMERO
        // Array que almacenara los numeros que escogimos con un tamaño de 20
        int[] historial = new int[20];
        // Numero de vidas que tenemos para participar
        int vidas = 3;
        //Numero de oportunidades que sera el indice de nuestro arreglo historial
        //Ejemplo: oportunidad 1 = historial[0] -> posicion 0 porque inicializamos con 0 oportunidades gastadas.
        int oportunidad = 0;
        //Scanner para ingresar valores.
        Scanner sc = new Scanner(System.in);

        //Ciclo While con la condicion que si las vidas no son 0, puede ejecutar el codigo
        while (vidas > 0) {
            // Pedimos el numero
            System.out.print("Adivina el numero de 0 a 5: ");
            int numero = sc.nextInt();
            // Creamos un numero aleatorio de 0 a 5 cada vez que se repita el bucle.
            int num_random = (int) Math.floor(Math.random() * 5);
            /*
                    Creamos la condicional diciendo que: si el numero que ingresamos
                    es  igual al numero ramdom que se genero, imprima un mensaje y 
                    termine el ciclo.
                    De lo contrario:
                    1. Nos imprime un mensaje
                    2. En el arreglo historial con el indice de nuestra oportunidad (osea 0)
                    Definira el numero que escribimos.
                        ej: historial[0] = 5
                        nuestra oportunidad 0 escogimos el numero 5 y lo guardamos en el arreglo historial.
                    3. Restamos una de nuestras vidas.
             */
            if (numero == num_random) {
                System.out.println("Adivinistaste el numero: " + num_random);
                break;
            } else {
                System.out.println("No lo adivinaste, el numero era: "+num_random);
                historial[oportunidad] = numero;
                vidas = vidas - 1;
            }
            //Sumamos 1 a nuestras oportunidades.
            oportunidad++;
            // Repetimos el ciclo hasta ganar o perder las 3 vidas.
        }

        //Al finalizar el  ciclo, imprimimos los numeros que usamos.
        System.out.println("Los numeros que mandaste fueron: ");
        //Creamos un ciclo para iterar todo el arreglo de historial.
        for (int i = 0; i < historial.length; i++) {
            //Comprobamos que el numero en cada posicion no sea 0
            if (historial[i] != 0) {
                //Imprimimos el mensaje.
                System.out.println("|-| " + historial[i]);
            }
        }

    }
}

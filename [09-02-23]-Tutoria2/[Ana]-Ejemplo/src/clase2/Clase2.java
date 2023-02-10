package clase2;

import java.util.Scanner;

/**
 * Programa para biblioteca que, por medio de arreglos, permite el ingreso de
 * libros con su respectivo código, título, autor y descripción. Asímismo,
 * permite la visualización de los libros agregados y la búsqueda por código de
 * los mismos.
 *
 * @author Ana
 */
public class Clase2 {

    public static void main(String[] args) {

        //Declaración de variables
        boolean bandera = true;
        int opcion1 = 0;
        int CANTIDAD_LIBROS = 3;
        int[] codigoLibro = new int[CANTIDAD_LIBROS];
        String[] tituloLibro = new String[CANTIDAD_LIBROS];
        String[] autorLibro = new String[CANTIDAD_LIBROS];
        String[] descripcionLibro = new String[CANTIDAD_LIBROS];

        Scanner lector;
        
        //Comienza el menú
        do {
            System.out.println("===MENÚ==="
                    + "\n1- Agregar un libro"
                    + "\n2- Ver libros"
                    + "\n3- Buscar libro por CÓDIGO"
                    + "\n4- Salir"
                    + "\nEscriba la opción a realizar:");
            lector = new Scanner(System.in);
            try {
                opcion1 = lector.nextInt();
                switch (opcion1) {
                    case 1:
                        lector = new Scanner(System.in);
                        System.out.println("--- AGREGAR UN LIBRO ---");
                        System.out.println("Ingrese el código del libro (número entero):");
                        int codigo = lector.nextInt();
                        System.out.println("Ingrese el título del libro: ");
                        lector = new Scanner(System.in);
                        String titulo = lector.nextLine();
                        System.out.println("Ingrese el autor del libro: ");
                        String autor = lector.nextLine();
                        System.out.println("Ingrese el descripcion del libro: ");
                        String descripcion = lector.nextLine();
                        /*
                        Se recorre el arreglo, verificando que existan posiciones con
                        valor null (es decir, sin valores o vacías), para de esa forma poder
                        asignar los datos de código, título, autor y descripción en
                        dicha posición desocupada de cada arreglo.
                        */
                        for (int i = 0; i < tituloLibro.length; i++) {
                            if (tituloLibro[i] == null) {
                                codigoLibro[i] = codigo;
                                tituloLibro[i] = titulo;
                                autorLibro[i] = autor;
                                descripcionLibro[i] = descripcion;
                                System.out.println("Se agregó el libro con éxito\n");
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("--- VER LIBROS ----");
                        /*
                        Como los arreglos se van llenando de la posición 0 en adelante,
                        si el valor en la posición 0 del arreglo es null o vacía, se
                        da a entender que el arreglo está vacío, es decir, que no se
                        han agregado elementos a este. Por lo que, si está vacío, se
                        imprimirá en consola 'No hay libros disponibles'. Si hay valores
                        distintos a null, se comprueba que sea así y se imprime la
                        información del libro (código, título, autor, descripción).
                        */
                        if (tituloLibro[0] != null) {
                            for (int i = 0; i < tituloLibro.length; i++) {
                                if (tituloLibro[i] != null) {
                                    System.out.println("\n\tCÓDIGO: " + codigoLibro[i] + ""
                                            + "\n\tTítulo: " + tituloLibro[i] + ""
                                            + "\n\tAutor: " + autorLibro[i] + ""
                                            + "\n\tDescripción: " + descripcionLibro[i]);
                                } else {
                                    break;
                                }
                            }
                        } else {
                            System.out.println("No hay libros disponibles");
                        }
                        break;
                    case 3:
                        System.out.println("--- BUSCAR LIBRO POR CÓDIGO ---");
                        System.out.println("Ingrese el código del libro a buscar: ");
                        int indice = -1;
                        lector = new Scanner(System.in);
                        int cod = lector.nextInt();
                        /*
                        En este for, se va a verificar si el código ingresado por
                        el usuario coincide con algún código que se haya ingresado
                        con anterioridad al agregar un libro. Si hay coincidencia,
                        la variable índice tomará el valor de la posición en donde
                        se encuentra dicho código; caso contrario, permanecerá como -1,
                        indicando que no hubo coincidencia.
                        */
                        for (int i = 0; i < codigoLibro.length; i++) {
                            if (cod == codigoLibro[i]) {
                                indice = i;
                                break;
                            }
                        }
                        /*
                        Si indice es distinto de -1, significa que al realizar la búsqueda
                        si coincidió un valor con el código ingresado. Por lo que imprime
                        que se ha encontrado el libro con dicho código, el título del mismo
                        y el autor. Caso contrario, si indice queda con el valor de -1, se 
                        imprime que ningún libro agregado tiene el código proporcionado por
                        el usuario.
                        */
                        if (indice != -1) {
                            System.out.println("Libro encontrado:"
                                    + "\n\tTítulo: " + tituloLibro[indice] + " - "
                                    + "Autor: " + autorLibro[indice] + "\n");
                        } else {
                            System.out.println("No existe ningún libro con el código ingresado");
                        }
                        break;
                    case 4:
                        /*
                        Se declara falsa la bandera, para evitar que se cumpla la condición del
                        ciclo do while, y de esa forma termine la ejecución del mismo.
                        */
                        bandera = false;
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("No ingresó una opción disponible");
                        break;
                }
            } catch (Exception e) {
                System.out.println("[Error]: Dato inválido");
            }
        } while (bandera);
    }
}

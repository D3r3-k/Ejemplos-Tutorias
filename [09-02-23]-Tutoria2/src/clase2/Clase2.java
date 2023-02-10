package clase2;

import java.util.Scanner;

/**
 * Programa para biblioteca que, por medio de arreglos, permite el
 * ingreso de libros con su respectivo código, título, autor y descripción.
 * Asímismo, permite la visualización de los libros agregados y la búsqueda
 * por código de los mismos.
 */

public class Clase2 {

    public static void main(String[] args) {

        boolean bandera = true;
        boolean banderaSubmenu = true;
        int CANTIDAD_LIBROS = 3;
        int[] codigoLibro = new int[CANTIDAD_LIBROS];
        String[] tituloLibro = new String[CANTIDAD_LIBROS];
        String[] autorLibro = new String[CANTIDAD_LIBROS];
        String[] descripcionLibro = new String[CANTIDAD_LIBROS];
        Scanner lector;
        int opcion1 = 0;
        do {
            banderaSubmenu = true;
            System.out.println("=== MENÚ ==="
                    + "\n1- Agregar un libro"
                    + "\n2- Ver libros"
                    + "\n3- Buscar libro por CÓDIGO"
                    + "\n4- Salir"
                    + "\nEscriba la opción a realizar:");
            try {
                lector = new Scanner(System.in);
                opcion1 = lector.nextInt();
                switch (opcion1) {
                    case 1:
                        int contadorDuplicados = 0;
                        if (tituloLibro[(tituloLibro.length - 1)] == null) {
                            try {
                                lector = new Scanner(System.in);
                                System.out.println("--- AGREGAR LIBRO ---");
                                System.out.println("Ingrese el código del libro (número entero):");
                                int codigo = lector.nextInt();
                                for (int cod : codigoLibro) {
                                    if (cod == codigo) {
                                        contadorDuplicados++;
                                        break;
                                    }
                                }
                                if (contadorDuplicados == 0) {
                                    lector = new Scanner(System.in);
                                    System.out.println("Ingrese el título del libro:");
                                    String titulo = lector.nextLine();
                                    System.out.println("Ingrese el autor del libro:");
                                    String autor = lector.nextLine();
                                    System.out.println("Ingrese la descripción del libro:");
                                    String descripcion = lector.nextLine();
                                    for (int i = 0; i < tituloLibro.length; i++) {
                                        if (codigoLibro[i] == 0 && tituloLibro[i] == null
                                                && autorLibro[i] == null && descripcionLibro[i] == null) {
                                            codigoLibro[i] = codigo;
                                            tituloLibro[i] = titulo;
                                            autorLibro[i] = autor;
                                            descripcionLibro[i] = descripcion;
                                            System.out.println("Libro agregado con éxito.\n");
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("Ya existe un libro con el código ingresado\n");
                                }
                            } catch (Exception e) {
                                System.out.println("[ERROR]: No ingresó un código válido\n");
                            }
                        } else {
                            System.out.println("Almacenamiento lleno, no pueden ingresarse más libros\n");
                        }
                        break;
                    case 2:
                        System.out.println("--- VER LIBROS ---");
                        if (tituloLibro[0] != null || descripcionLibro[0] != null) {
                            for (int i = 0; i < tituloLibro.length; i++) {
                                if (tituloLibro[i] != null && descripcionLibro[i] != null) {
                                    System.out.println("\n\tID: " + codigoLibro[i] + ""
                                            + "\n\tTítulo: " + tituloLibro[i] + ""
                                            + "\n\tAutor: " + autorLibro[i] + ""
                                            + "\n\tDescripción: " + descripcionLibro[i] + "\n");
                                } else {
                                    break;
                                }
                            }
                        } else {
                            System.out.println("No hay libros disponibles por el momento.\n");
                        }
                        break;
                    case 3:
                        while (banderaSubmenu) {
                            int indice = -1;
                            try {
                                lector = new Scanner(System.in);
                                System.out.println("--- BUSCAR LIBRO ---"
                                        + "\n1- Buscar libro por código"
                                        + "\n2- Regresar al menú principal"
                                        + "\nIngrese el número correspondiente a la acción a realizar:");
                                int opcion2 = lector.nextInt();
                                if (opcion2 == 1) {
                                    try {
                                        System.out.println("___ BUSCAR LIBRO POR CÓDIGO ___"
                                                + "\nIngrese el código del libro a buscar:");
                                        int codigo = lector.nextInt();
                                        for (int i = 0; i < codigoLibro.length; i++) {
                                            if (codigo == codigoLibro[i]) {
                                                indice = i;
                                                break;
                                            }
                                        }
                                        if (indice != -1) {
                                            System.out.println("Libro encontrado:"
                                                    + "\n\tTítulo: " + tituloLibro[indice] + " - Autor: " + autorLibro[indice] + "\n");
                                        } else {
                                            System.out.println("No existen libros con el código ingresado\n");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("[ERROR]: No ingresó un código válido\n");
                                    }
                                } else if (opcion2 == 2) {
                                    banderaSubmenu = false;
                                } else {
                                    System.out.println("No ingresó una opción existente\n");
                                }
                            } catch (Exception e) {
                                System.out.println("[ERROR]: No ingresó una opción válida\n");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("\nSaliendo...");
                        bandera = false;
                        break;
                    default:
                        System.out.println("No ingresó una opción existente\n");
                }
            } catch (Exception e) {
                opcion1 = 0;
                System.out.println("[ERROR]: No ingresó una opción válida\n");
            }
        } while (bandera);
    }
}
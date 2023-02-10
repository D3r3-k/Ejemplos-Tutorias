package tutorias.practicasiniciales;

import java.util.Scanner;
import java.lang.Math;

public class App {
    public static void main(String[] args) {
        // Declaración del escaner
        Scanner ent;
        // Variable para primer menú
        int op1 = 1;
        // Variable menú aritmetica
        int opa = 1;
        // Variable menú trigonometria
        int opt = 1;

        try {
            // While para seguir ejecutando el menú principal
            while (op1 != 6) {
                // Creación del Scanner
                ent = new Scanner(System.in);
                // Menú Principal
                System.out.println(
                        "\n\n MENU \n1.Aritmetica \n2.Trigonometría \n3.Validar numero Par o Impar \n4.Potencia \n5.Raíz Cuadrada \n6.Salir \nPor favor ingrese el número de la operación que desea realizar: ");
                op1 = Integer.parseInt(ent.nextLine());
                // Switch para el menu principal
                switch (op1) {
                    case 1:
                        // Menú Aritmetica
                        System.out.println(
                                "\n\n----------------ARITMETICA---------------- \n1.Suma \n2.Resta \n3.Multiplicación \n4.División \n\nPor favor ingrese el número de la operación que desea realizar: ");
                        opa = ent.nextInt();
                        // Switch para el menú de aritmetica
                        switch (opa) {
                            case 1:
                                System.out.println("--------------------SUMA--------------------");
                                // Scanner
                                ent = new Scanner(System.in);
                                // Variable para guardar el resultado
                                Double resultadoSuma;
                                System.out.println("\nIngrese el primer número que desea sumar: ");
                                // Variable primer número
                                double num1s = ent.nextDouble();
                                System.out.println("\nIngrese el segundo número que desea sumar: ");
                                // Variable segundo número
                                double num2s = ent.nextDouble();
                                // Operación
                                resultadoSuma = num1s + num2s;
                                System.out.println("El resultado es: " + resultadoSuma);
                                // Pausa para que se presione enter para continuar
                                ent.nextLine();
                                System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                                ent.nextLine();
                                break;
                            case 2:
                                System.out.println("--------------------RESTA--------------------");
                                // Scanner
                                ent = new Scanner(System.in);
                                // Variable para guardar el resultado
                                Double resultadoResta;
                                System.out.println("\nIngrese el primer número que desea restar: ");
                                // Variable primer número
                                double num1r = ent.nextDouble();
                                System.out.println("\nIngrese el segundo número que desea restar: ");
                                // Variable segundo número
                                double num2r = ent.nextDouble();
                                // Operación
                                resultadoResta = num1r - num2r;
                                System.out.println("El resultado es: " + resultadoResta);
                                // Pausa para que se presione enter para continuar
                                ent.nextLine();
                                System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                                ent.nextLine();
                                break;
                            case 3:
                                System.out.println("--------------------MULTIPLICACIÓN--------------------");
                                // Scanner
                                ent = new Scanner(System.in);
                                // Variable para guardar el resultado
                                Double resultadoMultiplicacion;
                                System.out.println("\nIngrese el multiplicando: ");
                                // Variable primer número
                                double multiplicando = ent.nextDouble();
                                System.out.println("\nIngrese el multiplicador: ");
                                // Variable segundo número
                                double multiplicador = ent.nextDouble();
                                // Operación
                                resultadoMultiplicacion = multiplicando * multiplicador;
                                System.out.println("El resultado es: " + resultadoMultiplicacion);
                                // Pausa para que se presione enter para continuar
                                ent.nextLine();
                                System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                                ent.nextLine();
                                break;
                            case 4:
                                System.out.println("--------------------DIVISIÓN--------------------");
                                // Scanner
                                ent = new Scanner(System.in);
                                // Variable para guardar el resultado
                                Double resultadoDivision;
                                System.out.println("\nIngrese el dividendo: ");
                                // Variable primer número
                                double dividendo = ent.nextDouble();
                                System.out.println("\nIngrese el divisor: ");
                                // Variable segundo número
                                double divisor = ent.nextDouble();
                                // For para validar que el divisor no sea cero.
                                if (divisor == 0) {
                                    System.out.println("El divisor no puede ser cero.");
                                    ent.nextLine();
                                    System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                                    ent.nextLine();
                                } else {
                                    resultadoDivision = dividendo / divisor;
                                    System.out.println("El resultado es: " + resultadoDivision);
                                    // Pausa para que se presione enter para continuar
                                    ent.nextLine();
                                    System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                                    ent.nextLine();
                                }
                                break;
                            default:
                                System.out.println("Acción Invalida");
                                break;
                        }
                        break;

                    case 2:
                        // Menú Trigonometría
                        System.out.println(
                                "\n\n----------------TRIGONOMETRÍA---------------- \n1.Seno \n2.Coseno \n3.Tangente  \n\nPor favor ingrese el número de la operación que desea realizar: ");
                        opt = ent.nextInt();
                        // Switch para el menú de trigonometría
                        switch (opt) {
                            case 1:
                                System.out.println("--------------------SENO--------------------");
                                // Scanner
                                ent = new Scanner(System.in);
                                System.out.println("\nIngrese el valor al cual desea aplicarle seno: ");
                                // Variable primer número
                                double gradosSeno = ent.nextDouble();
                                // Convertimos de grados a radianes
                                double radianesSeno = gradosSeno * Math.PI / 180.0;
                                // Operación
                                System.out.println("El resultado en radianes es: " + Math.sin(radianesSeno));
                                // Pausa para que se presione enter para continuar
                                ent.nextLine();
                                System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                                ent.nextLine();
                                break;
                            case 2:
                                System.out.println("--------------------COSENO--------------------");
                                // Scanner
                                ent = new Scanner(System.in);
                                System.out.println("\nIngrese el valor al cual desea aplicarle coseno: ");
                                // Variable primer número
                                double gradosCoseno = ent.nextDouble();
                                // Convertimos de grados a radianes
                                double radianesCoseno = gradosCoseno * Math.PI / 180.0;
                                // Operación
                                System.out.println("El resultado en radianes es: " + Math.cos(radianesCoseno));
                                // Pausa para que se presione enter para continuar
                                ent.nextLine();
                                System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                                ent.nextLine();
                                break;
                            case 3:
                                System.out.println("--------------------TANGENTE--------------------");
                                // Scanner
                                ent = new Scanner(System.in);
                                System.out.println("\nIngrese el valor al cual desea aplicarle tangente: ");
                                // Variable primer número
                                double gradosTangente = ent.nextDouble();
                                // Convertimos de grados a radianes
                                double radianesTangente = gradosTangente * Math.PI / 180.0;
                                // Operación
                                System.out.println("El resultado en radianes es: " + Math.tan(radianesTangente));
                                // Pausa para que se presione enter para continuar
                                ent.nextLine();
                                System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                                ent.nextLine();
                                break;
                            default:
                                System.out.println("Acción Invalida");
                                break;
                        }
                        break;

                    case 3:
                        System.out.println("--------------------NÚMERO PAR O IMPAR--------------------");
                        System.out.println("Ingrese un número: ");
                        ent = new Scanner(System.in);
                        int numero = ent.nextInt();
                        // Validación del número usando modulo que devuelve el residuo de una división
                        // entre 2
                        if ((numero % 2) == 0) {
                            System.out.println("El número ingresado es Par.");
                        } else {
                            System.out.println("El número ingresado es Impar.");
                        }
                        // Pausa para que se presione enter para continuar
                        ent.nextLine();
                        System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                        ent.nextLine();
                        break;
                    case 4:
                        ent = new Scanner(System.in);
                        System.out.println("--------------------POTENCIA--------------------");
                        System.out.println("Ingrese la base: ");
                        int base = ent.nextInt();
                        System.out.println("Ingrese el exponente: ");
                        int exponente = ent.nextInt();
                        //Se utiliza Math.pow con los datos que ya nos ingresaron
                        System.out.println("EL resultado es: " + Math.pow(base, exponente));
                        // Pausa para que se presione enter para continuar
                        ent.nextLine();
                        System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                        ent.nextLine();
                        break;
                    case 5:
                        ent = new Scanner(System.in);
                        System.out.println("--------------------RAÍZ CUADRADA--------------------");
                        System.out.println("Ingrese la base: ");
                        int valor = ent.nextInt();
                        //Se utiliza Math.pow con los datos que ya nos ingresaron
                        System.out.println("EL resultado es: " + Math.sqrt(valor));
                        // Pausa para que se presione enter para continuar
                        ent.nextLine();
                        System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR...");
                        ent.nextLine();
                        break;
                    case 6:
                        System.out.println("Cerrando el Programa");
                        System.exit(0);
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR: Dato Inválido \nCERRANDO EL PROGRAMA");
            System.exit(0);
        }

    }
}

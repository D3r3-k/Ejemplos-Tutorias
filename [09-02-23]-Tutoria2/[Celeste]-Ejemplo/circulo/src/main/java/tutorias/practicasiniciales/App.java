package tutorias.practicasiniciales;

import java.util.Scanner;
import java.lang.Math;

public class App {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("--- CALCULAR ÁREA Y PERÍMETRO DE UN CÍRCULO --" + "\nIngrese el valor del radio: ");

        try {
            double radio = lector.nextDouble();
            if (radio > 0) {
                double area = Math.PI * Math.pow(radio, 2);
                double perimetro = 2 * Math.PI * radio;
                /*
                 * La cantidad de ceros en 100d representa el número de decimales que se van a
                 * imprimir
                 */

                System.out.println("\nÁREA: " + Math.round(area * 100d) / 100d + "" + "\nPERÍMETRO: "
                        + Math.round(perimetro * 100d) / 100d);

            } else {
                System.out.println("El radio ingresado es menor a cero");
            }

        } catch (Exception e) {
            System.out.println("ERROR: El radio ingresado no es un número.");
        }
    }
}

package poo;

import java.util.Scanner;

public class POO {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        /*
        Objeto creado con el constructor vacío
        (no se inicializan los valores de los atributos, sino que quedan por defecto)
         */
        Persona persona1 = new Persona();
        /*
        Objeto creado con el constructor con parámetros
        (se inicializa el valor de los atributos con los valores enviados como parámetros)
         */
        Persona persona2 = new Persona("Luis", "Perez", 36, "luisperez@gmail.com");

        /*
        En este caso, como no se asignó ningún valor a los atributos del objeto persona1
        se quedarán los valores predeterminados (Para String sería null y para int, 0).
        Con los métodos get obtengo el valor de los atributos del objeto
         */
        System.out.println("\n--- PERSONA 1 ---");
        System.out.println("Nombre: " + persona1.getNombre()
                + "\nApellido: " + persona1.getApellido()
                + "\nEdad: " + persona1.getEdad()
                + "\nCorreo: " + persona1.getCorreo());

        /*
        Con el objeto persona2 sí se inicializaron los valores de los atributos, por lo
        que imprimirá los datos enviados en el constructor:
        Nombre: Luis, Apellido: Perez, Edad: 36, Correo: luisperez@gmail.com
         */
        System.out.println("\n--- PERSONA 2 ---");
        persona2.imprimirInformacion();

        /*
        Pedimos al usuario ingresar los valores para nombre, apellido, edad y correo,
        para luego asignar estos a los atributos del objeto persona1
         */
        System.out.println("\n--- Ingresar datos ---");
        lector = new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        String nombre = lector.nextLine();
        lector = new Scanner(System.in);
        System.out.println("Ingrese el apellido: ");
        String apellido = lector.nextLine();
        lector = new Scanner(System.in);
        System.out.println("Ingrese la edad: ");
        int edad = lector.nextInt();
        lector = new Scanner(System.in);
        System.out.println("Ingrese el correo: ");
        String correo = lector.nextLine();
        lector.close();

        /*
        Se establecerán los valores para los atributos del objeto persona1,
        para ello usamos los métodos set, los cuales reciben el dato como parámetro
         */
        System.out.println("\n--- PERSONA 1 (Con valores) ---");
        persona1.setNombre(nombre);
        persona1.setApellido(apellido);
        persona1.setEdad(edad);
        persona1.setCorreo(correo);
        persona1.imprimirInformacion();
    }
}

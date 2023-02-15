package alanp.ejemploclases;

import java.util.Scanner;

public class EjemploClases {

    public static void main(String[] args) {

         //Creamos un objeto de tipo Scanner
        Scanner sc = new Scanner(System.in);

        //Try catch si se crea un error en el programa, mostrara en consola mensaje de error
        try {

            //Mensaje para pedir datos
            System.out.print("Ingrese el número de personas a registrar: ");

            //Lectura de la entrada del usuario
            int num_clientes = sc.nextInt();

            //Creamos un vector que contiene objetos de tipo Persona
            Persona vector[] = new Persona[num_clientes];

            //Ciclo for segun el número de personas que indicara el usuario
            for (int i = 0; i < num_clientes; i++) {
                //Muestra por que iteracion va el ciclo más 1 "debido a que empieza de 0"
                //Queremos que muestre desde el 1 hasta el número de clientes
                System.out.println("Persona No "+(i+1));

                //Ingresar todos los atributos de un objeto de tipo Persona
                System.out.print("Ingrese el nombre: ");
                String nombre = sc.next();

                System.out.print("Ingrese el apellido: ");
                String apellido = sc.next();

                System.out.print("Ingrese el genero: ");
                String genero = sc.next();

                System.out.print("Ingrese el edad: ");
                int edad = sc.nextInt();

                //Método 1 para crear una persona
                //Usando el constructor que recibe todos los atributos
                /*Persona objetoPersona = new Persona(nombre, apellido, genero, edad);*/

                //Método 2 para crear una persona
                //Usando el constructor vacio, luego con los setter definir los atributos de esa persona
                Persona objetoPersona = new Persona();
                objetoPersona.setNombre(nombre);
                objetoPersona.setApellido(apellido);
                objetoPersona.setEdad(edad);
                objetoPersona.setGenero(genero);
                
                //Agregamos al objeto persona en el vector en su posición i
                vector[i] = objetoPersona;
            }
            //Cerramos el escanner para evitar fuga de memoria
            sc.close();

            //Llamamos la funcion imprimirLista para imprimir los datos del vector
            imprimirVector(vector);

        } catch (Exception e) {
            System.out.print("Datos no válidos ");
        }
    }

    static void imprimirVector(Persona vector[]){
        //Ciclo for i, donde se itera segun la longitud del vector
        for (int i = 0; i < vector.length; i++) {
            //Salto de línea
            System.out.println();

            //Imprimir los datos de la persona que esta siendo iterada
            //Los datos se obtienen con los getter del objeto
            System.out.println("El nombre es: "+vector[i].getNombre());
            System.out.println("El apellido es: "+vector[i].getApellido());
            System.out.println("El genero es: "+vector[i].getGenero());
            System.out.println("El edad es: "+vector[i].getEdad());
            System.out.println("El año en que nació es: "+vector[i].getAnioNacimiento());
        }
    }

}

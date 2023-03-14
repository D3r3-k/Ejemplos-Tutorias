package tutorias;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("SACAR FACTORIAL DE 5");
        
        //Método iterativo
        int valor = 0;
        valor = Recursividad.factorialIterativo(5);
        System.out.println(valor);

        //Método recursivo
        valor = Recursividad.factorialRecursivo(5);
        System.out.println(valor);

        //Método fibonacci
        System.out.println("FIBONACCI DE 5");
        valor = Recursividad.fibonacci(5);
        System.out.println(valor);


        //Torres de hanoi
        System.out.println("TORRE CON 5 DISCOS, ORIGEN EN TORRE 1, 2 DISCOS AUXILIARES, DESTINO EN TORRE 3 ");
        Recursividad.Hanoi(5,1,2,3);
    }
}

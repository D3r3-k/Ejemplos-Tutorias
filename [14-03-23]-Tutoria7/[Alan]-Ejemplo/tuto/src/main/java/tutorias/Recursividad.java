package tutorias;

public class Recursividad {

    // SACAR FACTORIAL DE UN NÚMERO CON RECURSIVIDAD
    public static int factorialRecursivo(int n) {
        // DEFINICIÓN DE RETURN SEGUN COMPARACION
        // PRIMERO EN DEFINIR PARA EVITAR CILCOS INFINITOS
        if (n == 0) {
            return 1;
        }

        // CODIGO SI NO CUMPLE LA PRIMERA COMPARACION

        // RECURSIVIDAD
        return factorialRecursivo(n - 1) * n;
    }

    // SACAR FACTORIAL DE UN NÚMERO CON RECURSIVIDAD
    public static int factorialIterativo(int n) {
        int t, resultado;
        resultado = 1;
        for (t = 1; t <= n; t++)
            resultado *= t;
        return resultado;
    }

    // SACAR FACTORIAL DE UN NÚMERO SIN RECURSIVIDAD
    public static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // MOVIMIENTO DENTRO DE TORRES DE HANOI
    public static void Hanoi(int n, int origen,  int auxiliar, int destino){
        if(n==1){
           System.out.println("mover disco de " + origen + " a " + destino);
        }else{
           Hanoi(n-1, origen, destino, auxiliar);
           System.out.println("mover disco de "+ origen + " a " + destino);
           Hanoi(n-1, auxiliar, origen, destino);
        }
    }
}

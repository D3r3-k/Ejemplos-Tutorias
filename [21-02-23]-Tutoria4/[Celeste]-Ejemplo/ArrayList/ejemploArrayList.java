import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ejemploArrayList{
    public static void main(String[] args) {
        listaDinamica();
    }
    
    private static void listaDinamica() {
        ArrayList <String> lista = new ArrayList <String> ();
        char respuesta;
        do{
            lista.add(JOptionPane.showInputDialog("Ingrese un elemento"));
            respuesta=JOptionPane.showInputDialog("Quieren meter más elementos? s/n").charAt(0);
        }while(respuesta=='s'  || respuesta=='S' );
        
        System.out.println("Resultados de la lista dinamica");
        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i));
        }
    }
}
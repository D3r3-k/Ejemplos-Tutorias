import java.util.ArrayList;
import javax.swing.JOptionPane;

public class prueba { 
  public static void main(String[] args) { 
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
    int eliminarPos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición que quiere eliminar"));
    cars.remove(eliminarPos);
    System.out.println(cars);
  } 
}
    



package modelo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Productos {
    
    String nombre;
    int cantidad;
    double precio;
    ArrayList<Productos> ListaProductos = new ArrayList();

    public Productos() {
    }

    public Productos(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public ArrayList<Productos> getListaProductos() {
        return ListaProductos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setListaProductos(ArrayList<Productos> ListaProductos) {
        this.ListaProductos = ListaProductos;
    }
    
     DefaultTableModel modeloTablaproductos = new DefaultTableModel();
    public void TitulosTabla(JTable tablaProductos){
        String[] titulos = new String []{"NOMBRE","CANTIDAD INGRESADA","PRECIO"}; 
        modeloTablaproductos.setColumnIdentifiers(titulos);
        tablaProductos.setModel(modeloTablaproductos); 
    }
    
    
    public void AgregarProductos(JTextField nombre, JTextField cantidad, JTextField precio){
        if(nombre.getText().isEmpty() && cantidad.getText().isEmpty() && precio.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Llene los campos del producto");
        }
        else{
            this.nombre = nombre.getText();
            this.cantidad = Integer.parseInt(cantidad.getText());
            this.precio = Double.parseDouble(precio.getText());
            modeloTablaproductos.addRow(new Object []{this.nombre, this.cantidad, this.precio});
            Productos producto = new Productos(this.nombre, this.cantidad, this.precio);
            
            ListaProductos.add(producto);
            JOptionPane.showMessageDialog(null, "Producto Agregado");
        }
        
    }
    
    public void LimpiarProductos(JTextField nombre, JTextField cantidad, JTextField precio){
        nombre.setText("");
        cantidad.setText("");
        precio.setText("");
    }
    
    public void EliminarProducto(JTable tablaProductos){
        int fila = tablaProductos.getSelectedRow();
        if(tablaProductos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
        else{
            modeloTablaproductos.removeRow(fila); 
        }
    }
}

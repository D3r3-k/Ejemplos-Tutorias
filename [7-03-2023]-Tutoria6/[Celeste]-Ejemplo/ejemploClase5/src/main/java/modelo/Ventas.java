
package modelo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable; 
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Ventas {
    
    Clientes cliente;
    ArrayList<Productos> ListaProductos;
    double subVenta;
    double total;
    

    public Ventas() {
    }

    public Ventas(Clientes cliente, ArrayList<Productos> ListaProductos) {
        this.cliente = cliente;
        this.ListaProductos = ListaProductos;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public ArrayList<Productos> getListaProductos() {
        return ListaProductos;
    }



    public double getSubVenta() {
        return subVenta;
    }


    
    
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public void setListaProductos(ArrayList<Productos> ListaProductos) {
        this.ListaProductos = ListaProductos;
    }
    


    public void setSubVenta(double subVenta) {
        this.subVenta = subVenta;
    }

 

    public void setTotal(double total) {
        this.total = total;
    }

    
    
     DefaultTableModel modeloTablaVentas = new DefaultTableModel();
    public void TitulosTabla(JTable tablaSubtotal){
        String[] titulos = new String []{"NOMBRE PRODUCTO","SUBTOTAL"};  
        modeloTablaVentas.setColumnIdentifiers(titulos);
        tablaSubtotal.setModel(modeloTablaVentas); 
    }
    
    public double CalcularSubtotal(JTextField cantidad, JTable tablaProductos){
        this.subVenta = 0;
        tablaProductos.getSelectedRow();
        for(int i = 0; i < tablaProductos.getRowCount(); i++){
            double valorEnTabla = Double.parseDouble(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2).toString());
            this.subVenta = valorEnTabla * Integer.parseInt(cantidad.getText()); 
        }
        return this.subVenta;
    }
    
    public void AgregarTablaSubtotal(JTextField cantidad, JTable tablaProductos, JTable tablaSubtotal, JLabel total){
        if(cantidad.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad que desea comprar");
        }
        else{
            if(tablaProductos.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null, "Seleccione la fila del producto que desea comprar");
            }
            else{
                modeloTablaVentas.addRow(new Object[] {tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0), this.CalcularSubtotal(cantidad, tablaProductos)});
                total.setText(String.valueOf(this.CalcularTotal(tablaSubtotal)));
                
            }
        }
    }
    
    public double CalcularTotal(JTable tablaSubtotal){
        this.total = 0;
        for(int i = 0; i < tablaSubtotal.getRowCount(); i++){
            double subtotal = Double.parseDouble(tablaSubtotal.getValueAt(i, 1).toString());
            this.total = this.total + subtotal;
        }
        return this.total;
    }
    
    public void EliminarSubtotal(JTable tablaSubtotal, JLabel total){
        int fila = tablaSubtotal.getSelectedRow();
        if(tablaSubtotal.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
        else{
            modeloTablaVentas.removeRow(fila);
            total.setText(String.valueOf(this.CalcularTotal(tablaSubtotal)));
        }
    }
        
    
    
    
}

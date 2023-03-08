
package modelo;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Clientes {
    
    String nombre;
    String apellido;
    String CUI;
    String celular;
    String correo;

    public Clientes() {
    }

    public Clientes(String nombre, String apellido, String CUI, String celular, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CUI = CUI;
        this.celular = celular;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCUI() {
        return CUI;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    DefaultTableModel modelo = new DefaultTableModel();
    public void TitulosTabla(JTable tablaClientes){
        String[] titulos = new String []{"NOMBRE","APELLIDO","CUI","CELULAR","CORREO"};
        modelo.setColumnIdentifiers(titulos);
        tablaClientes.setModel(modelo); 
    }
    
    public void AgregarCliente(JTextField nombre,JTextField apellido, JTextField CUI,JTextField celular,JTextField correo){
        this.nombre = nombre.getText();
        this.apellido = apellido.getText();
        this.CUI = CUI.getText();
        this.celular = celular.getText();
        this.correo = correo.getText();
        modelo.addRow(new Object[]{this.nombre, this.apellido, this.CUI, this.celular, this.correo}); 
        
    }
    
     public void LimpiarClientes(JTextField nombre,JTextField apellido, JTextField CUI,JTextField celular,JTextField correo){
        nombre.setText("");
        apellido.setText("");
        CUI.setText("");
        celular.setText("");
        correo.setText("");
    }
     
    public void EliminarCliente(JTable tablaClientes){
        int fila = tablaClientes.getSelectedRow();
        if(tablaClientes.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
        else{
            modelo.removeRow(fila); 
        }
    }
    
}

package Ventanas;

import Listas.Datos;
import Objetos.Compra;
import Objetos.Usuario;
import javax.swing.table.DefaultTableModel;

public class Tabla extends javax.swing.JFrame {

    public Tabla() {
        initComponents();
        setLocationRelativeTo(null);
        //Quemamos datos por defecto si el arreglo esta vacio.
        if (Datos.listaDeUsuarios.isEmpty()) {
            Usuario u1 = new Usuario("Roberto", "Roberto@gmail.com", "123456");
            Usuario u2 = new Usuario("Alejandro", "Alejandro@gmail.com", "123456");
            Usuario u3 = new Usuario("Andre", "Andre@gmail.com", "123456");
            Usuario u4 = new Usuario("Juan", "Juan@gmail.com", "123456");
            Datos.listaDeUsuarios.add(u1);
            Datos.listaDeUsuarios.add(u2);
            Datos.listaDeUsuarios.add(u3);
            Datos.listaDeUsuarios.add(u4);
            Compra c1 = new Compra(10, "Lugar 1", 250.55, u1);
            Compra c2 = new Compra(25, "Lugar 2", 1250.75, u2);
            Compra c3 = new Compra(30, "Lugar 3", 3250.25, u3);
            Compra c4 = new Compra(4, "Lugar 4", 50.08, u4);
            Datos.listaDeCompras.add(c1);
            Datos.listaDeCompras.add(c2);
            Datos.listaDeCompras.add(c3);
            Datos.listaDeCompras.add(c4);
        }
        /*  Llamamos a la funcion genrarTabla para que ejecute el codigo una vez creado el componente. */
        generarTablaUsuarios();
    }

    // Declaramos una variable modelo de tipo DefaultTableModel
    private DefaultTableModel modelo;
    private void generarTablaUsuarios() {
        // Creamos el modelo de la tabla
        modelo = new DefaultTableModel();

        // Agregamos los nombres de las columnas
        modelo.addColumn("Nombre");
        modelo.addColumn("Correo");
        // Hacemos un bucle para recorrer la lista de usuarios.
        for (Usuario usuario : Datos.listaDeUsuarios) {
            /* Creamos un arreglo llamado fila, de tipo Object
                y agregamos el contenido que queremos mostrar:
            Ejemplo:
            col  -> columna
            var  -> nombre de la variable
            tipo -> tipo de la variable (Arreglo de objetos)
                  tipo    var      col       col     col    
                Object[] fila = [Nombre], [Correo], [etc]
             */
            Object[] fila = {
                usuario.getName(),
                usuario.getEmail()
            };
            // Agregamos una nueva fila con el contenido de la variable fila
            modelo.addRow(fila);
        }
        /*
            Al terminar el bucle, el modelo de la tabla que creamos, 
            se lo declaramos a la tabla de usuarios.
            Utilizamos .repaint() para volver a dibujar la tabla
            y .revalidate() para volver a calcular los espacios del diseño.
         */
        table_usuarios.setModel(modelo);
        table_usuarios.repaint();       // Vuelve a dibujar la tabla
        table_usuarios.revalidate();    // Vuelve a calcular los espacios del diseño
    }
    private void generarTablaCompras() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Cantidad");
        modelo.addColumn("Lugar");
        modelo.addColumn("Total");
        modelo.addColumn("Comprador");
        for (Compra compra : Datos.listaDeCompras) {
            Object[] fila = {
                compra.getCantidad(),
                compra.getLugar(),
                compra.getTotal(),
                compra.getComprador().getName()
            };
            modelo.addRow(fila);
        }
        table_usuarios.setModel(modelo);
        table_usuarios.repaint();
        table_usuarios.revalidate();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_usuarios = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_usuarios);

        jButton2.setText("Mostrar Compras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar Usuarios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        generarTablaCompras();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generarTablaUsuarios();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_usuarios;
    // End of variables declaration//GEN-END:variables
}

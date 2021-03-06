/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 * Pestaña Pedidos
 * @author Fran Sancho
 * @version 1.0
 */
public class Pedidos extends javax.swing.JFrame {
    
    /**
     * Objeto usado para actualizar el contenido
     */
    static public ResultSet r;
    
    /**
     * Objeto usado para conectar con la Base de Datos
     */
    static public Connection connection;
    
    /**
     * Clase constructor de la pestaña Pedidos, desde aquí se inicializan los datos que se van a mostrar en esta pestaña de la aplicación, ejecutando una consulta a la Base de Datos y mostrando en cada textfield y ComboBox los datos correspondientes
     * @throws SQLException En caso de error se encarga de tratar dicho error.
     */
    public Pedidos() throws SQLException {
        initComponents();
        aceptar.setVisible(false);
        cancelar.setVisible(false);
        String url = "jdbc:mysql://localhost:3306/base_datos_ej1";
        String user = "root";
        String pass = "";
        connection = DriverManager.getConnection(url, user, pass);

        Statement s = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "select * FROM pedidos";
        r = s.executeQuery(query);
        //Se inicializa con los datos del primer pedido, añadiendo en cada textfield los campos requeridos mediante setText
        r.first();
        num_pedido.setText(r.getString("NUM_PEDIDO"));
        fecha.setText(r.getString("FECHA"));

        String query2 = "select * FROM clientes";
        ResultSet r2;
        Statement s2 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        r2 = s2.executeQuery(query2);
        
        //Se utiliza el ComboBox para mostrar el cliente
        DefaultComboBoxModel value1 = new DefaultComboBoxModel();

        while (r2.next()) {
            value1.addElement(r2.getString("NOMBRE"));
        }
        Ccliente.setModel(value1);
        Ccliente.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        num_pedido = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        primero = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        ultimo = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        Ccliente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("PEDIDOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Número de pedido");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Fecha");

        num_pedido.setEditable(false);

        primero.setText("Primero");
        primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeroActionPerformed(evt);
            }
        });

        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        ultimo.setText("Último");
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        Ccliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(primero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(anterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(siguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ultimo)
                    .addComponent(volver))
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(num_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(fecha)
                            .addComponent(Ccliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(num_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Ccliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(primero)
                            .addComponent(anterior)
                            .addComponent(siguiente)
                            .addComponent(ultimo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar)
                            .addComponent(nuevo)
                            .addComponent(borrar)
                            .addComponent(volver))
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            r.last();
            num_pedido.setText(r.getString("NUM_PEDIDO"));
            Ccliente.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
            fecha.setText(r.getString("FECHA"));

        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ultimoActionPerformed

    private void primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeroActionPerformed
        try {
            r.first();
            num_pedido.setText(r.getString("NUM_PEDIDO"));
            Ccliente.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
            fecha.setText(r.getString("FECHA"));
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_primeroActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            if (r.previous()) {
                num_pedido.setText(r.getString("NUM_PEDIDO"));
                Ccliente.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
                fecha.setText(r.getString("FECHA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        try {
            if (r.next()) {
                num_pedido.setText(r.getString("NUM_PEDIDO"));
                Ccliente.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
                fecha.setText(r.getString("FECHA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        try {
            String vNum_pedido;
            vNum_pedido = num_pedido.getText();

            String url = "jdbc:mysql://localhost:3306/base_datos_ej1";
            String user = "root";
            String pass = "";
            connection = DriverManager.getConnection(url, user, pass);
            Statement s = connection.createStatement();
            String query = "DELETE FROM pedidos WHERE NUM_PEDIDO=" + vNum_pedido + "";
            int resultado = s.executeUpdate(query);
            String query2 = "select P.*, C.* from pedidos P, clientes C where P.CLIENTE=C.NIF";
            r = s.executeQuery(query2);
            r.first();
            num_pedido.setText(r.getString("NUM_PEDIDO"));
            fecha.setText(r.getString("FECHA"));
            Ccliente.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_borrarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        try {
            String vNum_pedido, vFecha, vCliente, nif;
            vNum_pedido = num_pedido.getText();
            vFecha = fecha.getText();
            
            //Obtener el valor del combo
            vCliente = (String) Ccliente.getSelectedItem();
            
             //Llamar metodo obtener NIF con el valor del combo
            nif = getNIFCliente(vCliente);
            String url = "jdbc:mysql://localhost:3306/base_datos_ej1";
            String user = "root";
            String pass = "";
            connection = DriverManager.getConnection(url, user, pass);
            Statement s = connection.createStatement();
            String query = "update pedidos set FECHA='" + vFecha + "',CLIENTE='" + nif + "' WHERE NUM_PEDIDO='" + vNum_pedido + "'";
            int resultado = s.executeUpdate(query);
            r.refreshRow();
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        try {
            aceptar.setVisible(false);
            cancelar.setVisible(false);

            num_pedido.setEditable(false);
            primero.setEnabled(true);
            ultimo.setEnabled(true);
            siguiente.setEnabled(true);
            anterior.setEnabled(true);
            modificar.setEnabled(true);
            volver.setEnabled(true);
            borrar.setEnabled(true);

            r.first();
            num_pedido.setText(r.getString("NUM_PEDIDO"));
            fecha.setText(r.getString("FECHA"));

            Ccliente.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));

        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {                                        
            try {
                String vNum_pedido, vFecha, vCliente;
                vNum_pedido = num_pedido.getText();
                vFecha = fecha.getText();
                vCliente = (String) Ccliente.getSelectedItem();
                
                String Nif = getNIFCliente(vCliente);
                
                String url = "jdbc:mysql://localhost:3306/base_datos_ej1";
                String user = "root";
                String pass = "";
                connection = DriverManager.getConnection(url, user, pass);
                Statement s = connection.createStatement();
                String query = "insert into pedidos values (" + vNum_pedido + ",'" + vFecha + "','" + Nif + "')";
                int resultado = s.executeUpdate(query);
                
                aceptar.setVisible(false);
                cancelar.setVisible(false);
                num_pedido.setEditable(false);
                primero.setEnabled(true);
                ultimo.setEnabled(true);
                siguiente.setEnabled(true);
                anterior.setEnabled(true);
                modificar.setEnabled(true);
                volver.setEnabled(true);
                borrar.setEnabled(true);
                String query2 = "select P.*, C.Nombre from clientes C, pedidos P where C.NIF=P.Cliente";
                r = s.executeQuery(query2);
                r.first();
                num_pedido.setText(r.getString("NUM_PEDIDO"));
                fecha.setText(r.getString("FECHA"));
                Ccliente.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
                
            } catch (SQLException ex) {
                Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Pedidos ped = new Pedidos();
            ped.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        num_pedido.setText(null);
        fecha.setText(null);
        Ccliente.setSelectedItem(null);

        num_pedido.setEditable(true);
        aceptar.setVisible(true);
        cancelar.setVisible(true);

        primero.setEnabled(false);
        ultimo.setEnabled(false);
        siguiente.setEnabled(false);
        anterior.setEnabled(false);
        modificar.setEnabled(false);
        volver.setEnabled(false);
        borrar.setEnabled(false);
    }//GEN-LAST:event_nuevoActionPerformed
    /**
     * Método que recoje el nombre del cliente en base a su NIF en la Base de Datos
     * @param NIF variable de tipo String que contendrá el NIF del cliente (Números y letra)
     * @return devuelve una variable con el nombre del cliente
     * @since Incluido desde la versión 1.0 de la aplicación
     */
    public static String getNombreCliente(String NIF) {

        String name = "";
        try {
            ResultSet r3;

            Statement s3 = connection.createStatement();
            String queryNombre = "select nombre from clientes WHERE NIF='" + NIF + "'";
            r3 = s3.executeQuery(queryNombre);
            r3.first();
            name = r3.getString("NOMBRE");
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    /**
     * Método que recoje el NIF del cliente en base a su nombre en la Base de Datos
     * @param nombre variable de tipo String que contendrá el nombre del cliente
     * @return devuelve una variable con el NIF del cliente
     * @since Incluido desde la versión 1.0 de la aplicación
     */
    public static String getNIFCliente(String nombre) {

        String vNif = "";

        try {

            ResultSet r3;
            Statement s3 = connection.createStatement();
            String queryNIF = "select NIF from clientes WHERE NOMBRE='" + nombre + "'";
            r3 = s3.executeQuery(queryNIF);
            r3.first();
            vNif = r3.getString("NIF");
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vNif;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pedidos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Ccliente;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton anterior;
    private javax.swing.JButton borrar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton modificar;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextField num_pedido;
    private javax.swing.JButton primero;
    private javax.swing.JButton siguiente;
    private javax.swing.JButton ultimo;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}

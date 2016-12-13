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

public class Articulos extends javax.swing.JFrame {

    static public ResultSet r;
    static public Connection connection;

    public Articulos() throws SQLException {
        initComponents();
        aceptar.setVisible(false);
        cancelar.setVisible(false);
        String url = "jdbc:mysql://localhost:3306/base_datos_ej1";
        String user = "root";
        String pass = "";
        connection = DriverManager.getConnection(url, user, pass);

        Statement s = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "select * from articulos";
        r = s.executeQuery(query);
        r.first();
        codigo.setText(r.getString("COD_ARTICULO"));
        articulo.setText(r.getString("ARTICULO"));         
        peso.setText(r.getString("PESO"));
        categoria.setText(r.getString("CATEGORIA"));
        preciov.setText(r.getString("PRECIO_VENTA"));
        precioc.setText(r.getString("PRECIO_COSTE"));
        existencias.setText(r.getString("EXISTENCIAS"));

        String query2 = "select * FROM fabricantes";
        ResultSet r2;
        Statement s2 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        r2 = s2.executeQuery(query2);
        DefaultComboBoxModel value1 = new DefaultComboBoxModel();

        while (r2.next()) {
            value1.addElement(r2.getString("NOMBRE"));
        }
        Cfabricante.setModel(value1);
        Cfabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        articulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        peso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        categoria = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        preciov = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        precioc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        existencias = new javax.swing.JTextField();
        primero = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        ultimo = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        Cfabricante = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("ARTÍCULOS");
        jLabel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código de artículo");
        jLabel2.setFocusable(false);

        codigo.setEditable(false);
        codigo.setNextFocusableComponent(articulo);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Artículo");
        jLabel3.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Fabricante");
        jLabel4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Peso");
        jLabel5.setFocusable(false);

        peso.setNextFocusableComponent(categoria);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Categoría");
        jLabel6.setFocusable(false);

        categoria.setNextFocusableComponent(preciov);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Precio de venta");
        jLabel7.setFocusable(false);

        preciov.setNextFocusableComponent(precioc);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Precio de coste");
        jLabel8.setFocusable(false);

        precioc.setNextFocusableComponent(existencias);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Existencias");
        jLabel9.setFocusable(false);

        existencias.setNextFocusableComponent(codigo);

        primero.setText("Primero");
        primero.setNextFocusableComponent(anterior);
        primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeroActionPerformed(evt);
            }
        });

        anterior.setText("Anterior");
        anterior.setNextFocusableComponent(siguiente);
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        siguiente.setText("Siguiente");
        siguiente.setNextFocusableComponent(ultimo);
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        ultimo.setText("Último");
        ultimo.setNextFocusableComponent(modificar);
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.setNextFocusableComponent(nuevo);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        nuevo.setText("Nuevo");
        nuevo.setNextFocusableComponent(volver);
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.setNextFocusableComponent(cancelar);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.setNextFocusableComponent(aceptar);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        volver.setText("Volver");
        volver.setNextFocusableComponent(borrar);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        borrar.setText("Borrar");
        borrar.setNextFocusableComponent(primero);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        Cfabricante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(primero)
                                .addGap(18, 18, 18)
                                .addComponent(anterior)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(siguiente)
                                .addGap(18, 18, 18)
                                .addComponent(ultimo)
                                .addGap(18, 18, 18)
                                .addComponent(modificar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(articulo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codigo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoria, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(preciov, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(precioc, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(existencias, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(peso, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cfabricante, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptar))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cancelar)
                    .addComponent(Cfabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(preciov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(precioc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(primero)
                    .addComponent(anterior)
                    .addComponent(siguiente)
                    .addComponent(ultimo)
                    .addComponent(modificar))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo)
                    .addComponent(volver)
                    .addComponent(borrar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeroActionPerformed
        try {
            r.first();
            codigo.setText(r.getString("COD_ARTICULO"));
            articulo.setText(r.getString("ARTICULO"));
            Cfabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
            peso.setText(r.getString("PESO"));
            categoria.setText(r.getString("CATEGORIA"));
            preciov.setText(r.getString("PRECIO_VENTA"));
            precioc.setText(r.getString("PRECIO_COSTE"));
            existencias.setText(r.getString("EXISTENCIAS"));
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_primeroActionPerformed

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            r.last();
            codigo.setText(r.getString("COD_ARTICULO"));
            articulo.setText(r.getString("ARTICULO"));
            Cfabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
            peso.setText(r.getString("PESO"));
            categoria.setText(r.getString("CATEGORIA"));
            preciov.setText(r.getString("PRECIO_VENTA"));
            precioc.setText(r.getString("PRECIO_COSTE"));
            existencias.setText(r.getString("EXISTENCIAS"));
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ultimoActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            if (r.previous()) {
                codigo.setText(r.getString("COD_ARTICULO"));
                articulo.setText(r.getString("ARTICULO"));
               Cfabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
                peso.setText(r.getString("PESO"));
                categoria.setText(r.getString("CATEGORIA"));
                preciov.setText(r.getString("PRECIO_VENTA"));
                precioc.setText(r.getString("PRECIO_COSTE"));
                existencias.setText(r.getString("EXISTENCIAS"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        try {
            if (r.next()) {
                codigo.setText(r.getString("COD_ARTICULO"));
                articulo.setText(r.getString("ARTICULO"));
                Cfabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
                peso.setText(r.getString("PESO"));
                categoria.setText(r.getString("CATEGORIA"));
                preciov.setText(r.getString("PRECIO_VENTA"));
                precioc.setText(r.getString("PRECIO_COSTE"));
                existencias.setText(r.getString("EXISTENCIAS"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        codigo.setText(null);
        articulo.setText(null);
        Cfabricante.setSelectedItem(null);
        //fabricante.setText(null);
        peso.setText(null);
        categoria.setText(null);
        preciov.setText(null);
        precioc.setText(null);
        existencias.setText(null);

        codigo.setEditable(true);
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

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        try {
            aceptar.setVisible(false);
            cancelar.setVisible(false);

            codigo.setEditable(false);
            primero.setEnabled(true);
            ultimo.setEnabled(true);
            siguiente.setEnabled(true);
            anterior.setEnabled(true);
            modificar.setEnabled(true);
            volver.setEnabled(true);
            borrar.setEnabled(true);

            r.first();
            codigo.setText(r.getString("COD_ARTICULO"));
            articulo.setText(r.getString("ARTICULO"));
            //fabricante.setText(r.getString("NOMBRE"));
            Cfabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
            peso.setText(r.getString("PESO"));
            categoria.setText(r.getString("CATEGORIA"));
            preciov.setText(r.getString("PRECIO_VENTA"));
            precioc.setText(r.getString("PRECIO_COSTE"));
            existencias.setText(r.getString("EXISTENCIAS"));
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        try {
            String vCodigo, vFabricante, vArticulo, vPeso, vCategoria, vPreciov, vPrecioc, vExistencias;
            
            vCodigo = codigo.getText();
            vArticulo = articulo.getText();
            
            //Obtener el valor del combo
            vFabricante = (String) Cfabricante.getSelectedItem();
            
            //Llamar metodo obtener codigo con el valor del combo
            int Cod = getCodigoFabricante(vFabricante);
            
            ///Este codigo lo actualizo en la bbdd
                               
            vPeso = peso.getText();
            vCategoria = categoria.getText();
            vPreciov = preciov.getText();
            vPrecioc = precioc.getText();
            vExistencias = existencias.getText();

           
            Statement s = connection.createStatement();
            String query = "update articulos set COD_ARTICULO='" + vCodigo + "', ARTICULO='" + vArticulo + "', FABRICANTE=" + Cod + ", PESO=" + vPeso + ", CATEGORIA='" + vCategoria + "', PRECIO_VENTA=" + vPreciov + ", PRECIO_COSTE=" + vPrecioc + ", EXISTENCIAS=" + vExistencias + " WHERE COD_ARTICULO='" + vCodigo + "'";
            int resultado = s.executeUpdate(query);
            r.refreshRow();
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {
            String vCodigo, vArticulo, vFabricante, vPeso, vCategoria, vPreciov, vPrecioc, vExistencias;
            vCodigo = codigo.getText();
            vArticulo = articulo.getText();
            vFabricante = (String) Cfabricante.getSelectedItem();
            vPeso = peso.getText();
            vCategoria = categoria.getText();
            vPreciov = preciov.getText();
            vPrecioc = precioc.getText();
            vExistencias = existencias.getText();
            
            int Cod = getCodigoFabricante(vFabricante);
            
            
            String url = "jdbc:mysql://localhost:3306/base_datos_ej1";
            String user = "root";
            String pass = "";
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement s = connection.createStatement();
            String query = "insert into articulos values ('" + vCodigo + "','" + vArticulo + "'," + Cod + "," + vPeso + ",'" + vCategoria + "'," + vPreciov + "," + vPrecioc + "," + vExistencias + ")";
            int resultado = s.executeUpdate(query);

            aceptar.setVisible(false);
            cancelar.setVisible(false);
            codigo.setEditable(false);
            primero.setEnabled(true);
            ultimo.setEnabled(true);
            siguiente.setEnabled(true);
            anterior.setEnabled(true);
            modificar.setEnabled(true);
            volver.setEnabled(true);
            borrar.setEnabled(true);
            String query2 = "select A.*, F.Nombre from articulos A, fabricantes F where A.Fabricante=F.Cod_Fabricante";
            r = s.executeQuery(query2);
            r.first();
            codigo.setText(r.getString("COD_ARTICULO"));
            articulo.setText(r.getString("ARTICULO"));
            Cfabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
            //fabricante.setText(r.getString("NOMBRE"));
            peso.setText(r.getString("PESO"));
            categoria.setText(r.getString("CATEGORIA"));
            preciov.setText(r.getString("PRECIO_VENTA"));
            precioc.setText(r.getString("PRECIO_COSTE"));
            existencias.setText(r.getString("EXISTENCIAS"));
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        try {
            String vCodigo;
            vCodigo = codigo.getText();

            String url = "jdbc:mysql://localhost:3306/base_datos_ej1";
            String user = "root";
            String pass = "";
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement s = connection.createStatement();
            String query = "DELETE FROM articulos WHERE COD_ARTICULO='" + vCodigo + "'";
            int resultado = s.executeUpdate(query);
            String query2 = "select A.* F.Nombre from articulos A, fabricantes F where A.Fabricante=F.Cod_Fabricante";
            r = s.executeQuery(query2);
            r.first();
            codigo.setText(r.getString("COD_ARTICULO"));
            articulo.setText(r.getString("ARTICULO"));
            //fabricante.setText(r.getString("NOMBRE"));
            peso.setText(r.getString("PESO"));
            categoria.setText(r.getString("CATEGORIA"));
            preciov.setText(r.getString("PRECIO_VENTA"));
            precioc.setText(r.getString("PRECIO_COSTE"));
            existencias.setText(r.getString("EXISTENCIAS"));
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_borrarActionPerformed

    public static String getNombreFabricante(int codigo) {

        String name = "";
        try {
            ResultSet r3;

            Statement s3 = connection.createStatement();
            String queryNombre = "select nombre from fabricantes WHERE cod_fabricante=" + codigo;
            r3 = s3.executeQuery(queryNombre);
            r3.first();
            name = r3.getString("NOMBRE");            
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

    public static int getCodigoFabricante(String nombre) {
        int vCodigo = 0;
        
        try {

            ResultSet r3;
            Statement s3 = connection.createStatement();
            String queryCodigo = "select cod_fabricante from fabricantes WHERE nombre='" + nombre+"'";
            r3 = s3.executeQuery(queryCodigo);
            r3.first();
            vCodigo = r3.getInt("COD_FABRICANTE");
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vCodigo;
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
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Articulos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cfabricante;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton anterior;
    private javax.swing.JTextField articulo;
    private javax.swing.JButton borrar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField categoria;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField existencias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton modificar;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextField peso;
    private javax.swing.JTextField precioc;
    private javax.swing.JTextField preciov;
    private javax.swing.JButton primero;
    private javax.swing.JButton siguiente;
    private javax.swing.JButton ultimo;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}

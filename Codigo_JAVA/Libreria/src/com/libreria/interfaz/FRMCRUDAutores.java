/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.libreria.interfaz;

import com.libreria.DTOS.LibrosAutoresDTO;
import com.libreria.baseDatos.entidades.Autor;
import com.libreria.baseDatos.serviciosCRUD.ServicioCRUDAutor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author j_seb
 */
public class FRMCRUDAutores extends javax.swing.JFrame {
    
    private static final String OPERACION_INSERTAR = "INSERTAR";
    
    private static final String OPERACION_ACTUALIZAR = "ACTUALIZAR";
    
    private static final String OPERACION_ELIMINAR = "ELIMINAR";
    
    private String operacionCRUD = "";
    
    private List<Autor> listAutores = new ArrayList<>();
    
    private DefaultTableModel modeloTabla;
    
    private ServicioCRUDAutor srvAutor = new ServicioCRUDAutor();
    
    public Autor autorProcesar = new Autor();

    /**
     * Creates new form FRMCRUDAutores
     */
    public FRMCRUDAutores() {
        initComponents();
        arrancarFormulario();
    }
    
    private void arrancarFormulario(){
        limpiarTabla();
        inicializarTabla();
        buscarAutores();
        encerarDatos();
    }
    
    private void inicializarTabla(){
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Código Autor");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha Nacimiento");
        modeloTabla.addColumn("Sexo");
        modeloTabla.addColumn("Nacionalidad");
    }
    
    private void encerarDatos(){
        txtCodigo.setText("");
        txtNombre.setText("");
        txtFechaNacimiento.setText("");
        lstNacionalidad.setSelectedIndex(0);
        lstSexo.setSelectedIndex(0);
        autorProcesar = new Autor();
        operacionCRUD="";
    }
    
    private void procesarDatosAutor(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Long codigo = new Long(-1);
        try {
            if(txtCodigo.getText()!=null && !txtCodigo.getText().isEmpty()){
                codigo = new Long(txtCodigo.getText());
            }
            
            if(codigo.equals(new Long(-1)) && (operacionCRUD.equals(OPERACION_ACTUALIZAR) || operacionCRUD.equals(OPERACION_ELIMINAR))){
                autorProcesar = new Autor();
                autorProcesar.setCodigoAutor(codigo);
            }else{
                autorProcesar = new Autor(
                codigo, 
                txtNombre.getText(), 
                dateFormat.parse(txtFechaNacimiento.getText()) , 
                lstSexo.getSelectedItem().toString(), 
                lstNacionalidad.getSelectedItem().toString());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falla al procesar los datos del autor " + e.getMessage());
        }
        
    
    }
    
    private void limpiarTabla(){
        modeloTabla = new DefaultTableModel();
    }
    
    private void buscarAutores(){
        try {
            listAutores = srvAutor.obtenerAutores();  
            for(Autor aut:listAutores){
                modeloTabla.addRow(new Object[]{
                    aut.getCodigoAutor(),
                    aut.getNombreAutor(),
                    aut.getFechaNacimiento(),
                    aut.getSexo(),
                    aut.getNacionalidad()
                });
            }
            tblAutores.setModel(modeloTabla);
        } catch (Exception e) {
            System.err.println("Error al listar autores " + e);
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lstSexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lstNacionalidad = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAutores = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Autor"));

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        txtCodigo.setText("jTextField1");
        txtCodigo.setEnabled(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtNombre.setText("jTextField1");

        jLabel3.setText("Fecha Nacimiento:");

        txtFechaNacimiento.setText("jTextField2");

        jLabel4.setText("Sexo:");

        lstSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONE>", "MASCULINO", "FEMENINO" }));
        lstSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lstSexoActionPerformed(evt);
            }
        });

        jLabel5.setText("Nacionalidad:");

        lstNacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONE>", "ECUADOR", "COLOMBIA", "PERU", "ESPAÑA", "ESTADOS UNIDOS", "OTRO" }));
        lstNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lstNacionalidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lstNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lstSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lstSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lstNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista Autores"));

        tblAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAutores);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        btnNuevo.setText("Nuevo Autor");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar Autor");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar Autor");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar Autor");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar Autores");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lstNacionalidadActionPerformed

    private void tblAutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutoresMouseClicked
        int filaSeleccionada = tblAutores.rowAtPoint(evt.getPoint());
        txtCodigo.setText(tblAutores.getValueAt(filaSeleccionada, 0).toString());
        txtNombre.setText(tblAutores.getValueAt(filaSeleccionada, 1).toString());
        txtFechaNacimiento.setText(tblAutores.getValueAt(filaSeleccionada, 2).toString());
        lstSexo.setSelectedItem(tblAutores.getValueAt(filaSeleccionada, 3).toString());
        lstNacionalidad.setSelectedItem(tblAutores.getValueAt(filaSeleccionada, 4).toString());
    }//GEN-LAST:event_tblAutoresMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        operacionCRUD = OPERACION_INSERTAR;
        procesarDatosAutor();
        try {
            srvAutor.autorInsertar(autorProcesar);
            JOptionPane.showMessageDialog(null, "Registro insertado exitosamente");
            arrancarFormulario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falla en el guardar registro " + e.getMessage());
        }
        if(txtCodigo.getText().isEmpty()|| txtNombre.getText().isEmpty()||txtFechaNacimiento.getText().isEmpty()||lstSexo.getSelectedItem()==null||lstNacionalidad.getSelectedItem()==null){
        JOptionPane.showMessageDialog(this,"No dejar los campos vacios");
    }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        arrancarFormulario();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
    if(txtCodigo.getText().isEmpty()|| txtNombre.getText().isEmpty()||txtFechaNacimiento.getText().isEmpty()||lstSexo.getSelectedItem()==null||lstNacionalidad.getSelectedItem()==null){
        JOptionPane.showMessageDialog(this,"No dejar los campos vacios");
    }
        encerarDatos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        try {
            operacionCRUD = OPERACION_ACTUALIZAR;
            procesarDatosAutor();
            if(!autorProcesar.getCodigoAutor().equals(new Long(-1))){
                srvAutor.autorActualizar(autorProcesar);
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
                arrancarFormulario();
            }else{
                JOptionPane.showMessageDialog(null, "Error: Seleccione un registro para actualizar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falla en el actualizar registro " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            operacionCRUD = OPERACION_ELIMINAR;
            procesarDatosAutor();
            if(!autorProcesar.getCodigoAutor().equals(new Long(-1))){
                srvAutor.autorEliminar(autorProcesar);
                JOptionPane.showMessageDialog(null, "Registro elimnado exitosamente");
                arrancarFormulario();
            }else{
                JOptionPane.showMessageDialog(null, "Error: Seleccione un registro para eliminar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falla en el ELIMINAR registro " + e.getMessage());
        }
        if(txtCodigo.getText().isEmpty()|| txtNombre.getText().isEmpty()||txtFechaNacimiento.getText().isEmpty()||lstSexo.getSelectedItem()==null||lstNacionalidad.getSelectedItem()==null){
        JOptionPane.showMessageDialog(this,"No dejar los campos vacios");
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void lstSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstSexoActionPerformed
        
    }//GEN-LAST:event_lstSexoActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    /**s
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
            java.util.logging.Logger.getLogger(FRMCRUDAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMCRUDAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMCRUDAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMCRUDAutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMCRUDAutores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lstNacionalidad;
    private javax.swing.JComboBox<String> lstSexo;
    private javax.swing.JTable tblAutores;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

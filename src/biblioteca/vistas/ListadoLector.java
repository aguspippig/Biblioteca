
package biblioteca.vistas;

import biblioteca.accesoADatos.*;
import biblioteca.entidades.*;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marti
 */
public class ListadoLector extends javax.swing.JInternalFrame {

    private LectorData lectorData = new LectorData();
    private java.util.List<Lector> listaLector = new ArrayList<Lector>();

    private DefaultTableModel modelo = new DefaultTableModel() {
      
    };

    
    public ListadoLector() {
        initComponents();
        cabecera();
        
    }

   
    @SuppressWarnings("unchecked")
    
    private void cabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Mail");
        modelo.addColumn("Telefono");
       // modelo.addColumn("Estado");
        jtLector.setModel(modelo);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtLector = new javax.swing.JTable();
        jrLectorActivos = new javax.swing.JRadioButton();
        jrAtrasados = new javax.swing.JRadioButton();
        jrLectoresNoActivos = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Listado de Lectores");

        jtLector.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtLector);

        jrLectorActivos.setText("Lectores Activos");
        jrLectorActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrLectorActivosActionPerformed(evt);
            }
        });

        jrAtrasados.setText("Lectores Atrasados");
        jrAtrasados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrAtrasadosActionPerformed(evt);
            }
        });

        jrLectoresNoActivos.setText("Lectores no activos");
        jrLectoresNoActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrLectoresNoActivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jrLectorActivos)
                .addGap(77, 77, 77)
                .addComponent(jrLectoresNoActivos)
                .addGap(55, 55, 55)
                .addComponent(jrAtrasados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrLectorActivos)
                    .addComponent(jrLectoresNoActivos)
                    .addComponent(jrAtrasados))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrLectorActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrLectorActivosActionPerformed
       borrarFilas();
       if(jrLectorActivos.isSelected()){
    jrLectoresNoActivos.setSelected(false);
    jrAtrasados.setSelected(false);
    
}

     //   Lector lector = (Lector) jcLector.getModel().getSelectedItem();
        
      //  if(jrLectorActivos.isSelected()){
      listaLector= lectorData.listarLectores();
        for (Lector lectore : listaLector) {
            modelo.addRow(new Object[]{
                
                lectore.getNroSocio(),
                lectore.getDni(),
                lectore.getApellido(),
                lectore.getNombre(),
                lectore.getDomicilio(),
                lectore.getMail(),
                lectore.getTelefono()}
               // lectore.isEstado()}
            );
        }
                               
    
    }//GEN-LAST:event_jrLectorActivosActionPerformed

    private void jrAtrasadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrAtrasadosActionPerformed
borrarFilas();
        
        if(jrAtrasados.isSelected()){
    jrLectorActivos.setSelected(false);
    jrLectoresNoActivos.setSelected(false);
    
}


listaLector = lectorData.listaDeAtrasos();

        for (Lector lectore : listaLector) {
            
            modelo.addRow(new Object[]{
                
                lectore.getNroSocio(),
                lectore.getDni(),
                lectore.getApellido(),
                lectore.getNombre(),
                lectore.getDomicilio(),
                lectore.getMail(),
                lectore.getTelefono()}
              
            );
            
        }
                                           
    }//GEN-LAST:event_jrAtrasadosActionPerformed

    private void jrLectoresNoActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrLectoresNoActivosActionPerformed
borrarFilas();

if(jrLectoresNoActivos.isSelected()){
    jrLectorActivos.setSelected(false);
    jrAtrasados.setSelected(false);
    
}

listaLector = lectorData.listarLectoresNoActivos();

        for (Lector lectore : listaLector) {
            
            modelo.addRow(new Object[]{
                
                lectore.getNroSocio(),
                lectore.getDni(),
                lectore.getApellido(),
                lectore.getNombre(),
                lectore.getDomicilio(),
                lectore.getMail(),
                lectore.getTelefono()}
               
            );
            
        }

    
    }//GEN-LAST:event_jrLectoresNoActivosActionPerformed

   
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
            java.util.logging.Logger.getLogger(ListadoLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoLector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton jrAtrasados;
    private javax.swing.JRadioButton jrLectorActivos;
    private javax.swing.JRadioButton jrLectoresNoActivos;
    private javax.swing.JTable jtLector;
    // End of variables declaration//GEN-END:variables


    private void borrarFilas() {
        int f = jtLector.getRowCount() - 1;

        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
   
}

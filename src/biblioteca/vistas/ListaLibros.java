/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.vistas;

import biblioteca.accesoADatos.LibroData;
import biblioteca.entidades.Libro;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public class ListaLibros extends javax.swing.JInternalFrame {
    private List<Libro> libros = new ArrayList<>();
    private LibroData ld = new LibroData();
    private DefaultTableModel jModelo= new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    /**
     * Creates new form ListaLibros
     */
    public ListaLibros() {
        initComponents();
        cabecera();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jbModificar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jrDisponibles = new javax.swing.JRadioButton();
        jrNoDisponibles = new javax.swing.JRadioButton();
        jbNuevo = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE LIBROS");

        jtTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtTabla);

        jbModificar.setText("MODIFICAR");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbSalir.setText("SALIR");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrDisponibles);
        jrDisponibles.setText("Disponibles");
        jrDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrDisponiblesActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrNoDisponibles);
        jrNoDisponibles.setText("No disponibles");
        jrNoDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNoDisponiblesActionPerformed(evt);
            }
        });

        jbNuevo.setText("NUEVO");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel2.setText("Busqueda por autor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jbNuevo)
                .addGap(82, 82, 82)
                .addComponent(jbModificar)
                .addGap(83, 83, 83)
                .addComponent(jbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrDisponibles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrNoDisponibles)
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrDisponibles)
                    .addComponent(jrNoDisponibles))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar)
                    .addComponent(jbNuevo)
                    .addComponent(jbSalir))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed

        ModificarLibro mLibros = new ModificarLibro();
        mLibros.setVisible(true);
        biblioteca.Escritorio.add(mLibros);
        biblioteca.Escritorio.moveToFront(mLibros);
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jrDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrDisponiblesActionPerformed
        borrarFilas();
        libros = ld.listarLibros();
        for (Libro libro : libros) {

            jModelo.addRow(new Object[]{
                libro.getIsbn(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnio(),
                libro.getTipo(),
                libro.getEditorial()});

        }
    }//GEN-LAST:event_jrDisponiblesActionPerformed

    private void jrNoDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoDisponiblesActionPerformed
        borrarFilas();
        libros = ld.listarNoLibros();
        for (Libro libro : libros) {

            jModelo.addRow(new Object[]{
                libro.getIsbn(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnio(),
                libro.getTipo(),
                libro.getEditorial()});

        }
    
    }//GEN-LAST:event_jrNoDisponiblesActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        GestionLibros gLibros = new GestionLibros();
        gLibros.setVisible(true);
        biblioteca.Escritorio.add(gLibros);
        biblioteca.Escritorio.moveToFront(gLibros);
    }//GEN-LAST:event_jbNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrDisponibles;
    private javax.swing.JRadioButton jrNoDisponibles;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables
    public void cabecera(){
        
        jModelo.addColumn("ISBN");
        jModelo.addColumn("Titulo");
        jModelo.addColumn("Autor");
        jModelo.addColumn("Año");
        jModelo.addColumn("Tipo");
        jModelo.addColumn("Editorial");
        jtTabla.setModel(jModelo);
    }
    private void borrarFilas() {
        int f = jtTabla.getRowCount() - 1;

        for (; f >= 0; f--) {
            jModelo.removeRow(f);
        }
    }
}

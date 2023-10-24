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
        armarCombobox();
        jtBusqueda.setEnabled(false);
        jcCategorias.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        jcBuscar = new javax.swing.JCheckBox();
        jtBusqueda = new javax.swing.JTextField();
        jcCategorias = new javax.swing.JComboBox<>();

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
        jrDisponibles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrDisponibles.setText("Disponibles");
        jrDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrDisponiblesActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrNoDisponibles);
        jrNoDisponibles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Busqueda");

        jcBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcBuscarActionPerformed(evt);
            }
        });

        jtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jbNuevo)
                .addGap(80, 80, 80)
                .addComponent(jbModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcBuscar)
                        .addGap(28, 28, 28)
                        .addComponent(jcCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrDisponibles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrNoDisponibles)
                        .addGap(110, 110, 110))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jcBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrDisponibles)
                    .addComponent(jrNoDisponibles))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void jtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaKeyReleased
        borrarFilas();
        libros = ld.listarLibros();
        String opc = jcCategorias.getModel().getSelectedItem().toString();
        
        if (opc.equals("Autor")){
            for (Libro libro : libros) {
                if(libro.getAutor().toLowerCase().startsWith(jtBusqueda.getText().toLowerCase())){                
                    jModelo.addRow(new Object[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getAnio(),
                    libro.getTipo(),
                    libro.getEditorial()});
                }         
            }
        }
        if(opc.equals("Titulo")){
            for (Libro libro : libros) {
                if(libro.getTitulo().toLowerCase().startsWith(jtBusqueda.getText().toLowerCase())){                
                    jModelo.addRow(new Object[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getAnio(),
                    libro.getTipo(),
                    libro.getEditorial()});
                }         
            }
        }
        if(opc.equals("Tipo")){
            for (Libro libro : libros) {
                if(libro.getTipo().toLowerCase().startsWith(jtBusqueda.getText().toLowerCase())){                
                    jModelo.addRow(new Object[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getAnio(),
                    libro.getTipo(),
                    libro.getEditorial()});
                }         
            }
        }
        if(opc.equals("Editorial")){
            for (Libro libro : libros) {
                if(libro.getEditorial().toLowerCase().startsWith(jtBusqueda.getText().toLowerCase())){                
                    jModelo.addRow(new Object[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getAnio(),
                    libro.getTipo(),
                    libro.getEditorial()});
                }         
            }
        }
        if(opc.equals("ISBN")){
            for (Libro libro : libros) {
                if((String.valueOf(libro.getIsbn())).startsWith(jtBusqueda.getText())){                
                    jModelo.addRow(new Object[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getAnio(),
                    libro.getTipo(),
                    libro.getEditorial()});
                }         
            }
        }
        if(opc.equals("Anio")){
            for (Libro libro : libros) {
                if((String.valueOf(libro.getAnio())).startsWith(jtBusqueda.getText())){                
                    jModelo.addRow(new Object[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getAnio(),
                    libro.getTipo(),
                    libro.getEditorial()});
                }         
            }
        }
    }//GEN-LAST:event_jtBusquedaKeyReleased

    private void jcBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcBuscarActionPerformed
        limpiar();
        if (verificarCuadrado()){
            jtBusqueda.setEnabled(true);
            jcCategorias.setEnabled(true);
        } else {
            jtBusqueda.setEnabled(false);
            jcCategorias.setEnabled(false);
        }
    }//GEN-LAST:event_jcBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcBuscar;
    private javax.swing.JComboBox<String> jcCategorias;
    private javax.swing.JRadioButton jrDisponibles;
    private javax.swing.JRadioButton jrNoDisponibles;
    private javax.swing.JTextField jtBusqueda;
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
    private boolean verificarCuadrado(){
        if (jcBuscar.isSelected()){
            return true;
    } else return false;
    }
    private void limpiar(){
        jtBusqueda.setText("");
    }
    private void armarCombobox(){
     
     jcCategorias.addItem("ISBN");
     jcCategorias.addItem("Titulo");
     jcCategorias.addItem("Autor");
     jcCategorias.addItem("Anio");
     jcCategorias.addItem("Tipo");
     jcCategorias.addItem("Editorial");
     }
 
}

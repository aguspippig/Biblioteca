/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.vistas;

import biblioteca.accesoADatos.EjemplarData;
import biblioteca.accesoADatos.LibroData;
import biblioteca.entidades.Ejemplar;
import biblioteca.entidades.EstadoEjemplar;
import biblioteca.entidades.Libro;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Florencia
 */
public class AgregarEjemplar extends javax.swing.JInternalFrame {

    private LibroData libroData = new LibroData();
    private EjemplarData ejData = new EjemplarData();
    private ArrayList<Libro> listaLibros = new ArrayList<>();
    private ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();
    private DefaultTableModel jtEjemplarModelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    /**
     * Creates new form ListaEjemplares
     */
    public AgregarEjemplar() {
        initComponents();
        armarCabecera();

        //cargarComboBoxLibroVacio();
        //cargarComboBoxEstadoVacio();

        cargarComboBoxLibro();
        cargarComboBoxEstado();
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
        jLabel3 = new javax.swing.JLabel();
        jcbLibro = new javax.swing.JComboBox<>();
        jcbEstado = new javax.swing.JComboBox<>();
        jbAgregar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEj = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jtCantidad = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGREGAR EJEMPLAR");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione un libro");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Seleccione un estado");

        jcbLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbLibroMouseClicked(evt);
            }
        });

        jcbEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbEstadoMouseClicked(evt);
            }
        });

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jtEj.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtEj);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jcbLibro, 0, 398, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jbAgregar))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jcbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jbLimpiar))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLimpiar))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        // TODO add your handling code here:

        try {

            /*if (jcbLibro.getModel().getSelectedItem() == null || jcbEstado.getModel().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione un item.");
                return;
            }*/

            borrarFilas();

            int cantidad = Integer.valueOf(jtCantidad.getText());

            Libro ejLibro = (Libro) jcbLibro.getModel().getSelectedItem();

            EstadoEjemplar estadoEj = (EstadoEjemplar) jcbEstado.getModel().getSelectedItem();

            for (int i = 1; i <= cantidad; i++) {
                Ejemplar ejNvo = new Ejemplar();

                ejNvo.setLibro(ejLibro);
                ejNvo.setEstado(estadoEj);

                ejData.agregarEjemplar(ejNvo);

                listaEjemplares.add(ejNvo);
            }
            
            JOptionPane.showMessageDialog(null, "Ejemplares añadidos correctamente.");

            for (Ejemplar lEj : listaEjemplares) {
                jtEjemplarModelo.addRow(new Object[]{
                    lEj.getCodigo(),
                    lEj.getLibro().getIsbn(),
                    lEj.getLibro().getTitulo(),
                    lEj.getLibro().getAutor(),
                    lEj.getEstado(),});

            }//finForEach

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Seleccione los items.");
        } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(this,"El cuadro cantidad debe ser un numero.");
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jcbLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbLibroMouseClicked
        // TODO add your handling code here:
        cargarComboBoxLibro();
    }//GEN-LAST:event_jcbLibroMouseClicked

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        cargarComboBoxLibroVacio();
        cargarComboBoxEstadoVacio();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jcbEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbEstadoMouseClicked
        cargarComboBoxEstado();
    }//GEN-LAST:event_jcbEstadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JComboBox<EstadoEjemplar> jcbEstado;
    private javax.swing.JComboBox<Libro> jcbLibro;
    private javax.swing.JTextField jtCantidad;
    private javax.swing.JTable jtEj;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        jtEjemplarModelo.addColumn("Código");
        jtEjemplarModelo.addColumn("ISBN");
        jtEjemplarModelo.addColumn("Título");
        jtEjemplarModelo.addColumn("Autor");
        jtEjemplarModelo.addColumn("Estado");

        jtEj.setModel(jtEjemplarModelo);
    }

    private void cargarComboBoxEstadoVacio() {
        jcbEstado.setModel(new DefaultComboBoxModel<>());
    }

    private void cargarComboBoxEstado() {
        jcbEstado.setModel(new DefaultComboBoxModel<>(EstadoEjemplar.values()));
    }

    private void cargarComboBoxLibroVacio() {
        jcbLibro.setModel(new DefaultComboBoxModel<>());
    }

    private void cargarComboBoxLibro() {
        jcbLibro.removeAllItems();

        listaLibros = libroData.listarLibros();

        for (int i = 0; i < listaLibros.size(); i++) {

            jcbLibro.addItem(listaLibros.get(i));
        }
    }

    private void borrarFilas() {
        int f = jtEj.getRowCount() - 1;

        for (; f >= 0; f--) {
            jtEjemplarModelo.removeRow(f);
        }
    }
}

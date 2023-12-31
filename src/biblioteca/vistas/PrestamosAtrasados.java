/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package biblioteca.vistas;

import biblioteca.accesoADatos.*;
import biblioteca.entidades.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agus_
 */
public class PrestamosAtrasados extends javax.swing.JInternalFrame {

    private PrestamoData pd = new PrestamoData();
    private LectorData ld = new LectorData();

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    /**
     * Creates new form ListaEjemplares
     */
    public PrestamosAtrasados() {
        initComponents();
        cabecera();
        armarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtAtrasos = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);

        jtAtrasos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtAtrasos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAtrasos;
    // End of variables declaration//GEN-END:variables

    private void borrarFilas() {
        int f = jtAtrasos.getRowCount() - 1;

        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void armarTabla() {
        borrarFilas();

        ArrayList<Prestamo> prestamos = pd.listarPrestamosAtrasados(); 

        for (Prestamo prestamo : prestamos) {
            modelo.addRow(new Object[]{
                prestamo.getIdPrestamo(),
                prestamo.getLector().getNroSocio(),
                prestamo.getLector().getApellido() + " " + prestamo.getLector().getNombre(),
                prestamo.getEjemplar().getCodigo(),
                prestamo.getEjemplar().getLibro().getTitulo(),
                prestamo.getFechaPrestamo(),
                prestamo.getFechaDevoluc(),});
        }

    }

    private void cabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nro de Socio");
        modelo.addColumn("Apellido y Nombre");
        modelo.addColumn("ID Ejemplar");
        modelo.addColumn("Ejemplar");
        modelo.addColumn("Fecha de prestamo");
        modelo.addColumn("Fecha de devolucion");
        //modelo.addColumn("Estado");
        jtAtrasos.setModel(modelo);
    }
}

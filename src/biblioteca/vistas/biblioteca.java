/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package biblioteca.vistas;

/**
 *
 * @author agus_
 */
public class biblioteca extends javax.swing.JFrame {

    /**
     * Creates new form biblioteca
     */
    public biblioteca() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmLector = new javax.swing.JMenu();
        jmGestionLectores = new javax.swing.JMenuItem();
        jmLibro = new javax.swing.JMenu();
        jmGestionLibros = new javax.swing.JMenuItem();
        jmEjemplar = new javax.swing.JMenu();
        jmGestionEjemplares = new javax.swing.JMenuItem();
        jmPrestamo = new javax.swing.JMenu();
        jmGestionPrestamos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 932, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        jmLector.setText("Lector");

        jmGestionLectores.setText("Gestion de lectores");
        jmGestionLectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionLectoresActionPerformed(evt);
            }
        });
        jmLector.add(jmGestionLectores);

        jMenuBar1.add(jmLector);

        jmLibro.setText("Libro");

        jmGestionLibros.setText("Gestion de libros");
        jmGestionLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionLibrosActionPerformed(evt);
            }
        });
        jmLibro.add(jmGestionLibros);

        jMenuBar1.add(jmLibro);

        jmEjemplar.setText("Ejemplar");

        jmGestionEjemplares.setText("Gestion de ejemplares");
        jmGestionEjemplares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionEjemplaresActionPerformed(evt);
            }
        });
        jmEjemplar.add(jmGestionEjemplares);

        jMenuBar1.add(jmEjemplar);

        jmPrestamo.setText("Prestamo");

        jmGestionPrestamos.setText("Prestar libro");
        jmGestionPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionPrestamosActionPerformed(evt);
            }
        });
        jmPrestamo.add(jmGestionPrestamos);

        jMenuItem1.setText("Devolver libro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmPrestamo.add(jMenuItem1);

        jMenuBar1.add(jmPrestamo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmGestionLectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionLectoresActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        GestionLectores gLectores = new GestionLectores();
        gLectores.setVisible(true);
        Escritorio.add(gLectores);
        Escritorio.moveToFront(gLectores);
    }//GEN-LAST:event_jmGestionLectoresActionPerformed

    private void jmGestionLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionLibrosActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        GestionLibros gLibros = new GestionLibros();
        gLibros.setVisible(true);
        Escritorio.add(gLibros);
        Escritorio.moveToFront(gLibros);
    }//GEN-LAST:event_jmGestionLibrosActionPerformed

    private void jmGestionEjemplaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionEjemplaresActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        GestionEjemplares gEjemplares = new GestionEjemplares();
        gEjemplares.setVisible(true);
        Escritorio.add(gEjemplares);
        Escritorio.moveToFront(gEjemplares);
    }//GEN-LAST:event_jmGestionEjemplaresActionPerformed

    private void jmGestionPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionPrestamosActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        PrestarLibro pl = new PrestarLibro();
        pl.setVisible(true);
        Escritorio.add(pl);
        Escritorio.moveToFront(pl);
    }//GEN-LAST:event_jmGestionPrestamosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Escritorio.removeAll();
        Escritorio.repaint();
        DevolverLibro dl = new DevolverLibro();
        dl.setVisible(true);
        Escritorio.add(dl);
        Escritorio.moveToFront(dl);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new biblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmEjemplar;
    private javax.swing.JMenuItem jmGestionEjemplares;
    private javax.swing.JMenuItem jmGestionLectores;
    private javax.swing.JMenuItem jmGestionLibros;
    private javax.swing.JMenuItem jmGestionPrestamos;
    private javax.swing.JMenu jmLector;
    private javax.swing.JMenu jmLibro;
    private javax.swing.JMenu jmPrestamo;
    // End of variables declaration//GEN-END:variables
}

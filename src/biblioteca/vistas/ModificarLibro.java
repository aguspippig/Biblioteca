/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.vistas;

import biblioteca.accesoADatos.LibroData;
import biblioteca.entidades.Libro;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class ModificarLibro extends javax.swing.JInternalFrame {

    private LibroData libroData = new LibroData();
    private List<Libro> libros;
    /**
     * Creates new form ModificarLibro
     */
    public ModificarLibro() {
        initComponents();
        armarCombobox();
        jtISBN.setEnabled(false);
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
        jcISBN = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtTitulo = new javax.swing.JTextField();
        jtAutor = new javax.swing.JTextField();
        jtAnio = new javax.swing.JTextField();
        jtTipo = new javax.swing.JTextField();
        jtEditorial = new javax.swing.JTextField();
        jbModificar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jrEstado = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jtISBN = new javax.swing.JTextField();
        jrISBN = new javax.swing.JRadioButton();

        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(533, 430));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DE LIBROS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ISBN");

        jcISBN.setEditable(true);
        jcISBN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcISBNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcISBNMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jcISBNMousePressed(evt);
            }
        });
        jcISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcISBNActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Titulo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Autor");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Año");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tipo");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Editorial");

        jtTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtAutor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtAnio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtEditorial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbModificar.setText("MODIFICAR");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Estado");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Nuevo ISBN");

        jtISBN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jrISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrISBNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jrEstado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jrISBN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcISBN, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtAutor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtAnio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtTipo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(jbModificar)
                .addGap(206, 206, 206))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jrISBN)
                            .addComponent(jtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jrEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jbModificar)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcISBNActionPerformed
        // TODO add your handling code here:
        Libro libro = libroData.buscarLibroXIsbn((int)jcISBN.getModel().getSelectedItem());
        
        jrEstado.setSelected(libro.isEstado());
        jtAnio.setText(libro.getAnio()+"");
        jtAutor.setText(libro.getAutor());
        jtEditorial.setText(libro.getEditorial());
        jtTipo.setText(libro.getTipo());
        jtTitulo.setText(libro.getTitulo());
    }//GEN-LAST:event_jcISBNActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        try {
            String titulo = jtTitulo.getText();
        String autor = jtAutor.getText();
        int anio = Integer.parseInt(jtAnio.getText());
        String tipo = jtTipo.getText();
        String editor = jtEditorial.getText();
        boolean estad = jrEstado.isSelected();
            if (jrISBN.isSelected()){
                int isbn = Integer.valueOf(jtISBN.getText());
                Libro libro = new Libro((int)jcISBN.getModel().getSelectedItem(), titulo, autor, anio, tipo, editor, estad);
                libroData.modificarLibro(libro);
                jcISBN.removeItem(libro.getIsbn());
                libro.setIsbn(isbn);
                libroData.modificarISBNLibro(libro);
                limpiar();
                jcISBN.addItem(libro.getIsbn());
            } else {
                Libro libro = new Libro((int)jcISBN.getModel().getSelectedItem(), titulo, autor, anio, tipo, editor, estad);
                libroData.modificarLibro(libro);
                limpiar();
            }
        } catch (NumberFormatException e) {
            if(jtISBN.getText().equals("") || jtAnio.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Error al ingresar los datos");
                JOptionPane.showMessageDialog(null, "Verifique que todos los parametros tienen datos.");
            } else {
            JOptionPane.showMessageDialog(null, "Error al ingresar nuevos datos.");
            JOptionPane.showMessageDialog(null, "En el campo 'Nuevo ISBN' y 'Año' deben ir numeros enteros.");
            }
        }  catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos");
            JOptionPane.showMessageDialog(null, "Verifique que todos los parametros tienen datos.");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jcISBNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcISBNMouseClicked
        
    }//GEN-LAST:event_jcISBNMouseClicked

    private void jcISBNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcISBNMousePressed
       
    }//GEN-LAST:event_jcISBNMousePressed

    private void jcISBNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcISBNMouseEntered
        
    }//GEN-LAST:event_jcISBNMouseEntered

    private void jrISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrISBNActionPerformed
        if(jtISBN.isEnabled()){
            jtISBN.setEnabled(false);
        } else {
            jtISBN.setEnabled(true);
        }
    }//GEN-LAST:event_jrISBNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox<Integer> jcISBN;
    private javax.swing.JRadioButton jrEstado;
    private javax.swing.JRadioButton jrISBN;
    private javax.swing.JTextField jtAnio;
    private javax.swing.JTextField jtAutor;
    private javax.swing.JTextField jtEditorial;
    private javax.swing.JTextField jtISBN;
    private javax.swing.JTextField jtTipo;
    private javax.swing.JTextField jtTitulo;
    // End of variables declaration//GEN-END:variables
 private void armarCombobox(){
     
     libros = libroData.listarTodoLibros();
     
     for (Libro libro : libros) {
         jcISBN.addItem(libro.getIsbn());
     }
 }
 private void limpiar(){
     jtISBN.setText("");
     jrISBN.setSelected(false);
     jtAnio.setText("");
     jtAutor.setText("");
     jtEditorial.setText("");
     jtTipo.setText("");
     jtTitulo.setText("");
     jrEstado.setSelected(false);
     jtISBN.setEnabled(false);
 }
}


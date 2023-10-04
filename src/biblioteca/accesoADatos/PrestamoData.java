/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.accesoADatos;

import biblioteca.entidades.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Florencia
 */
public class PrestamoData {

    private Connection con = null;

    public PrestamoData() {
        con = Conexion.conectar();
    }

    public void prestarLibro(Prestamo prestamo) {
        String sql = "INSERT INTO prestamo (lector, ejemplar, fechaPrestamo, fechaDevoluc, estado) VALUES(?, ?, ?, ?, ?)";
        
        String sql2 = "UPDATE ejemplar SET cantidad = cantidad - 1 WHERE codigo = ?";
        if (verificarEjemplares(prestamo.getEjemplar())) {
            try {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                
                PreparedStatement ps2 = con.prepareStatement(sql2);
                
                ps.setInt(1, prestamo.getLector().getNroSocio());
                ps.setInt(2, prestamo.getEjemplar().getCodigo());
                ps.setDate(3, (Date.valueOf(prestamo.getFechaPrestamo())));
                ps.setDate(4, (Date.valueOf(prestamo.getFechaDevoluc())));
                ps.setBoolean(5, prestamo.isEstado());
                
                ps2.setInt(1, prestamo.getEjemplar().getCodigo());

                ps.executeUpdate();
                int registro = ps2.executeUpdate();
                
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next() && registro == 1) {
                    prestamo.setIdPrestamo(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Prestamo realizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestamo. " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay ejemplares disponibles para el prestamo");
        }
    }
    
    public boolean verificarEjemplares(Ejemplar ejemplar){
        try {
            String sql = "SELECT cantidad FROM ejemplar WHERE codigo = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1,ejemplar.getCodigo());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() && rs.getInt("cantidad") > 0){
                return true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestamo. " + ex.getMessage());
        }
        
        return false;
    }
}

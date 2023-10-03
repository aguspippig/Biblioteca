/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.accesoADatos;

import biblioteca.entidades.Ejemplar;
import biblioteca.entidades.Lector;
import biblioteca.entidades.Prestamo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public void prestarLibro(Prestamo prestamo){
        String sql="INSERT INTO prestamo (lector, ejemplar, fechaPrestamo, fechaDevoluc, estado) VALUES(?, ?, ?, ?, ?)";
        
        if(prestamo.getEjemplar().getCantidad()>0){
            try {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                ps.setInt(1, prestamo.getLector().getNroSocio());
                ps.setInt(2, prestamo.getEjemplar().getCodigo());
                ps.setDate(3, (Date.valueOf(prestamo.getFechaPrestamo())));
                ps.setDate(4, (Date.valueOf(prestamo.getFechaDevoluc())));
                ps.setBoolean(5, prestamo.isEstado());

                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    prestamo.setIdPrestamo(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Prestamo realizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestamo. " + ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay ejemplares disponibles para el prestamo");
        }

    }//fin metodo
    
    
}

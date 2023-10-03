/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.accesoADatos;

import biblioteca.entidades.Ejemplar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Florencia
 */
public class EjemplarData {
    private Connection con = null;

    public EjemplarData() {
        con = Conexion.conectar();
    }
    
    //agregar ejemplar
    public void agregarEjemplar(Ejemplar ejemplar){
        String sql = "INSERT INTO ejemplar(libro, estado, cantidad) VALUES(?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ejemplar.getLibro().getIsbn());
            ps.setString(2, ejemplar.getEstado().name());
            ps.setInt(3, ejemplar.getCantidad());
            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ejemplar.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ejemplar añadido correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar." + ex.getMessage());
        }

    }
}

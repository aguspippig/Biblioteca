/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.accesoADatos;

import biblioteca.entidades.Lector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Florencia
 */
public class LectorData {
    private Connection con = null;

    public LectorData() {
        con = Conexion.conectar();
    }
    
    //agregar lector
    public void agregarLector(Lector lector){
        String sql="INSERT INTO lector(apellido, nombre, domicilio, dni, telefono, mail, estado) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, lector.getApellido());
            ps.setString(2, lector.getNombre());
            ps.setString(3, lector.getDomicilio());
            ps.setInt(4, lector.getDni());
            ps.setInt(5, lector.getTelefono());
            ps.setString(6, lector.getMail());
            ps.setBoolean(7, lector.isEstado());
            
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                lector.setNroSocio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Lector añadido correctamente.");
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector." + ex.getMessage());
        }
        
        
    
    }
}

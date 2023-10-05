/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.accesoADatos;

import biblioteca.entidades.Lector;
import java.sql.*;
import java.util.ArrayList;
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

    public void agregarLector(Lector lector) {
        String sql = "INSERT INTO lector(apellido, nombre, domicilio, dni, telefono, mail, estado) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, lector.getApellido());
            ps.setString(2, lector.getNombre());
            ps.setString(3, lector.getDomicilio());
            ps.setInt(4, lector.getDni());
            ps.setInt(5, lector.getTelefono());
            ps.setString(6, lector.getMail());
            ps.setBoolean(7, lector.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                lector.setNroSocio(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Lector añadido correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector." + ex.getMessage());
        }
    }

    public ArrayList<Lector> listaDeAtrasos() {
        ArrayList<Lector> lista = new ArrayList<>();

        try {
            String sql = "SELECT nroSocio, apellido, nombre, domicilio, dni, telefono, mail, lector.estado FROM lector JOIN prestamo ON (lector.nroSocio = lector) WHERE TIMESTAMPDIFF (day,fechaPrestamo,fechaDevoluc) > 8";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Lector lector = new Lector();

                lector.setNroSocio(rs.getInt("nroSocio"));
                lector.setApellido(rs.getString("apellido"));
                lector.setNombre(rs.getString("nombre"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setDni(rs.getInt("dni"));
                lector.setTelefono(rs.getInt("telefono"));
                lector.setMail(rs.getString("mail"));
                lector.setEstado(rs.getBoolean("estado"));

                lista.add(lector);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector." + ex.getMessage());
        }

        return lista;
    }

    public ArrayList<Lector> listarLectores() {
        ArrayList<Lector> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM lector";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Lector lector = new Lector();

                lector.setNroSocio(rs.getInt("nroSocio"));
                lector.setApellido(rs.getString("apellido"));
                lector.setNombre(rs.getString("nombre"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setDni(rs.getInt("dni"));
                lector.setTelefono(rs.getInt("telefono"));
                lector.setMail(rs.getString("mail"));
                lector.setEstado(rs.getBoolean("estado"));

                lista.add(lector);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector." + ex.getMessage());
        }

        return lista;
    }
}

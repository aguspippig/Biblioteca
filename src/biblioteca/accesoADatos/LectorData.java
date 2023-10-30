/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.accesoADatos;

import biblioteca.entidades.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Florencia
 */
public class LectorData {

    boolean verificar = false;

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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector.");
        }
    }

    public ArrayList<Lector> listaDeAtrasos() {
        ArrayList<Lector> lista = new ArrayList<>();

        try {
           String sql = "SELECT nroSocio, apellido, nombre, domicilio, dni, telefono, mail, lector.estado FROM lector JOIN prestamo ON (lector.nroSocio = lector) WHERE TIMESTAMPDIFF (day,fechaDevoluc,CURRENT_DATE) > 0 AND prestamo.estado = 1";//(day,fechaPrestamo,fechaDevoluc) > 8";

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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector.");
        }

        return lista;
    }

    public ArrayList<Lector> listarLectores() {
        ArrayList<Lector> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM lector WHERE estado = 1";

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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector.");
        }

        return lista;
    }

    public ArrayList<Lector> listarLectoresNoActivos() {
        ArrayList<Lector> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM lector WHERE estado = 0";

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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector.");
        }

        return lista;
    }

    public Lector buscarLector(int dni) {

        boolean verificar = false;
        Lector lector = new Lector();

        String sql = "SELECT * FROM lector WHERE dni = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lector.setNroSocio(rs.getInt("nroSocio"));

                lector.setApellido(rs.getString("apellido"));
                lector.setNombre(rs.getString("nombre"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setDni(dni);

                lector.setTelefono(rs.getInt("telefono"));
                lector.setMail(rs.getString("mail"));
                lector.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el lector ");
                verificar = true;
            }
            if (lector.isEstado() == false && verificar == false) {
                JOptionPane.showMessageDialog(null, "El lector no esta activo ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector. ");
        }
        
        return lector;
    }

    public Lector buscarLectorId(int id) {
        boolean verificar = false;
        Lector lector = new Lector();

        String sql = "SELECT apellido , nombre, domicilio, dni, telefono, mail, estado FROM lector WHERE nroSocio = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lector.setNroSocio(id);
                lector.setDni(rs.getInt("dni"));
                lector.setApellido(rs.getString("apellido"));
                lector.setNombre(rs.getString("nombre"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setMail(rs.getString("mail"));
                lector.setTelefono(rs.getInt("telefono"));
                lector.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el lector");
                verificar = true;
            }
            if (lector.isEstado() == false && verificar == false) {
                JOptionPane.showMessageDialog(null, "El lector no esta activo ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla lector. ");
        }

        return lector;
    }

    public void modificarLector(Lector lector) {

        String sql = "UPDATE lector SET apellido = ?, nombre=?, domicilio=?, dni=?, telefono=?, mail=?, estado=? WHERE nroSocio=? ";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, lector.getApellido());
            ps.setString(2, lector.getNombre());
            ps.setString(3, lector.getDomicilio());
            ps.setInt(4, lector.getDni());
            ps.setInt(5, lector.getTelefono());
            ps.setString(6, lector.getMail());
            ps.setBoolean(7, lector.isEstado());
            ps.setInt(8, lector.getNroSocio());

            int registro = ps.executeUpdate();

            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Lector modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Lector no existe.p ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos. ");
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe completar con numeros");
        }
    }

    public void eliminarLector(int id) {

        String sql = "UPDATE lector SET estado=0 WHERE nroSocio=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int registro = ps.executeUpdate();
            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Lector eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Lector no encontrado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error base datos");
        }
    }
}

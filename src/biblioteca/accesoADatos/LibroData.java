/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.accesoADatos;

import biblioteca.entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author agus_
 */
public class LibroData {

    private Connection con = null;

    public LibroData() {
        con = Conexion.conectar();
    }

    public void agregarLibro(Libro libro) {
        String sql = "INSERT INTO libro (isbn, titulo, autor, anio, tipo, editorial, estado) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setInt(4, libro.getAnio());
            ps.setString(5, libro.getTipo());
            ps.setString(6, libro.getEditorial());
            ps.setBoolean(7, libro.isEstado());

            int resultado = ps.executeUpdate();

            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Se ha agregado el libro correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido agregar el libro.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro. " + ex.getMessage());
        }
    }

    public void modificarLibro(Libro libro) {
        try {
            String sql = "UPDATE libro SET titulo = ?, autor = ?, anio = ?, tipo = ?, editorial = ?, estado = ? WHERE isbn = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setString(4, libro.getTipo());
            ps.setString(5, libro.getEditorial());
            ps.setBoolean(6, libro.isEstado());
            ps.setInt(7, libro.getIsbn());

            int registro = ps.executeUpdate();

            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Libro modificado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El libro no existe.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro. " + ex.getMessage());
        }
    }

    public void eliminarLibro(Libro libro) {
        try {
            String sql = "UPDATE libro SET estado = 0 WHERE isbn = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, libro.getIsbn());

            int registro = ps.executeUpdate();

            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Se dio de baja al libro correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El libro no existe.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro. " + ex.getMessage());
        }
    }

    public ArrayList<Libro> buscarLibroXAutor(String autor) {
        ArrayList<Libro> listaAutor = new ArrayList<>();

        String sql = "SELECT * FROM libro WHERE autor = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, autor);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Libro libro = new Libro();
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setTipo(rs.getString("tipo"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEstado(rs.getBoolean("estado"));

                listaAutor.add(libro);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro. " + ex.getMessage());
        }

        return listaAutor;
    }
}

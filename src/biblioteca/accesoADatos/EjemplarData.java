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
public class EjemplarData {

    private Connection con = null;

    public EjemplarData() {
        con = Conexion.conectar();
    }

    public void agregarEjemplar(Ejemplar ejemplar) {
        String sql = "INSERT INTO ejemplar(libro, estado) VALUES(?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ejemplar.getLibro().getIsbn());
            ps.setString(2, ejemplar.getEstado().name());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ejemplar.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ejemplar añadido correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar." + ex.getMessage());
        }
    }
    
    public Ejemplar buscarEjemplar(int codigo) {
        Ejemplar ejemplar = new Ejemplar();
        LibroData ld = new LibroData();
        
        String sql = "SELECT * FROM ejemplar WHERE codigo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ejemplar.setCodigo(codigo);
                ejemplar.setLibro(ld.buscarLibroXIsbn(rs.getInt("libro")));
                ejemplar.setEstado(EstadoEjemplar.valueOf(rs.getString("estado")));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar. " + ex.getMessage());
        }

        return ejemplar;
    }
    
    public ArrayList<Ejemplar> listarEjemplaresXLector(Lector lector) {
        ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();

        try {
            String sql = "SELECT codigo, titulo, autor, isbn FROM libro JOIN ejemplar ON (isbn = libro) JOIN prestamo ON (codigo = ejemplar) WHERE lector = ? AND prestamo.estado = 1";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, lector.getNroSocio());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ejemplar ejemplar = new Ejemplar();
                Libro libro = new Libro();

                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setIsbn(rs.getInt("isbn"));

                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(libro);

                listaEjemplares.add(ejemplar);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la ejemplar. " + ex.getMessage());
        }

        return listaEjemplares;
    }
    
    public ArrayList<Ejemplar> listarEjemplares() {
        ArrayList<Ejemplar> lista = new ArrayList<>();
        LibroData ld = new LibroData();

        try {
            String sql = "SELECT * FROM ejemplar";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ejemplar ejemplar = new Ejemplar();

                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(ld.buscarLibroXIsbn(rs.getInt("libro")));
                ejemplar.setEstado(EstadoEjemplar.valueOf(rs.getString("estado")));

                lista.add(ejemplar);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar." + ex.getMessage());
        }

        return lista;
    }
    
    public ArrayList<Ejemplar> listarEjemplaresXLibro(Libro libro) {
        ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();

        try {
            String sql = "SELECT codigo, ejemplar.estado FROM ejemplar JOIN libro ON (isbn = libro) WHERE libro = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, libro.getIsbn());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ejemplar ejemplar = new Ejemplar();
                
                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(libro);
                ejemplar.setEstado(EstadoEjemplar.valueOf(rs.getString("estado")));

                listaEjemplares.add(ejemplar);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la ejemplar. " + ex.getMessage());
        }

        return listaEjemplares;
    }
}

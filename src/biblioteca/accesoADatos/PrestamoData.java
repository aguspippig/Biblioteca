/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.accesoADatos;

import biblioteca.entidades.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
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

        String sql2 = "UPDATE ejemplar SET estado = 'PRESTADO' WHERE codigo = ?";

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
            JOptionPane.showMessageDialog(null, "El ejemplar no se encuantra diponible.");
        }
    }

    public void devolverLibro(Prestamo prestamo) {
        if (verificarPrestamo(prestamo)) {
            String sql = "UPDATE prestamo SET estado = false WHERE idPrestamo = ?";

            String sql2 = "UPDATE ejemplar SET estado = 'DISPONIBLE' WHERE codigo = ?";

            try {
                PreparedStatement ps = con.prepareStatement(sql);

                PreparedStatement ps2 = con.prepareStatement(sql2);

                ps.setInt(1, prestamo.getIdPrestamo());

                ps2.setInt(1, prestamo.getEjemplar().getCodigo());

                int registro = ps.executeUpdate();
                int registro2 = ps2.executeUpdate();

                if (registro == 1 && registro2 == 1) {
                    JOptionPane.showMessageDialog(null, "Libro devuelto correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestamo. " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe el prestamo.");
        }
    }

    public boolean verificarPrestamo(Prestamo prestamo) {
        try {
            String sql = "SELECT * FROM prestamo WHERE idPrestamo = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, prestamo.getIdPrestamo());

            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getBoolean("estado") == true) {
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla prestamo. " + ex.getMessage());
        }

        return false;
    }

    public boolean verificarEjemplares(Ejemplar ejemplar) {
        try {
            String sql = "SELECT * FROM ejemplar WHERE codigo = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, ejemplar.getCodigo());

            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getString("estado").equals("DISPONIBLE")) {
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar. " + ex.getMessage());
        }

        return false;
    }

    public ArrayList<Ejemplar> ejemplaresPrestadosXFecha(LocalDate fechaPrestamo) {
        ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();

        try {
            String sql = "SELECT codigo, titulo, autor, isbn FROM libro JOIN ejemplar ON (isbn = libro) JOIN prestamo ON (codigo = ejemplar) WHERE fechaPrestamo = ? AND prestamo.estado = 1";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, Date.valueOf(fechaPrestamo));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro();
                Ejemplar ejemplar = new Ejemplar();

                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setIsbn(rs.getInt("isbn"));

                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(libro);
                //ejemplar.setEstado(EstadoEjemplar.valueOf(rs.getString("estado")));

                listaEjemplares.add(ejemplar);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar. " + ex.getMessage());
        }

        return listaEjemplares;
    }
    
    public ArrayList<Prestamo> listarPrestamosActivos() {
        ArrayList<Prestamo> lista = new ArrayList<>();
        EjemplarData ed = new EjemplarData();
        LectorData ld = new LectorData();

        try {
            String sql = "SELECT * FROM prestamo WHERE estado = 1";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prestamo prestamo = new Prestamo();
                
                Date fechaPrestamo = rs.getDate("fechaPrestamo");
                Date fechaDevoluc = rs.getDate("fechaDevoluc");

                prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
                prestamo.setFechaPrestamo(fechaPrestamo.toLocalDate());
                prestamo.setFechaDevoluc(fechaDevoluc.toLocalDate());
                prestamo.setEjemplar(ed.buscarEjemplar(rs.getInt("ejemplar")));
                prestamo.setLector(ld.buscarLector(rs.getInt("lector")));
                prestamo.setEstado(rs.getBoolean("estado"));
                
                lista.add(prestamo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro." + ex.getMessage());
        }
        
        return lista;
    }
}

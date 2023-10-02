/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author agus_
 */
public class Conexion {

    private static final String BD = "universidadulp";
    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String USUARIO = "root";
    private static final String PASS = "";
    private static final String DRIVER = "org.mariadb.jdbc.Driver";

    private static Connection cx;

    public Conexion() {
    }

    public static Connection conectar() {
        if (cx == null) {
            try {
                Class.forName(DRIVER);
                cx = DriverManager.getConnection(URL + BD, USUARIO, PASS);
                System.out.println("Conexion exitosa.");

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar driver" + ex.getMessage());
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "Error en la conexion" + ex1.getMessage());
            }
        }
        return cx;
    }
}

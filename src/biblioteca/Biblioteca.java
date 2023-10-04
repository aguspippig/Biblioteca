/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import biblioteca.accesoADatos.*;
import biblioteca.entidades.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author agus_
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LibroData ld = new LibroData();
        PrestamoData pd = new PrestamoData();
        LectorData lectorD = new LectorData();
        EjemplarData ejD = new EjemplarData();

        Libro libro = new Libro(123456789,"Libro de prueba","Grupo 44",2023,"Programacion","Argetina Programa",true);
        
        //ld.agregarLibro(libro);
        
        //libro.setTipo("Informatica");
        
        //ld.modificarLibro(libro);
        
        //ld.eliminarLibro(libro);
        
        //Libro libro = new Libro(876543219, "Los funerales de Mamá Grande", "Gabriel García Marquéz", 1977, "Novela", "Editorial Planeta", true);
        
        //ld.agregarLibro(libro);
        
        ArrayList <Libro> listaAutor= new ArrayList<>(); 
        
        listaAutor=ld.buscarLibroxAutor("Gabriel García Marquéz");
        
//        for (Libro libro : listaAutor) {
//            System.out.println(libro.getIsbn()+" -"+libro);
//        }
        
        Lector lector = new Lector(1,34657990, 35417654, "Lopex", "Rita", "Las Acacias 236", "lopexrita666@gmail.com", true);
        
        //lectorD.agregarLector(lector);

        Ejemplar ejemplar = new Ejemplar(4,10, libro, EstadoEjemplar.DISPONIBLE);
        
        //ejD.agregarEjemplar(ejemplar);
        
        Prestamo prestamo = new Prestamo(LocalDate.of(2023, Month.APRIL, 1), LocalDate.of(2023, Month.APRIL, 8), ejemplar, lector, true);

        pd.prestarLibro(prestamo);
    }

}

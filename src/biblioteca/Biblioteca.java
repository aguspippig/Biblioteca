/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import biblioteca.accesoADatos.LibroData;
import biblioteca.entidades.Libro;
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
        //Libro libro = new Libro(123456789,"Libro de prueba","Grupo 44",2023,"Programacion","Argetina Programa",true);
        
        //ld.agregarLibro(libro);
        
        //libro.setTipo("Informatica");
        
        //ld.modificarLibro(libro);
        
        //ld.eliminarLibro(libro);
        
//        Libro libro = new Libro(876543219,"Los funerales de Mamá Grande","Gabriel García Marquéz",1977,"Novela","Editorial Planeta",true);
//        ld.agregarLibro(libro);
        
        
        ArrayList <Libro> listaAutor= new ArrayList<>(); 
        listaAutor=ld.buscarLibroxAutor("Gabriel García Marquéz");
        
        for (Libro libro : listaAutor) {
            System.out.println(libro.getIsbn()+" -"+libro);
        }
    }
    
}

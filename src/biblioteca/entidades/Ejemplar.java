/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.entidades;

/**
 *
 * @author agus_
 */
public class Ejemplar {
    private int codigo;
    private Libro libro;
    private EstadoEjemplar estado;

    public Ejemplar() {
    }

    public Ejemplar(int codigo, Libro libro, EstadoEjemplar estado) {
        this.codigo = codigo;
        this.libro = libro;
        this.estado = estado;
    }

    public Ejemplar(Libro libro, EstadoEjemplar estado) {
        this.libro = libro;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public EstadoEjemplar getEstado() {
        return estado;
    }

    public void setEstado(EstadoEjemplar estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return codigo + " - " + libro.getEditorial() + ", " + estado;
    }
}

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
    private int cantidad;
    private Libro libro;
    private EstadoEjemplar estado;

    public Ejemplar() {
    }

    public Ejemplar(int codigo, int cantidad, Libro libro, EstadoEjemplar estado) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.libro = libro;
        this.estado = estado;
    }

    public Ejemplar(int cantidad, Libro libro, EstadoEjemplar estado) {
        this.cantidad = cantidad;
        this.libro = libro;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        return codigo + " - " + libro.getTitulo();
    }
}

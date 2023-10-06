/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.entidades;

import java.time.LocalDate;

/**
 *
 * @author agus_
 */
public class Prestamo {
    private int idPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevoluc;
    private Ejemplar ejemplar;
    private Lector lector;
    private boolean estado;

    public Prestamo() {
    }

    public Prestamo(int idPrestamo, LocalDate fechaPrestamo, LocalDate fechaDevoluc, Ejemplar ejemplar, Lector lector, boolean estado) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevoluc = fechaDevoluc;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.estado = estado;
    }

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevoluc, Ejemplar ejemplar, Lector lector, boolean estado) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevoluc = fechaDevoluc;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.estado = estado;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevoluc() {
        return fechaDevoluc;
    }

    public void setFechaDevoluc(LocalDate fechaDevoluc) {
        this.fechaDevoluc = fechaDevoluc;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return idPrestamo + " - " + lector.getApellido() + ", " + lector.getNombre() + fechaPrestamo + fechaDevoluc;
    }
    
    
}

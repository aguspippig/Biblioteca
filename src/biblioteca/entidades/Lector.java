/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.entidades;

/**
 *
 * @author agus_
 */
public class Lector {
    private int nroSocio;
    private int dni;
    private int telefono;
    private String nombre;
    private String domicilio;
    private String mail;
    private boolean estado;

    public Lector() {
    }

    public Lector(int nroSocio, int dni, int telefono, String nombre, String domicilio, String mail, boolean estado) {
        this.nroSocio = nroSocio;
        this.dni = dni;
        this.telefono = telefono;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.estado = estado;
    }

    public Lector(int dni, int telefono, String nombre, String domicilio, String mail, boolean estado) {
        this.dni = dni;
        this.telefono = telefono;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.estado = estado;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nroSocio + " - " + dni + ", " + nombre ;
    }
}

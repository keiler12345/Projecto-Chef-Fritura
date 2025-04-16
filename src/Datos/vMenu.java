/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author justi
 */
public class vMenu {
    private int id;
    private int numero_plato;
    private String nombre_plato;
    private String acompanamiento;
    private String descripcion;
    private Double precio;

    public vMenu(int id, int numero_plato, String nombre_plato, String acompanamiento, String descripcion, Double precio) {
        this.id = id;
        this.numero_plato = numero_plato;
        this.nombre_plato = nombre_plato;
        this.acompanamiento = acompanamiento;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public vMenu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_plato() {
        return numero_plato;
    }

    public void setNumero_plato(int numero_plato) {
        this.numero_plato = numero_plato;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public String getAcompanamiento() {
        return acompanamiento;
    }

    public void setAcompanamiento(String acompanamiento) {
        this.acompanamiento = acompanamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
    
}

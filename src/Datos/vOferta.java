/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.time.LocalDate;
/**
 *
 * @author Justin Pujols
 */
public class vOferta {
    
    private int id;
    private String nombre_oferta;
    private String descripcion;
    private double descuento_porcentaje;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public vOferta(int id, String nombre_oferta, String descripcion, double descuento_porcentaje, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id = id;
        this.nombre_oferta = nombre_oferta;
        this.descripcion = descripcion;
        this.descuento_porcentaje = descuento_porcentaje;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public vOferta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_oferta() {
        return nombre_oferta;
    }

    public void setNombre_oferta(String nombre_oferta) {
        this.nombre_oferta = nombre_oferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuento_porcentaje() {
        return descuento_porcentaje;
    }

    public void setDescuento_porcentaje(double descuento_porcentaje) {
        this.descuento_porcentaje = descuento_porcentaje;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
   
   
    
}

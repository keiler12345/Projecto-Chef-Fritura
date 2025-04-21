/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Date;


public class vTrabajadores {
    
    private int id;
    private String nombre_usuario;
    private String tipo_acceso; // ´Administrador´, ´Cajero´, ´Cocinero´, ´Mesero´
    private String contraseña;
    private String nombre_completo;
    private java.sql.Date fecha_ingreso;

    public vTrabajadores(int id, String nombre_usuario, String tipo_acceso, String contraseña, String nombre_completo, Date fecha_ingreso) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.tipo_acceso = tipo_acceso;
        this.contraseña = contraseña;
        this.nombre_completo = nombre_completo;
        this.fecha_ingreso = fecha_ingreso;
    }

    public vTrabajadores() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getTipo_acceso() {
        return tipo_acceso;
    }

    public void setTipo_acceso(String tipo_acceso) {
        this.tipo_acceso = tipo_acceso;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
}

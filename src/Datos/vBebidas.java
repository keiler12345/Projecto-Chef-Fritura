
package Datos;

/**
 *
 * @author franc
 */
public class vBebidas {
    private int id_bebida;
    private String nombre_bebida;
    private String tipo;
    private String tamano;
    private Double precio; 
    private String disponible;

    public vBebidas(int id_bebida, String nombre_bebida, String tipo, String tamano, Double precio, String disponible) {
        this.id_bebida = id_bebida;
        this.nombre_bebida = nombre_bebida;
        this.tipo = tipo;
        this.tamano = tamano;
        this.precio = precio;
        this.disponible = disponible;
    }

    public vBebidas() {
    }

    public int getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(int id_bebida) {
        this.id_bebida = id_bebida;
    }

    public String getNombre_bebida() {
        return nombre_bebida;
    }

    public void setNombre_bebida(String nombre_bebida) {
        this.nombre_bebida = nombre_bebida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

 
    
    
    
    
}

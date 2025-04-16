
package Datos;

/**
 *
 * @author franc
 */
public class vClientes {
    private int id_cliente;
    private String nombre_cliente;
    private String telefono_cliente;
    private String direccion;
    private String manera_pago;

    public vClientes(int id_cliente, String nombre_cliente, String telefono_cliente, String direccion) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.telefono_cliente = telefono_cliente;
        this.direccion = direccion;
    }

    public vClientes() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getManera_pago() {
        return manera_pago;
    }

    public void setManera_pago(String manera_pago) {
        this.manera_pago = manera_pago;
    }
    
    
    
}

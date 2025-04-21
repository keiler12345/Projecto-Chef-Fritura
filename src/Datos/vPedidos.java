
package Datos;

import java.security.Timestamp;


public class vPedidos {
  
    private int id;
    private int id_cliente;
    private int numero_plato;
    private int id_bebida;
    private Timestamp fecha_pedido;
    private String modo_consumo; // ´Aqui´ o Para llevar´
    private double total;

    public vPedidos(int id, int id_cliente, int numero_plato, int id_bebida, Timestamp fecha_pedido, String modo_consumo, double total) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.numero_plato = numero_plato;
        this.id_bebida = id_bebida;
        this.fecha_pedido = fecha_pedido;
        this.modo_consumo = modo_consumo;
        this.total = total;
    }
    
    public vPedidos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getNumero_plato() {
        return numero_plato;
    }

    public void setNumero_plato(int numero_plato) {
        this.numero_plato = numero_plato;
    }

    public int getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(int id_bebida) {
        this.id_bebida = id_bebida;
    }

    public Timestamp getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Timestamp fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getModo_consumo() {
        return modo_consumo;
    }

    public void setModo_consumo(String modo_consumo) {
        this.modo_consumo = modo_consumo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}

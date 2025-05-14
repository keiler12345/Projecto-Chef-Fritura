package Logica;

public class ProductoCarrito {
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public ProductoCarrito(String nombre, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getTotal() { return cantidad * precioUnitario; }
}

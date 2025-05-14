package Logica;

import java.util.ArrayList;

public class CarritoManager {
    public static ArrayList<ProductoCarrito> productos = new ArrayList<>();

    public static void agregarProducto(ProductoCarrito producto) {
        productos.add(producto);
    }

    public static ArrayList<ProductoCarrito> obtenerProductos() {
        return productos;
    }

    public static void limpiarCarrito() {
        productos.clear();
    }
}

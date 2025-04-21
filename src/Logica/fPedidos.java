package Logica;

import Datos.vPedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fPedidos {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Cliente", "Plato", "Bebida", "Fecha", "Modo Consumo", "Total"};
        String[] registro = new String[7];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM pedidos WHERE id_cliente LIKE ´%" + buscar + "%´ ORDER BY id";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = String.valueOf(rs.getInt("id"));
                registro[1] = String.valueOf(rs.getInt("id_cliente"));
                registro[2] = String.valueOf(rs.getInt("numero_plato"));
                registro[3] = String.valueOf(rs.getInt("id_bebida"));
                registro[4] = rs.getTimestamp("fecha_pedido").toString();
                registro[5] = rs.getString("modo_consumo");
                registro[6] = String.valueOf(rs.getDouble("total"));

                totalregistros++;
                modelo.addRow(registro);

            }

            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
        

    public boolean insertar(vPedidos dts) {
        sSQL = "INSERT INTO pedidos (id_cliente, numero_plato, id_bebida, fecha_pedido, modo_consumo, total)" + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId_cliente());
            pst.setInt(2, dts.getNumero_plato());
            pst.setInt(3, dts.getId_bebida());
            pst.setTimestamp(4, dts.getFecha_pedido());
            pst.setString(5, dts.getModo_consumo());
            pst.setDouble(6, dts.getTotal());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean editar(vPedidos dts) {
        sSQL = "UPDATE pedidos SET id_cliente=?, numero_plato=?, id_bebida=?, fecha_pedido=?, modo_consumo=?, total=?" + "WHERE id=?";
        
        try{
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId_cliente());
            pst.setInt(2, dts.getNumero_plato());
            pst.setInt(3, dts.getId_bebida());
            pst.setTimestamp(4, dts.getFecha_pedido());
            pst.setString(5, dts.getModo_consumo());
            pst.setDouble(6, dts.getTotal());
            pst.setInt(7, dts.getId());

            int n = pst.executeUpdate();
            return n != 0;
            
        }catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;

    }

}

}

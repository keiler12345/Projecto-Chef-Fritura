/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.time.LocalDate;
import Datos.vMenu;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Datos.vOferta;

public class fOferta {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSql = "";
    public int totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Oferta", "Descripción", "Descuento", "Inicio de la Oferta", "Fin de la Oferta"};

        String[] registros = new String[6];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "select * from oferta where nombre_oferta like '%" + buscar + "%' order by id";

        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("nombre_oferta");
                registros[2] = rs.getString("descripcion");
                registros[3] = rs.getString("descuento_porcentaje");
                registros[4] = rs.getString("fecha_inicio");
                registros[5] = rs.getString("fecha_fin");

                totalregistros++;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vOferta dts) {
        sSql = "insert into menu (nombre_oferta,descripcion,descuento_porcentaje,fecha_inicio,fecha_fin)"
                + "values (?,?,?,?,?)";
        try {

            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sSql);
            pst.setString(1, dts.getNombre_oferta());
            pst.setString(2, dts.getDescripcion());
            pst.setDouble(3, dts.getDescuento_porcentaje());
            pst.setDate(4, java.sql.Date.valueOf(dts.getFecha_inicio()));
            pst.setDate(5, java.sql.Date.valueOf(dts.getFecha_fin()));

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(vOferta dts) {
        sSql = "update oferta set nombre_oferta=?, descripcion=?, descuento_porcentaje=?, fecha_inicio=?, fecha_fin=?"
                + " where id=?";

        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sSql);
            pst.setString(1, dts.getNombre_oferta());
            pst.setString(2, dts.getDescripcion());
            pst.setDouble(3, dts.getDescuento_porcentaje());
            pst.setDate(4, java.sql.Date.valueOf(dts.getFecha_inicio()));
            pst.setDate(5, java.sql.Date.valueOf(dts.getFecha_fin()));
            pst.setInt(6, dts.getId());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;

        }
    }

    public boolean eliminar(vMenu dts) {
        sSql = "delete from oferta where id=?";

        try {

            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sSql);
            pst.setInt(1, dts.getId());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}

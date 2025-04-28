
package Logica;

import Datos.vTrabajadores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fTrabajadores {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
    DefaultTableModel modelo;
    String[] titulos = {"ID", "Usuario", "Tipo Acceso", "Contraseña", "Nombre Completo", "Fecha Ingreso"};
    String[] registro = new String[6];

    totalregistros = 0;
    modelo = new DefaultTableModel(null, titulos);

    sSQL = "SELECT * FROM Trabajadores WHERE nombre_usuario LIKE ? ORDER BY id ASC";

    try {
        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.setString(1, "%" + buscar + "%");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            registro[0] = String.valueOf(rs.getInt("id"));
            registro[1] = rs.getString("nombre_usuario");
            registro[2] = rs.getString("tipo_acceso");
            registro[3] = rs.getString("contraseña");
            registro[4] = rs.getString("nombre_completo");
            registro[5] = rs.getDate("fecha_ingreso").toString();

            totalregistros++;
            modelo.addRow(registro);
        }

        if (totalregistros == 0) {
            JOptionPane.showMessageDialog(null, "No se encontraron trabajadores con ese nombre.");
        }

        return modelo;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error en mostrar: " + e.getMessage());
        return null;
    }
}


    public boolean insertar(vTrabajadores dts) {
        sSQL = "INSERT INTO Trabajadores (nombre_usuario, tipo_acceso, contraseña, nombre_completo, fecha_ingreso) " +
               "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre_usuario());
            pst.setString(2, dts.getTipo_acceso());
            pst.setString(3, dts.getContraseña());
            pst.setString(4, dts.getNombre_completo());
            pst.setDate(5, dts.getFecha_ingreso());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(vTrabajadores dts) {
        sSQL = "UPDATE Trabajadores SET nombre_usuario=?, tipo_acceso=?, contraseña=?, nombre_completo=?, fecha_ingreso=? " +
               "WHERE id=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre_usuario());
            pst.setString(2, dts.getTipo_acceso());
            pst.setString(3, dts.getContraseña());
            pst.setString(4, dts.getNombre_completo());
            pst.setDate(5, dts.getFecha_ingreso());
            pst.setInt(6, dts.getId());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vTrabajadores dts) {
        sSQL = "DELETE FROM Trabajadores WHERE id=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}


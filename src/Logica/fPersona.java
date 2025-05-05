package Logica;

import Datos.vPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class fPersona {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    // Método para registrar una nueva persona con rol Cliente
    public boolean registrar(vPersona dts) {
        sSQL = "INSERT INTO Persona (nombre_usuario, password, correo_electronico, rol) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre_usuario());
            pst.setString(2, dts.getPassword());
            pst.setString(3, dts.getCorreo_electronico());
            pst.setString(4, "Cliente"); // Rol fijo al registrar

            int n = pst.executeUpdate();
            return n != 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar: " + e.getMessage());
            return false;
        }
    }

    // Método para verificar login de usuario
    public String login(String usuario, String password) {
        sSQL = "SELECT rol FROM Persona WHERE nombre_usuario = ? AND password = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, usuario);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("rol"); // Devuelve el rol si existe el usuario
            } else {
                return null; // No coincide
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
            return null;
        }
    }
}

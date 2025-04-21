/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fPedidos {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Cliente", "Plato", "Bebida", "Fecha", "Modo Consumo", "Total"};
        String[] registro = new String[7];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "SELECT * FROM pedidos WHERE id_cliente LIKE ´%" + buscar + "%´ ORDER BY id";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()){
                registro[0] = String.valueOf(rs.getInt("id"));
            }
        }
        
    }
    
}

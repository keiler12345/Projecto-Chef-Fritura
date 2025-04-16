/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.vBebidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
        
public class fBebida {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"Id","Nombre_bebidas","Tipo","Tamaño","Precio","Disponible"};
        
        String [] registro =new String [6];
        
        totalregistros=0;
        modelo= new DefaultTableModel(null,titulos);
        
        sSQL="Select * from bebidas where nombre_bebidas like '%"+ buscar + "%' order by id";
        
        try {
            Statement st = cn.createStatement ();
            ResultSet rs=st.executeQuery (sSQL);
            
            while(rs.next()){
                registro [0]=rs.getString("id");
                registro [1]=rs.getString("nombre_bebida");
                registro [2]=rs.getString("tipo");
                registro [3]=rs.getString("tamano");
                registro [4]=rs.getString("precio");
                registro [5]=rs.getString("disponible");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
                
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        
        
    }
        
    }
     //Funcion para insertar registros de la tabla bebidas 
    public boolean insertar (vBebidas dts){
        sSQL="insert into bebidas (nombre_bebida,tipo,tamano,precio,disponible)" +
                "values(?,?,?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre_bebida());
            pst.setString(2, dts.getTipo());
            pst.setString(3, dts.getTamano());
            pst.setDouble(4, dts.getPrecio());
            pst.setString(5, dts.getDisponible());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
                
            }
            else{
                return false;
            }
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
        
    }
    //Funcion para editar registros de la tabla bebidas 
    public boolean editar (vBebidas dts){
        sSQL="update bebidas set nombre_bebidas=?,tipo=?,tamano=?,precio=?,disponible=?" +
                "where id=?";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre_bebida());
            pst.setString(2, dts.getTipo());
            pst.setString(3, dts.getTamano());
            pst.setDouble(4, dts.getPrecio());
            pst.setString(5, dts.getDisponible());
            pst.setInt(6, dts.getId_bebida());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
                
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    //Funcion para eliminar registros de la tabla bebidas
     public boolean eliminar (vBebidas dts){
         sSQL="delete from bebidas where id=?";
            
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId_bebida());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
                
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
}


package Logica;

/**
 *
 * @author franc
 */

import Datos.vClientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fClientes {
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"id_cliente","Nombre_cliente","telefono_cliente","direccion","manera_pago"};
        
        String [] registro =new String [5];
        
        totalregistros=0;
        modelo= new DefaultTableModel(null,titulos);
        
        sSQL="Select * from clientes where nombre_cliente like '%"+ buscar + "%' order by id_cliente desc";
        
        try {
            Statement st = cn.createStatement ();
            ResultSet rs=st.executeQuery (sSQL);
            
            while(rs.next()){
                registro [0]=rs.getString("id_cliente");
                registro [1]=rs.getString("nombre_cliente");
                registro [2]=rs.getString("telefono_cliente");
                registro [3]=rs.getString("direccion");
                registro [4]=rs.getString("manera_pago");
                
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
                
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        
        
    }
        
    }
     //Funcion para insertar registros de la tabla clientes 
    public boolean insertar (vClientes dts){
        sSQL="insert into clientes (nombre_cliente,telefono_cliente,direccion,manera_pago)" +
                "values(?,?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre_cliente());
            pst.setString(2, dts.getTelefono_cliente());
            pst.setString(3, dts.getDireccion());
            pst.setString(4, dts.getManera_pago()); 
            
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
    //Funcion para editar registros de la tabla clientes
    public boolean editar (vClientes dts){
        sSQL="update clientes set nombre_cliente=?,telefono_cliente=?,direccion=?,manera_pago=?" +
                "where id_cliente=?";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre_cliente());
            pst.setString(2, dts.getTelefono_cliente());
            pst.setString(3, dts.getDireccion());
            pst.setString(4, dts.getManera_pago());
            pst.setInt(5, dts.getId_cliente());
            
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
    //Funcion para eliminar registros de la tabla clientes
     public boolean eliminar (vClientes dts){
         sSQL="delete from clientes where id_cliente=?";
            
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId_cliente());
            
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

    
    


package Logica;

import Datos.vMenu;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet; 
import javax.swing.JOptionPane;

/**
 *
 * @author justi
 */
public class fMenu {
    
    private conexion mysql =new conexion();
    private Connection cn = mysql.conectar();
    private String sSql = "";
    public int totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
            
        String [] titulos = {"ID", "Número del plato", "Nombre del plato", "Acompañamiento", "Descripción", "Precio"};
                
        String [] registros = new String [6];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSql = "select * from menu where numero_plato like '%" + buscar + "%' order by id";
        
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);
            
            while(rs.next()){
                registros [0] = rs.getString("id");
                registros [1] = rs.getString("numero_plato");
                registros [2] = rs.getString("nombre_plato");
                registros [3] = rs.getString("acompanamiento");
                registros [4] = rs.getString("descripcion");
                registros [5] = rs.getString("precio");
                
                totalregistros++;
                modelo.addRow(registros);
            }
            return modelo;
                
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
        
        }
   
    public boolean insertar(vMenu dts){
        sSql = "insert into menu (numero_plato,nombre_plato,acompanamiento,descripcion,precio)" + 
                "values (?,?,?,?,?)";
        try {
            
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sSql);
            pst.setInt(1, dts.getNumero_plato());
            pst.setString(2, dts.getNombre_plato());
            pst.setString(3, dts.getAcompanamiento());
            pst.setString(4, dts.getDescripcion());
            pst.setDouble(5, dts.getPrecio());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
   
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(vMenu dts){
        sSql = "update menu set numero_plato=?, nombre_plato=?, acompanamiento=?, descripcion=?, precio=?" +
                " where id=?";
        
        try {
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sSql);
            pst.setInt(1, dts.getNumero_plato());
            pst.setString(2, dts.getNombre_plato());
            pst.setString(3, dts.getAcompanamiento());
            pst.setString(4, dts.getDescripcion());
            pst.setDouble(5, dts.getPrecio());
            pst.setInt(6, dts.getId());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
    }
    
    public boolean eliminar(vMenu dts){
        sSql = "delete from menu where id=?";
        
        try {
            
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sSql);
            pst.setInt(1, dts.getId());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
}

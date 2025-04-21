
package Logica;

import java.sql.Connection;

public class fTrabajadores {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
}

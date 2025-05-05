package Datos;

public class vPersona {
    
    private String nombre_usuario;
    private String password;
    private String correo_electronico;
    private String rol;

    public vPersona() {
    }

    public vPersona(String nombre_usuario, String password, String correo_electronico, String rol) {
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.correo_electronico = correo_electronico;
        this.rol = rol;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

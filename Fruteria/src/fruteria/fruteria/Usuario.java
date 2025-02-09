package fruteria;


public class Usuario {
    private String nombre;
    private String apellidos;
    private String usuario;
    private String estado; //activo e inactivo 
    private String password; 


    //Falta colocar la contraseña

    public Usuario (String nombre, String apellidos, String usuario, String password, String estado) {

        this.nombre= nombre;
        this.apellidos= apellidos;
        this.usuario= usuario;
        this.estado=estado;
        this.password=password;
    }


    //Getter y setter 

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setApellidos(String apellidos){
        this.apellidos=apellidos;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario=usuario;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado=estado;
    }
    public String getPassword() {
        return password; 
    }

    public void setPassword(String password) {
        this.password = password; 
    }

}
package fruteria;

public class Usuario {
    private int id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String estado;
    private String password;

    public Usuario(int id, String nombre, String apellidos, String usuario, String password, String estado) {
        this.id = id; // Esto es para identificación de lo que es el usuario
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;// activo e inactivo
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nUsuario: " + usuario + "\nNombre: " + nombre + " " + apellidos + "\nEstado: " + estado;
    }
}
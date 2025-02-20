
//-------------------librerías
package fruteria;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


//-----------------Clase de Registros
public class RegistroUsuarios {
    private static final String FILE_NAME= "cajanegra.dat";
    


    //Método para agregar a los usuarios
    public void agregarUsuario(){
        String id= JOptionPane.showInputDialog("Ingrese el id:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos:");
        String usuario = JOptionPane.showInputDialog("Ingrese el usuario:");
        String password = JOptionPane.showInputDialog("Ingrese la contraseña:");
        String estado= "Activo"; //Este valor lo coloqué para que esté por defecto


        Usuario nuevoUsuario = new Usuario (id, nombre, apellidos, password, usuario, estado);

        try (DataOutputStream salida= new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            // Escribir los datos del usuario en el archivo
            salida.writeInt(nuevoUsuario.getId());
            salida.writeUTF(nuevoUsuario.getNombre());
            salida.writeUTF(nuevoUsuario.getApellidos());
            salida.writeUTF(nuevoUsuario.getUsuario());
            salida.writeUTF(nuevoUsuario.getPassword());
            salida.writeUTF(nuevoUsuario.getEstado());

            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario.");
        }


    }

}

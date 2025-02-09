
//-------------------librerías
package fruteria;
import java.io.*;
import javax.swing.JOptionPane;


//-----------------Clase de Registros
public class RegistroUsuarios {
    private static final String FILE_NAME= "cajanegra.txt";
    


    //Método para agregar a los usuarios
    public void agregarUsuario(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos:");
        String usuario = JOptionPane.showInputDialog("Ingrese el usuario:");
        String estado = JOptionPane.showInputDialog("Ingrese el estado:");
        String password = JOptionPane.showInputDialog("Ingrese la contraseña:");


        Usuario nuevoUsuario = new Usuario (nombre, apellidos, password, usuario, estado);

        try (FileWriter writer = new FileWriter(FILE_NAME, true); // Abrir el archivo en modo append
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            
            // Escribir los datos del usuario en el archivo
            String datosUsuario = nuevoUsuario.getNombre() + "," + 
                                  nuevoUsuario.getApellidos() + "," +
                                  nuevoUsuario.getUsuario() + "," +
                                  nuevoUsuario.getPassword() + "," + 
                                  nuevoUsuario.getEstado(); 
            bufferedWriter.write(datosUsuario); //Esto escribe todos los datos que agregue de los usuarios
            bufferedWriter.newLine(); //Esto salta líneas después de escribir

            
            JOptionPane.showMessageDialog(null, "El usuario ha sido agregado correctamente");
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar el usuario");
    
        }
    }

}

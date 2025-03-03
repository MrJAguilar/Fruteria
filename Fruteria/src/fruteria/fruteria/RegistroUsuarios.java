
//-------------------librerías
package fruteria;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//-----------------Clase de Registros
class RegistroUsuarios {
    private static final String FILE_NAME = "cajanegra.dat";
    private List<Usuario> usuarios = new ArrayList<>();

    // Método para agregar a los usuarios
    public void agregarUsuario() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id:"));
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos:");
            String usuario = JOptionPane.showInputDialog("Ingrese el usuario:");
            String password = JOptionPane.showInputDialog("Ingrese la contraseña:");
            String estado = "Activo";  // Este valor lo coloqué para que esté por defecto

            Usuario nuevoUsuario = new Usuario(id, nombre, apellidos, usuario, password, estado);
            usuarios.add(nuevoUsuario);

            // Escribir los datos del usuario en el archivo
            try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
                salida.writeInt(nuevoUsuario.getId());
                salida.writeUTF(nuevoUsuario.getNombre());
                salida.writeUTF(nuevoUsuario.getApellidos());
                salida.writeUTF(nuevoUsuario.getUsuario());
                salida.writeUTF(nuevoUsuario.getPassword());
                salida.writeUTF(nuevoUsuario.getEstado());
                JOptionPane.showMessageDialog(null, "Usuario agregado correctamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número entero.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario.");
        }
    }

    // En esta parte se están leyendo los usuarios
    public void leerUsuarios() {
        try (DataInputStream entrada = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                int id = entrada.readInt();
                String nombre = entrada.readUTF();
                String apellidos = entrada.readUTF();
                String usuario = entrada.readUTF();
                String password = entrada.readUTF();
                String estado = entrada.readUTF();
                Usuario user = new Usuario(id, nombre, apellidos, usuario, password, estado);
                usuarios.add(user);
            }
        } catch (EOFException e) {
            // Se alcanza el final del archivo, no hace falta manejar nada aquí.
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Hay un error al leer los usuarios.");
        }
    }

    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : usuarios) {
            sb.append(usuario.toString()).append("\n-------------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}

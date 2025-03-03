package fruteria;

import javax.swing.JOptionPane;

public class Fruteria {
    public static void main(String[] args) {
        RegistroUsuarios registro = new RegistroUsuarios();
        registro.leerUsuarios();
        GestorCatalogos<Proveedor> gestorProveedores = new GestorCatalogos<>();

        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    registro.agregarUsuario();
                    break;
                case 2:
                    registro.mostrarUsuarios(); // Llama al método de RegistroUsuarios
                    break;
                case 3:
                    gestorProveedores.agregar(new Proveedor(Integer.parseInt(JOptionPane.showInputDialog("ID del proveedor:")), JOptionPane.showInputDialog("Nombre del proveedor:")));
                    break;
                case 4:
                    gestorProveedores.mostrarTodos();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static int mostrarMenu() {
        String menu = "===== Menú Principal =====\n"
                    + "1. Agregar Usuario\n"
                    + "-------------------------\n"
                    + "2. Mostrar Usuarios\n"
                    + "-------------------------\n"
                    + "3. Agregar Proveedor\n"
                    + "-------------------------\n"
                    + "4. Mostrar Proveedores\n"
                    + "-------------------------\n"
                    + "5. Salir\n"
                    + "=========================";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
}

    



















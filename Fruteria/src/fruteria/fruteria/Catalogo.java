package fruteria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

abstract class Catalogo {
    protected int id;
    protected boolean activo;

    public Catalogo(int id) {
        this.id = id;
        this.activo = true;
    }

    public int getId() {
        return id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void inactivar() {
        this.activo = false;
    }

    public abstract void mostrarInfo();
}

// Catálogo de Proveedores
class Proveedor extends Catalogo {
    private String nombre;

    public Proveedor(int id, String nombre) {
        super(id);
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        JOptionPane.showMessageDialog(null, "Proveedor ID: " + id + "\nNombre: " + nombre + "\nActivo: " + activo);
    }
}

// Clase genérica para manejar catálogos
class GestorCatalogos<T extends Catalogo> {
    private List<T> elementos;

    public GestorCatalogos() {
        elementos = new ArrayList<>();
    }

    public void agregar(T elemento) {
        elementos.add(elemento);
        JOptionPane.showMessageDialog(null, "Elemento agregado: " + elemento.getId());
    }

    public void editar(int id, T nuevoElemento) {
        for (int i = 0; i < elementos.size(); i++) {
            if (elementos.get(i).getId() == id) {
                elementos.set(i, nuevoElemento);
                JOptionPane.showMessageDialog(null, "Elemento editado: " + id);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Elemento no encontrado: " + id);
    }

    public void inactivar(int id) {
        for (T elemento : elementos) {
            if (elemento.getId() == id) {
                elemento.inactivar();
                JOptionPane.showMessageDialog(null, "Elemento inactivado: " + id);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Elemento no encontrado: " + id);
    }

    public void mostrarTodos() {
        StringBuilder sb = new StringBuilder();
        for (T elemento : elementos) {
            sb.append("ID: ").append(elemento.getId()).append(", Activo: ").append(elemento.isActivo()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
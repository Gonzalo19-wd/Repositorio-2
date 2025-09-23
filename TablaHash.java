package PanetonBono;
import java.util.LinkedList;
public class TablaHash {
    // Tamaño fijo de la tabla
    private final int TAMANIO = 10;
    // Cada posición tiene una lista (para manejar colisiones)
    private LinkedList<String>[] tabla;

    @SuppressWarnings("unchecked")
    public TablaHash() {
        tabla = new LinkedList[TAMANIO];
        for (int i = 0; i < TAMANIO; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    // Función hash simple: calcula índice a partir del hashcode del string
    private int funcionHash(String clave) {
        return Math.abs(clave.hashCode() % TAMANIO);
    }

    // Insertar elemento en la tabla hash
    public void insertar(String clave) {
        int indice = funcionHash(clave);
        if (!tabla[indice].contains(clave)) {
            tabla[indice].add(clave);
        }
    }

    // Buscar un elemento en la tabla hash
    public boolean buscar(String clave) {
        int indice = funcionHash(clave);
        return tabla[indice].contains(clave);
    }

    // Mostrar toda la tabla
    public void mostrarTabla() {
        for (int i = 0; i < TAMANIO; i++) {
            System.out.println(i + " -> " + tabla[i]);
        }
    }

    // Programa principal
    public static void main(String[] args) {
        TablaHash miTabla = new TablaHash();

        // Insertar elementos
        miTabla.insertar("Carlos");
        miTabla.insertar("Ana");
        miTabla.insertar("Luis");
        miTabla.insertar("Maria");
        miTabla.insertar("Pedro");

        // Mostrar tabla
        System.out.println("Contenido de la tabla:");
        miTabla.mostrarTabla();

        // Buscar elementos
        String nombre1 = "Ana";
        String nombre2 = "Sofía";

        System.out.println("\nBuscando '" + nombre1 + "': " + miTabla.buscar(nombre1));
        System.out.println("Buscando '" + nombre2 + "': " + miTabla.buscar(nombre2));
    }
}
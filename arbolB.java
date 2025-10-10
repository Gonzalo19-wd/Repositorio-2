package javaapplication67;
import java.util.ArrayList;
import java.util.List;

class NodoB {
    List<Integer> claves;
    List<NodoB> hijos;
    boolean esHoja;

    public NodoB(boolean esHoja) {
        this.claves = new ArrayList<>();
        this.hijos = new ArrayList<>();
        this.esHoja = esHoja;
    }
}

class ArbolB {
    NodoB raiz;
    int grado;  // grado mínimo (t)

    public ArbolB(int grado) {
        this.raiz = new NodoB(true);
        this.grado = grado;
    }

    public boolean busqueda(NodoB nodo, int clave) {
        int i = 0;
        // Encontrar la primera clave mayor o igual que la buscada
        while (i < nodo.claves.size() && clave > nodo.claves.get(i)) {
            i++;
        }

        // Si encontramos la clave
        if (i < nodo.claves.size() && clave == nodo.claves.get(i)) {
            return true;
        }

        // Si es hoja y no se encontró
        if (nodo.esHoja) {
            return false;
        }

        // Simulación de acceso a disco leyendo el hijo i
        System.out.println("Acceso a disco: leyendo nodo hijo en índice " + i);
        return busqueda(nodo.hijos.get(i), clave);
    }
}

public class arbolB {
    public static void main(String[] args) {
        // Construcción manual de un árbol B simple para la demo
        NodoB hoja1 = new NodoB(true);
        hoja1.claves.add(1);
        hoja1.claves.add(3);
        hoja1.claves.add(5);

        NodoB hoja2 = new NodoB(true);
        hoja2.claves.add(7);
        hoja2.claves.add(9);
        hoja2.claves.add(11);

        NodoB raiz = new NodoB(false);
        raiz.claves.add(6);
        raiz.hijos.add(hoja1);
        raiz.hijos.add(hoja2);

        ArbolB arbolB = new ArbolB(2);
        arbolB.raiz = raiz;

        int claveABuscar = 9;
        boolean encontrado = arbolB.busqueda(arbolB.raiz, claveABuscar);
        System.out.println("Clave " + claveABuscar + (encontrado ? " encontrada" : " no encontrada") + " en el árbol B.");
    }
}


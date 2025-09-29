
package javaapplication15;


import java.util.Scanner;

public class TablaHashBidimensional {
    private static final int TAM = 5;   // número de filas (hash buckets)
    private static final int MAX_COL = 3; // número máximo de elementos por fila (colisiones)
    private String[][] tabla;

    public TablaHashBidimensional() {
        tabla = new String[TAM][MAX_COL]; // inicializamos tabla
    }

    // Función hash sencilla (suma ASCII % TAM)
    private int funcionHash(String clave) {
        int suma = 0;
        for (int i = 0; i < clave.length(); i++) {
            suma += clave.charAt(i);
        }
        return suma % TAM;
    }

    // Insertar valor en la tabla hash
    public void insertar(String clave) {
        int fila = funcionHash(clave);

        // Buscar espacio vacío en la fila
        for (int col = 0; col < MAX_COL; col++) {
            if (tabla[fila][col] == null) {
                tabla[fila][col] = clave;
                System.out.println("✅ '" + clave + "' guardado en fila " + fila + ", col " + col);
                return;
            }
        }
        System.out.println("⚠️ No hay espacio en la fila " + fila + " para '" + clave + "'");
    }

    // Buscar valor en la tabla hash
    public boolean buscar(String clave) {
        int fila = funcionHash(clave);
        for (int col = 0; col < MAX_COL; col++) {
            if (clave.equals(tabla[fila][col])) {
                return true;
            }
        }
        return false;
    }

    // Mostrar la tabla completa
    public void mostrarTabla() {
        System.out.println("\n📚 Contenido de la tabla hash:");
        for (int i = 0; i < TAM; i++) {
            System.out.print("Fila " + i + " → ");
            for (int j = 0; j < MAX_COL; j++) {
                if (tabla[i][j] != null) {
                    System.out.print("[" + tabla[i][j] + "] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }

    // Programa principal
    public static void main(String[] args) {
        TablaHashBidimensional tabla = new TablaHashBidimensional();
        Scanner sc = new Scanner(System.in);

        // Insertamos algunos valores
        tabla.insertar("Don Quijote");
        tabla.insertar("Cien años de soledad");
        tabla.insertar("Rayuela");
        tabla.insertar("El principito");
        tabla.insertar("Crimen y castigo");
        tabla.insertar("La odisea");

        tabla.mostrarTabla();

        // Buscar un libro
        System.out.print("\n🔍 Ingresa el título a buscar: ");
        String titulo = sc.nextLine();

        if (tabla.buscar(titulo)) {
            System.out.println("✅ El libro '" + titulo + "' está en la tabla.");
        } else {
            System.out.println("❌ El libro '" + titulo + "' no se encuentra en la tabla.");
        }

        sc.close();
    }
}

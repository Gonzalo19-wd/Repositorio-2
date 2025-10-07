package ordenararchivosnumeros;

import java.io.*;
import java.util.*;

public class HashBusquedaExterna {
    private static final int TAM = 3; // número de "bloques" o archivos
    private File[] bloques; // archivos que simulan bloques de disco

    public HashBusquedaExterna() {
        bloques = new File[TAM];
        for (int i = 0; i < TAM; i++) {
            bloques[i] = new File("bloque_" + i + ".txt");
            try {
                if (!bloques[i].exists()) {
                    bloques[i].createNewFile();
                }
            } catch (IOException e) {
                System.out.println("Error creando bloque: " + e.getMessage());
            }
        }
    }

    // 🔹 Función hash con mezcla XOR
    private int funcionHash(String clave) {
        int hash = 0;
        for (int i = 0; i < clave.length(); i++) {
            hash ^= clave.charAt(i); // mezcla con XOR
        }
        return Math.abs(hash) % TAM;
    }

    // 🔹 Inserta un registro (clave, valor) en el bloque correspondiente
    public void insertar(String clave, String valor) {
        int indice = funcionHash(clave);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bloques[indice], true))) {
            bw.write(clave + ":" + valor);
            bw.newLine();
            System.out.println("✅ Registro '" + clave + "' guardado en " + bloques[indice].getName());
        } catch (IOException e) {
            System.out.println("❌ Error escribiendo en bloque: " + e.getMessage());
        }
    }

    // 🔹 Busca un registro leyendo solo el bloque correspondiente
    public void buscar(String clave) {
        int indice = funcionHash(clave);
        boolean encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader(bloques[indice]))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes[0].equalsIgnoreCase(clave)) {
                    System.out.println("🔍 Encontrado: " + partes[0] + " → " + partes[1]);
                    encontrado = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error leyendo bloque: " + e.getMessage());
        }

        if (!encontrado) {
            System.out.println("❌ Clave '" + clave + "' no encontrada.");
        }
    }

    // 🔹 Mostrar contenido de todos los bloques (opcional)
    public void mostrarBloques() {
        System.out.println("\n📂 Contenido de los bloques:");
        for (int i = 0; i < TAM; i++) {
            System.out.println("Bloque " + i + " (" + bloques[i].getName() + "):");
            try (BufferedReader br = new BufferedReader(new FileReader(bloques[i]))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println("  " + linea);
                }
            } catch (IOException e) {
                System.out.println("  Error leyendo bloque: " + e.getMessage());
            }
        }
    }

    // 🔹 Programa principal
    public static void main(String[] args) {
        HashBusquedaExterna hash = new HashBusquedaExterna();
        Scanner sc = new Scanner(System.in);

        // Insertamos algunos libros
        hash.insertar("Don Quijote", "Cervantes");
        hash.insertar("Rayuela", "Cortázar");
        hash.insertar("1984", "Orwell");
        hash.insertar("Fahrenheit 451", "Bradbury");
        hash.insertar("El Principito", "Saint-Exupéry");

        hash.mostrarBloques();

        // Búsqueda
        System.out.print("\n🔎 Ingresa el título del libro a buscar: ");
        String clave = sc.nextLine();
        hash.buscar(clave);

        sc.close();
    }
}

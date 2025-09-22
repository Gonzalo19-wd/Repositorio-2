package tiendapantalones;

import java.util.HashMap;
import java.util.Scanner;

public class NewMain {

    // Método para buscar un nombre en la agenda
    public void BuscarNombre(String nombreBuscado, HashMap<String, String> agenda) {
        if (agenda.containsKey(nombreBuscado)) {
            System.out.println("📱 Número de teléfono de " + nombreBuscado + ": " + agenda.get(nombreBuscado));
        } else {
            System.out.println("⚠️ El nombre " + nombreBuscado + " no se encuentra en la agenda.");
        }
    }

    public static void main(String[] args) {
        // Crear la tabla hash
        HashMap<String, String> agenda = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        NewMain obj = new NewMain();

        // Agregar contactos iniciales a la tabla
        agenda.put("Carlos", "987654321");
        agenda.put("Ana", "912345678");
        agenda.put("Luis", "945678123");
        agenda.put("María", "987123456");
        agenda.put("Jorge", "912987654");
        agenda.put("Lucía", "945321987");
        agenda.put("Pedro", "987456123");
        agenda.put("Sofía", "912654987");
        agenda.put("Miguel", "945789123");
        agenda.put("Elena", "987321654");

        int opcion;
        do {
            System.out.println("\n📒 MENÚ DE AGENDA 📒");
            System.out.println("1. Buscar contacto");
            System.out.println("2. Agregar nuevo contacto");
            System.out.println("3. Mostrar todos los contactos");
            System.out.println("0. Salir");
            System.out.print("👉 Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("🔍 Ingresa el nombre a buscar: ");
                    String nombreBuscado = sc.nextLine();
                    obj.BuscarNombre(nombreBuscado, agenda);
                    break;

                case 2:
                    System.out.print("✏️ Ingresa el nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("📱 Ingresa el número de teléfono: ");
                    String nuevoTelefono = sc.nextLine();
                    agenda.put(nuevoNombre, nuevoTelefono);
                    System.out.println("✅ Contacto agregado correctamente.");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}

package tiendapantalones;
import java.util.HashMap;
import java.util.Scanner;

public class AgendaTelefonica {
    public static void main(String[] args) {
        // Crear una tabla hash con HashMap
        HashMap<String, String> agenda = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        // Insertar algunos contactos en la tabla
        agenda.put("Carlos", "987654321");
        agenda.put("Ana", "912345678");
        agenda.put("Luis", "945678123");

        // Mostrar toda la agenda
        System.out.println("Agenda inicial:");
        for (String nombre : agenda.keySet()) {
            System.out.println(nombre + " -> " + agenda.get(nombre));
        }

        // Buscar un contacto
        System.out.print("\nIngresa un nombre para buscar su teléfono: ");
        String nombreBuscado = sc.nextLine();

        if (agenda.containsKey(nombreBuscado)) {
            System.out.println("Teléfono de " + nombreBuscado + ": " + agenda.get(nombreBuscado));
        } else {
            System.out.println("No existe " + nombreBuscado + " en la agenda.");
        }

        // Agregar un nuevo contacto desde teclado
        System.out.print("\nIngresa un nuevo nombre: ");
        String nuevoNombre = sc.nextLine();
        System.out.print("📱 Ingresa su teléfono: ");
        String nuevoTelefono = sc.nextLine();

        agenda.put(nuevoNombre, nuevoTelefono);

        // Mostrar agenda final
        System.out.println("\n Agenda actualizada:");
        for (String nombre : agenda.keySet()) {
            System.out.println(nombre + " -> " + agenda.get(nombre));
        }

        sc.close();
    }
}

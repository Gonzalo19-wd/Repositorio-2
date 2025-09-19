package javaapplication75;
import java.util.HashMap;
import java.util.Scanner;

public class NewMain {
    public void BuscarNombre(String nombreBuscado, HashMap agenda){
        if (agenda.containsKey(nombreBuscado)) {
            System.out.println("Número de teléfono de " + nombreBuscado + ": " + agenda.get(nombreBuscado));
        } else {
            System.out.println("El nombre " + nombreBuscado + " no se encuentra en la agenda.");
        }

        
    }
    
    public static void main(String[] args) {
        // Crear la tabla hash
        HashMap<String, String> agenda = new HashMap<>();

        // Agregar contactos a la tabla
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

        Scanner sc = new Scanner(System.in);
        
        
        
        System.out.print("Ingresa el nombre a buscar: ");
        String nombreBuscado = sc.nextLine();
        sc.close();
        
        
        
    }
}

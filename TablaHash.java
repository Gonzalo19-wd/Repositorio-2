package PanetonBono;
import java.util.HashMap;
import java.util.Scanner;

public class TablaHash {

    public static void main(String[] args) {
        HashMap<String, String> usuarios = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        // Insertar algunos usuarios iniciales
        usuarios.put("carlos", "1234");
        usuarios.put("ana", "abcd");
        usuarios.put("luis", "pass123");
        usuarios.put("maria", "qwerty");

        int opcion;
        do {
            System.out.println("\nSISTEMA DE USUARIOS");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Iniciar sesión (buscar usuario)");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    // Registrar nuevo usuario
                    System.out.print("👤 Ingrese nombre de usuario: ");
                    String nuevoUsuario = sc.nextLine();
                    if (usuarios.containsKey(nuevoUsuario)) {
                        System.out.println("⚠️ El usuario ya existe.");
                    } else {
                        System.out.print("🔑 Ingrese una clave: ");
                        String nuevaClave = sc.nextLine();
                        usuarios.put(nuevoUsuario, nuevaClave);
                        System.out.println("✅ Usuario registrado con éxito.");
                    }
                    break;

                case 2:
                    // Iniciar sesión
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("Clave: ");
                    String clave = sc.nextLine();

                    if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(clave)) {
                        System.out.println("✅ Bienvenido, " + usuario + "!");
                    } else {
                        System.out.println("❌ Usuario o clave incorrectos.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }
}

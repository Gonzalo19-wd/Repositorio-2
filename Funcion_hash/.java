package PanetonBono;
import java.util.HashMap;
import java.util.Scanner;

public class TablaHash {
    public static String hashClave(String clave) {
        int suma = 0;
        for (int i = 0; i < clave.length(); i++) {
            suma += (int) clave.charAt(i);
        }
        return String.valueOf(suma % 1000); // devuelve el hash como String
    }

    public static void main(String[] args) {
        HashMap<String, String> usuarios = new HashMap<>();
        Scanner dato = new Scanner(System.in);

        // Insertar algunos usuarios iniciales con la clave hasheada
        usuarios.put("carlos", hashClave("1234"));
        usuarios.put("ana", hashClave("abcd"));
        usuarios.put("luis", hashClave("pass123"));
        usuarios.put("maria", hashClave("qwerty"));

        int opcion;
        do {
            System.out.println("\nSISTEMA DE USUARIOS");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Iniciar sesión (buscar usuario)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = dato.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    // registrar nuevo usuario
                    System.out.print("Ingrese nombre de usuario: ");
                    String nuevoUsuario = dato.nextLine();
                    if (usuarios.containsKey(nuevoUsuario)) {
                        System.out.println("El usuario ya existe.");
                    } else {
                        System.out.print("Ingrese una clave: ");
                        String nuevaClave = sc.nextLine();
                        usuarios.put(nuevoUsuario, hashClave(nuevaClave));
                        System.out.println("Usuario registrado");
                    }
                    break;

                case 2:
                    // Iniciar sesión
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("Clave: ");
                    String clave = sc.nextLine();

                    String claveHash = hashClave(clave);
                    if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(claveHash)) {
                        System.out.println("Bienvenido, " + usuario + "!");
                    } else {
                        System.out.println("Usuario o clave incorrectos.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }
}


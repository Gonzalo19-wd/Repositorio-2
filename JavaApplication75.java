package javaapplication75;
import java.util.Scanner;
import libre.Peaje;
public class JavaApplication75 {

    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        String Seguir;
        String Menu = "Ingrese vehiculo:"
                + "\n(1) Auto"
                + "\n(2) Vans"
                + "\n(3) Buses"
                + "\n(4) Camiones";
        
        do {            
            
            System.out.println(Menu);
            int opcion = dato.nextInt();
            Peaje peaje = new Peaje(opcion);
            System.out.println(Peaje.MostraTotalMonto(peaje));
            System.out.println("Desea continuar?");
            Seguir = dato.next();
        } while (Seguir.equalsIgnoreCase("si"));
                
                
    }
    
}

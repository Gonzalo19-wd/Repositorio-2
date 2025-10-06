package ordenararchivosnumeros;

public class NewClass {
    //El más clásico: usar el resto de la división entre la clave y el tamaño de la tabla.

    private int funcionHash(int clave, int tam) {
        return clave % tam;
    }

    //Muy rápido pero puede fallar si las claves siguen un patrón (ej: claves consecutivas y tam mal elegido). Lo ideal es que
}

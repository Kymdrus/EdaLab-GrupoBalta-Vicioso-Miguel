package Colas;

/**
 * Excepción personalizada que indica que no hay suficientes acciones disponibles
 * para realizar una operación solicitada.
 *
 * <p>Se lanza típicamente cuando un usuario intenta vender o transferir más
 * acciones de las que posee.</p>
 *

 */
public class Exceptionnotenoughshares extends Exception {

    /**
     * Construye una nueva excepción {@code Exceptionnotenoughshares} con el
     * mensaje predeterminado: "No tienes suficientes acciones".
     */
    public Exceptionnotenoughshares() {
        super("No tienes suficientes acciones");
    }
}

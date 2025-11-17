/**
 * Excepción que se lanza cuando se intenta acceder
 * o eliminar un término que no existe en el diccionario.
 */
public class TerminoNoEncontradoException extends Exception {
    /**
     * Constructor de la excepción.
     * @param mensaje mensaje descriptivo del error.
     */
    public TerminoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}

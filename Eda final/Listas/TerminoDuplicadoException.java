/**
 * Excepción que se lanza cuando se intenta añadir
 * un término ya existente en el diccionario.
 */
public class TerminoDuplicadoException extends Exception {
    /**
     * Constructor de la excepción.
     * @param mensaje mensaje descriptivo del error.
     */
    public TerminoDuplicadoException(String mensaje) {
        super(mensaje);
    }
}

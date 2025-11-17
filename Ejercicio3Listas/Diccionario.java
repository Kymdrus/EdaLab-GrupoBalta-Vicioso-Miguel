import java.util.LinkedList;

/**
 * Clase que implementa un diccionario de términos usando una lista.
 * Permite añadir, eliminar, buscar y contar términos.
 */
public class Diccionario {
    private LinkedList<Entrada> lista;

    /**
     * Constructor del diccionario.
     * Inicializa la lista de entradas.
     */
    public Diccionario() {
        lista = new LinkedList<>();
    }

    /**
     * Añade un nuevo término al diccionario.
     * @param termino término a añadir.
     * @param definicion definición asociada.
     * @throws TerminoDuplicadoException si el término ya existe.
     */
    public void anadir(String termino, String definicion) throws TerminoDuplicadoException {
        Entrada nueva = new Entrada(termino, definicion);
        if (lista.contains(nueva)) {
            throw new TerminoDuplicadoException("El término '" + termino + "' ya existe.");
        }
        lista.add(nueva);
    }

    /**
     * Elimina un término del diccionario.
     * @param termino término a eliminar.
     * @throws TerminoNoEncontradoException si el término no existe.
     */
    public void eliminar(String termino) throws TerminoNoEncontradoException {
        Entrada temp = new Entrada(termino, "");
        if (!lista.remove(temp)) {
            throw new TerminoNoEncontradoException("El término '" + termino + "' no está en el diccionario.");
        }
    }

    /**
     * Busca una entrada en el diccionario.
     * @param termino término a buscar.
     * @return la entrada encontrada.
     * @throws TerminoNoEncontradoException si el término no existe.
     */
    public Entrada buscar(String termino) throws TerminoNoEncontradoException {
        for (Entrada e : lista) {
            if (e.getTermino().equalsIgnoreCase(termino)) {
                return e;
            }
        }
        throw new TerminoNoEncontradoException("El término '" + termino + "' no está en el diccionario.");
    }

    /**
     * Devuelve el número de términos definidos en el diccionario.
     * @return número de términos.
     */
    public int numeroTerminos() {
        return lista.size();
    }
}

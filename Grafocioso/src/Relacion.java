import graphsDSESIUCLM.Element;

/**
 * Representa la relación o interacción entre dos personajes en el grafo.
 * Implementa la interfaz Element.
 * * @param <E> Tipo numérico para el peso de la relación.
 * * @author BALTER MANUEL CASTILLO CUEVAS
 * @author MIGUEL ROMO SERRANO
 * @author ALEJANDRO VICIOSO OVIEDO
 */
public class Relacion<E extends Number> implements Element {
    /** Peso de la interacción (frecuencia o intensidad) */
    private E peso;
    /** Identificador único de la relación basado en los vértices conectados */
    private String id;

    /**
     * Constructor para una nueva relación entre dos personajes.
     * * @param peso Valor numérico del peso de la arista.
     * @param vertex1ID ID del primer personaje de la relación.
     * @param vertex2ID ID del segundo personaje de la relación.
     */
    public Relacion(E peso, String vertex1ID, String vertex2ID) {
        this.peso = peso;
        this.id = vertex1ID + "-" + vertex2ID;
    }

    /**
     * Obtiene el valor entero del peso de la relación.
     * @return int con el valor del peso.
     */
    public int getPeso() {
        return peso.intValue();
    }

    /**
     * Implementación del método getID para la arista.
     * @return String con el identificador de la relación.
     */
    @Override
    public String getID() {
        return id;
    }
}

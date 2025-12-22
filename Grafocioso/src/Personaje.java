import graphsDSESIUCLM.Element;

/**
 * Representa un personaje dentro del universo de Star Wars para ser utilizado como vértice en un grafo.
 * Implementa la interfaz Element para integrarse con la biblioteca de grafos de la UCLM.
 * * @author BALTER MANUEL CASTILLO CUEVAS
 * @author MIGUEL ROMO SERRANO
 * @author ALEJANDRO VICIOSO OVIEDO
 * @version 1.0
 */
public class Personaje<T> implements Element {
    
    /** Nombre del personaje */
    private String personaje;
    /** Peso o importancia del personaje */
    private int peso;
    /** Color asociado al personaje para representaciones visuales */
    private String color;
    /** Estado de visita del personaje durante los recorridos BFS/DFS */
    private boolean visitado = false;

    /**
     * Constructor para crear una nueva instancia de Personaje.
     * * @param personaje El nombre del personaje.
     * @param peso El peso inicial del personaje.
     * @param color El código de color para el personaje.
     */
    public Personaje(String personaje, int peso, String color){
        this.personaje = personaje;
        this.peso = peso;
        this.color = color;
    }

    /**
     * Obtiene el nombre del personaje.
     * @return String con el nombre del personaje.
     */
    public String getPersonaje() {
        return personaje;
    }

    /**
     * Obtiene el peso del personaje.
     * @return int con el valor del peso.
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Obtiene el color del personaje.
     * @return String con el color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Implementación del método getID requerido por la interfaz Element.
     * @return String que identifica de forma única al personaje (su nombre).
     */
    @Override
    public String getID() {
        return personaje;
    }

    /**
     * Comprueba si el personaje ha sido visitado en un recorrido.
     * @return true si ha sido visitado, false en caso contrario.
     */
    public boolean getVisitado() {
        return visitado;
    }

    /**
     * Actualiza el estado de visita del personaje.
     * @param visitado Nuevo estado de visita.
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}

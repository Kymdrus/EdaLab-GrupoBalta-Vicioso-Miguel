/**
 * Clase que representa una entrada del diccionario.
 * Cada entrada contiene un término y su definición.
 */
public class Entrada implements Comparable<Entrada> {
    private String termino;
    private String definicion;

    /**
     * Constructor de la clase Entrada.
     * @param termino término que actúa como clave.
     * @param definicion definición asociada al término.
     */
    public Entrada(String termino, String definicion) {
        this.termino = termino;
        this.definicion = definicion;
    }

    /**
     * Obtiene el término de la entrada.
     * @return término como String.
     */
    public String getTermino() {
        return termino;
    }

    /**
     * Obtiene la definición de la entrada.
     * @return definición como String.
     */
    public String getDefinicion() {
        return definicion;
    }

    /**
     * Modifica la definición de la entrada.
     * @param definicion nueva definición.
     */
    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    /**
     * Compara esta entrada con otra por el término.
     * @param otra otra entrada a comparar.
     * @return valor negativo, cero o positivo según el orden alfabético.
     */
    @Override
    public int compareTo(Entrada otra) {
        return this.termino.compareToIgnoreCase(otra.termino);
    }

    /**
     * Comprueba si dos entradas son iguales (mismo término).
     * @param obj objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entrada otra = (Entrada) obj;
        return termino.equalsIgnoreCase(otra.termino);
    }

    /**
     * Devuelve el código hash de la entrada (basado en el término).
     * @return código hash como int.
     */
    @Override
    public int hashCode() {
        return termino.toLowerCase().hashCode();
    }

    /**
     * Representación textual de la entrada.
     * @return término y definición en formato String.
     */
    @Override
    public String toString() {
        return termino + ": " + definicion;
    }
}

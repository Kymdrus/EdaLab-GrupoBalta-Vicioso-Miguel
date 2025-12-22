import graphsDSESIUCLM.Element;
public class Relacion<E extends Number> implements Element {
    private E peso;
    private String id;

    public Relacion(E peso, String vertex1ID, String vertex2ID) {
        this.peso = peso;
        this.id = vertex1ID + "-" + vertex2ID;
    }

    public int getPeso() {
        return peso.intValue();
    }

    @Override
    public String getID() {
        return id;
    }
}
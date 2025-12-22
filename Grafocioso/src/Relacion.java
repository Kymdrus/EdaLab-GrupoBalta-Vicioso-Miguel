import graphsDSESIUCLM.Element;

public class Relacion<T> implements Element {
    private int peso;
    private String id;

    public Relacion(int peso, String vertex1ID, String vertex2ID) {
        this.peso = peso;
        this.id = vertex1ID + "-" + vertex2ID;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String getID() {
        return id;
    }
}

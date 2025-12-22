import graphsDSESIUCLM.Element;

public class Personaje<T> implements Element {
    
    private String personaje;
    private int peso;
    private String color;
    private boolean visitado = false;

    public Personaje(String personaje, int peso, String color){
        this.personaje = personaje;
        this.peso = peso;
        this.color = color;
    }

    public String getPersonaje() {
        return personaje;
    }
    public int getPeso() {
        return peso;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String getID() {
        return personaje;
    }

    public boolean getVisitado() {
        return visitado;
    }
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}

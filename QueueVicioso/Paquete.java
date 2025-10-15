public class Paquete {
    
    int n_acciones;
    int valor_accion;

    public Paquete (int n_acciones, int valor_accion){
        this.n_acciones = n_acciones;
        this.valor_accion = valor_accion;
    }

    public int getN_acciones() {
        return n_acciones;
    }
    public int getValor_accion() {
        return valor_accion;
    }
    public void setN_acciones(int n_acciones) {
        this.n_acciones = n_acciones;
    }
    public void setValor_accion(int valor_accion) {
        this.valor_accion = valor_accion;
    }
}

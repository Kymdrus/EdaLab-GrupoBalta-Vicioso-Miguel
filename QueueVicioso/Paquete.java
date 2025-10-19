
import java.util.InputMismatchException;

public class Paquete {
    
    private int n_acciones;
    private int valor_accion;

    public Paquete (int n_acciones, int valor_accion){
        if(n_acciones < 0 || valor_accion < 0){
            throw new InputMismatchException("Parámetros incorrectos");
        }
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
    
    public int vender(int acciones_vender){
        if (acciones_vender < 0){
            throw new InputMismatchException("No se pueden vender acciones negativas");
        }

        if(acciones_vender >= n_acciones){
            int faltantes = acciones_vender - n_acciones;
            n_acciones = 0;
            return faltantes;        }
        else{
            n_acciones -= acciones_vender;
            return 0;
        }
    }

    public int getValor(){
        return n_acciones*valor_accion;
    }
}

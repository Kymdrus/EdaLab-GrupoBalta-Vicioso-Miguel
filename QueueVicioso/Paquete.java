
import java.util.InputMismatchException;
/*Esta clase nos permite crear objetos de tipo Paquete, para ello tenemos 2 variables, el número de acciones
 * y el valor de las acciones. Continene sus respectivos métodos de consulta y modificación. Y un método 
 * que nos ayudará en la venta de las acciones
 */
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
// Métodos de consulta y modificación
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

    /* Este método nos ayuda en la venta de acciones. Se controla que el número de acciones se vayan restando hasta que lleguen 
     * a 0. En caso de que se quieran vender más acciones de las que hay en el paquete, se retornan las acciones faltantes
     * para que se puedan vender del siguiente paquete. Y si se quieren vender una cantidad negativa de acciones, se lanza una excepción
     */
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

    
}

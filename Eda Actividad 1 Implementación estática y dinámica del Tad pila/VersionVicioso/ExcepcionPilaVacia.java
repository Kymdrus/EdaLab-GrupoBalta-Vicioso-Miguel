/**Esta clase define una excepción personalizada llamada ExcepcionPilaVacia que extiende RuntimeException.
 * Se utiliza para indicar que se ha intentado realizar una operación en una pila vacía.
 */
public class ExcepcionPilaVacia extends RuntimeException{

    public ExcepcionPilaVacia (String message){
        super("message");
    }
}
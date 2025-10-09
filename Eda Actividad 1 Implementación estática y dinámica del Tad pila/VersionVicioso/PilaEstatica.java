/**Esta clase implementa una pila estática que puede almacenar elementos de cualquier tipo genérico.
 * Proporciona la implementación de los métodos de Interfaz_pila y representar la pila..
 * La pila se redimensiona automáticamente a un 50% del tamaño anterior cuando alcanza dos tercios de su capacidad.
 */

public class PilaEstatica <T> implements Interfaz_pila<T>{
  

  private int puntero;
  private T[] stack;
  
  public PilaEstatica(int size){
    puntero=0;
    this.stack = (T[]) new Object[size];
  }

/**Este método añade un elemento a la pila. Antes de añadir el elemento, se comprueba si el puntero ha alcanzado
 * dos tercios de la capacidad del array. Si es así, se crea un nuevo array con un tamaño aumentado en un 50%
 * respecto al tamaño anterior, se copian los elementos del array antiguo al nuevo, y se actualiza la referencia
 * del array de la pila al nuevo array. Luego, se añade el elemento que se nos pasó por parámetro en la posición
 * indicada por el puntero, y se incrementa el puntero.
*/
  public void push(T element){

    if(puntero >= 2*stack.length/3){
      T[] newStack = (T[]) new Object[(int) (stack.length*0.5 + stack.length)];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        System.out.print("Redimensionando pila a tamaño " + newStack.length + "\n");
        stack = newStack;
    }
    stack[puntero] = element;
    puntero++;
  }
    
 /**Este método comprueba si la pila está vacía, simplemente comprobando si el puntero es 0 o no*/
  public boolean isEmpty(){
    
    return puntero == 0;
  }
/**Este método nos proporciona el elemento de la cima de la pila sin eleminarlo. Importante mencionar que primero
 * debemos comprobar si la pila está vacía para lanzar la excepción.
 */
  public T top() {
    if(isEmpty()){
            throw new ExcepcionPilaVacia("Su pila esta vacia");
        }

    return stack[puntero -1];
  }
/**Este método elimina el elemento de la cima de la pila y lo devuelve. Primero se comprueba si la pila está vacía
 * para lanzar la excepción. Luego se decrementa el puntero, se guarda el elemento que vamos a devolver, la 
 * posición del array que se corresponde a la cima de la pila se pone a null para dejar esa posición libre y
 * se devuelve el elemento guardado.
*/
  public T pop(){
    if(isEmpty()){
      throw new ExcepcionPilaVacia("Su pila esta vacia");
    }
    
    puntero--;
    T element = stack[puntero];
    stack[puntero] = null;
    return element;
    
}
/**Este método devuelve el tamaño de la pila, simplemente devolviendo el valor del puntero*/
  public int size(){
  return puntero;
}
/**Este método devuelve una cadena de caracteres con todos los elementos de la pila, para ello se utiliza un método
 * recursivo privado que va sacando los elementos de la pila y guardándolos en una cadena, y luego se vuelven a introducir
 * para no desmontar la pila.
*/
  public String toString(){
    String datos= "";
    return Calcular_toString(datos);

}
private String Calcular_toString(String datos){
    if(!isEmpty()){
        T element = pop();
        datos = element + Calcular_toString(datos);
        push(element);
    }
    return datos;
}


}
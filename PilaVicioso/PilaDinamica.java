/** Esta clase hace una implementación dinámica de la pila, se implementan los métodos de la interfaz "Interfaz_pila
 * Esta implementación de pila contiene un nodo que se corresponde al de más arriba de la pila y una variable que
 * nos indica el tamaño según vamos añadiendo elementos a la pila.
 * */

public class PilaDinamica <T> implements Interfaz_pila<T>{

private Node<T> nodo;
private int size;
public PilaDinamica(){
    size = 0;
    nodo = null;
}
/**Este metodo añade un elemento a la pila, aqui debemos tener cuidado con el nodo que creamos, ya que tiene que
 * apuntar al nodo que estaba en la cima de la pila antes de añadir el nuevo elemento, para que no se pierda la referencia
 * a los demás nodos que ya estaban en la pila.
 * */
 
public void push(T element){
    Node <T>aux = new Node<>(element,nodo);
    nodo = aux;
    size++;
}
/**Este método elimina un elemento de la pila y lo devuelve.Cabe recalcar que primero comprobamos si está vacía
 * por si tenemos que lanzar una excepción.Por lo demás, simplemente guardamos el elemento del nodo que está en la cima
 * de la pila, hacemos que el nodo apunte al siguiente nodo y decrementamos el tamaño
 */
public T pop(){

       if(isEmpty()){
            throw new ExcepcionPilaVacia("Su pila esta vacia");
        }
    
   
    T element = nodo.getElement();
    nodo = nodo.getNext();
    size--;
    return element;
}
/**Este método comprueba si la pila está vacía, simplemente comprobando si el nodo que tenemos es nulo o no*/
public boolean isEmpty(){
    
    return nodo == null;
}
/**Este método devuelve el elemento de la pila que esta en la cima sin eliminarlo. Primero se comprueba si se 
 * lanza la excepcion y luego se devuelve el elemento del nodo que tenemos en la cima de la pila.
 * */
public T top(){
    if(isEmpty()){
            throw new ExcepcionPilaVacia("Su pila esta vacia");
        }
    return (T) nodo.getElement();
}
/**Este método devuelve el tamaño de la pila, simplemente devolviendo la variable size*/
public int size(){
    return size;
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


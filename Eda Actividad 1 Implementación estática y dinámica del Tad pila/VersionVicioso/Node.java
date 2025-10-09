/**Esta clase implemeneta una estructura que nos permitirá formar enlaces por referencia de otras quedando 
 * cada nodo formado por un elemento y una referencia al siguiente nodo.
 */

public class Node<T>{

private T element;
private Node<T> next;

    public Node(T element, Node<T> n){
    this.next = n;
    this.element = element;
    }

    public T getElement(){
        return element;
    }
    public Node getNext(){
        return next;
    }
    
}
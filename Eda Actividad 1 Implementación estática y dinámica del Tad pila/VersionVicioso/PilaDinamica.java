public class PilaDinamica <T> implements Interfaz_pila<T>{

private Node<T> nodo;
private int size;
public PilaDinamica(){
    size = 0;
    nodo = null;
}

public void push(T element){
    Node <T>aux = new Node<>(element,nodo);
    nodo = aux;
    size++;
}

public T pop(){

       if(isEmpty()){
            throw new ExcepcionPilaVacia("Su pila esta vacia");
        }
    
   
    T element = nodo.getElement();
    nodo = nodo.getNext();
    size--;
    return element;
}

public boolean isEmpty(){
    
    return nodo == null;
}

public T top(){
    if(isEmpty()){
            throw new ExcepcionPilaVacia("Su pila esta vacia");
        }
    return (T) nodo.getElement();
}

public int size(){
    return size;
}

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
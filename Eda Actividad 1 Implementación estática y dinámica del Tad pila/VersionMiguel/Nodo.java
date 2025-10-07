public class Nodo<T> {
    private T elemento;
    private Nodo<T> next;
    public Nodo(T elemento, Nodo<T> n) {
     this.elemento=elemento;
     next=n;
    }
    public T getElemento(){
        return elemento;
    }
    public Nodo<T> getNext(){
        return next;
    }
    public void setElmento(T elemento){
     this.elemento=elemento;
    }
    public void setNext(Nodo<T> n){
        next=n;
    }
  }
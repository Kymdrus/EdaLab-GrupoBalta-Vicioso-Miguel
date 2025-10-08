public class PilaEstatica <T> implements Interfaz_pila<T>{
  

  private int puntero;
  private T[] stack;
  
  public PilaEstatica(int size){
    puntero=0;
    this.stack = (T[]) new Object[size];
  }


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
    
 
  public boolean isEmpty(){
    
    return puntero == 0;
  }

  public T top() {
    if(isEmpty()){
            throw new ExcepcionPilaVacia("Su pila esta vacia");
        }

    return stack[puntero -1];
  }

  public T pop(){
    if(isEmpty()){
      throw new ExcepcionPilaVacia("Su pila esta vacia");
    }
    
    puntero--;
    T element = stack[puntero];
    stack[puntero] = null;
    return element;
    
}

  public int size(){
  return puntero;
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
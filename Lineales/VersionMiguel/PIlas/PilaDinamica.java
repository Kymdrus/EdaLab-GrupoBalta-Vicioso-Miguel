public class PilaDinamica<T> implements  Interfaz_pila<T>{
     public int Size=0;
     private Nodo<T> nodoUltimo;
     public PilaDinamica(){
      }
     @Override
     public T pop(){
      T elemento=null;
      try {
        if(isEmpty()){
          throw new ExcepcionPilaVacia();
        }else{
          elemento= nodoUltimo.getElemento();
          nodoUltimo=nodoUltimo.getNext();
          Size=Size-1;
        }
      } catch (ExcepcionPilaVacia e) {
        System.out.println(e.getMessage());
      }
        System.out.println(toString());
        return elemento;
     }
      @Override
      public void  push(T elemento){
        Nodo<T> aux= new Nodo<T>(elemento,nodoUltimo);
        nodoUltimo=aux;
        Size=Size+1;
        System.out.println(toString());
      }
        @Override
     public T top(){
        try{ 
          if (isEmpty()){
            throw new ExcepcionPilaVacia();
          }
        }catch(ExcepcionPilaVacia e){
          System.out.println(e.getMessage());
        }
       return nodoUltimo.getElemento();
    }
      @Override
      public int size(){
        return Size;
      }     
      @Override
      public boolean isEmpty(){
        return nodoUltimo==null;
      }
      public String toString(){
        int numero=0;
        if(nodoUltimo==null){
          return " ";
        }
           return "El valor del nodo "+ ++numero + "es: " +nodoUltimo.getElemento().toString() ;  
      }
}
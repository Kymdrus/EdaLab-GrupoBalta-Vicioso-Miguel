public class PilaDinamica<T> implements  Interfaz_pila<T>{
     public int Size;
     public T elemento; 
     private Nodo<T> nodoUltimo;
     public PilaDinamica(int Size){
         this.Size=Size;
      }
     @Override
     public T pop(){
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
        return elemento;
     }
      @Override
      public void  push(T elemento){
        Nodo<T> aux= new Nodo<T>(elemento,nodoUltimo);
        nodoUltimo=aux;
        Size=Size+1;
        
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
        return (nodoUltimo.getElemento()==null);
      }
      public String toString(){
        if(isEmpty()){
          return "";
        }else{
          int numero=-1;
          return "El valor del nodo "+ numero++ + "es: " +nodoUltimo.getElemento().toString() +  toString() ;
          
        }
      }
}
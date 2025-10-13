
public class PilaEstatica<T> implements Interfaz_pila<T>{
  private int n=10;
  private  T [] pila;
  private int puntero=-1;
  String Pilarda;
  public PilaEstatica(){
  pila= (T[]) new Object[n];  
  }
  @Override
  public void  push(T elemento){
    try{
      if (puntero==n-1){
        throw new ExcepcionPilaLlena();
      }else{
        puntero=puntero+1;
        pila[puntero]=elemento;
      }
    }catch(ExcepcionPilaLlena e){
      System.out.println(e.getMessage());
    }
    System.out.println(toString());
  }
  @Override
  public T pop(){
    try{
     if (isEmpty()==true){
      throw new  ExcepcionPilaVacia();
     }else{
      T elemento= pila[puntero];
      puntero=puntero-1;
      System.out.println(toString());
      return pila[puntero];
     }
   }catch(ExcepcionPilaVacia e){
    System.out.println(e.getMessage());
   }
   return null;
  }
  @Override
  public T top(){
    try {
        if(isEmpty()){
           throw new ExcepcionPilaVacia();
        }
    } catch (ExcepcionPilaVacia e) {
      System.out.println(e.getMessage());
      return null;
    }
    return pila[puntero];
  }
  @Override
  public boolean isEmpty(){
     return puntero<0;
  }
  @Override
  public int size(){
      return  puntero+1;
  }
  @Override
public String toString() {
   System.out.println("Elementos:");
   for(int i=0;i<pila.length;i++){
    if (pila[i] != null){
     System.out.println( Pilarda= (pila[i]).toString());
    }
   }
    return " |Tamaño "+ size() +" |Último elemento de la pila "+top()+" |Puntero "+ puntero  ;
    
}
}
import java.util.Stack;
public class PilaEstatica {
  Stack <Object> pila = new Stack<Object>();
  
  public void  push(Object elemento){
     
    pila.push(elemento);
  }
  public Object pop(Object elemento)throws ExcepcionPilaVacia{
    try{
     if (pila.isEmpty()==true){
      throw new  ExcepcionPilaVacia();
     }else{
      return pila.pop();
     }
   }catch(ExcepcionPilaVacia e){
    System.out.println(e.getMessage());
   }
   return null;
  }
  public Object top(Object elemento)throws ExcepcionPilaVacia{
    try {
        if(pila.isEmpty()){

        }
    } catch (Exception e) {
    }

  }

}
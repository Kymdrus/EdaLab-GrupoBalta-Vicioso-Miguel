package  Colas;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
public class Cola {
    Queue<Acciones> q = new LinkedBlockingDeque<>(); public void comprar(Acciones accion){
    
 }
 public int Sell( int precio){
    Acciones aux=null;
    for(Acciones a:q){
     if(aux==null){
      aux=a;
     }
     if (a.compareTo(aux)<0){
      aux=a;
     }
    }
   int TotalEarns=+aux.getPrice()-precio;
    q.remove(aux);
   return TotalEarns;
 }
 
  public void buy(Acciones accion){
   q.add(accion);
  }
  public String toString(){
    return q.toString();
  }

  
}

package  Colas;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
public class Cola {
    Queue<Acciones> q = new LinkedBlockingDeque<>(); public void comprar(Acciones accion){
    
 }
 private int TotalEarns;
 public int Sell(int cantidad ,int precio){
    Acciones aux=null;
    for(Acciones a:q){
     if(aux==null){
      aux=a;
     }
     if (a.compareTo(aux)<0){
      aux=a;
     }
    }
   TotalEarns=+(aux.getamount()*precio-aux.getamount()*aux.getPrice());
   aux.SetAmount(cantidad);
   if(aux.getamount()==0){
      q.remove(aux);
   }
   return TotalEarns;
 }
 
  public boolean  buy (Acciones accion){
   if(q.add(accion)==true){
    return true;
   }
   return false;
  }
  public String toString(){
    return q.toString();
  }
  public int getTotalEarn(){
    return TotalEarns;
  }
  
}

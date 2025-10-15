package  Colas;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
public class Cola {
    Queue<Acciones> q = new LinkedBlockingDeque<>();
    
 
 private int TotalEarns;
 public int Sell(int cantidad ,int precio){
    for(Acciones a:q){
   TotalEarns=+(a.getamount()*precio-a.getamount()*a.getPrice());
   a.SetAmount(cantidad);
   if(a.getamount()==0){
      q.remove(a);
   }
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

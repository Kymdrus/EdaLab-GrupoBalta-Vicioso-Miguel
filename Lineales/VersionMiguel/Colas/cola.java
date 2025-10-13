package  Colas;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Queue;
public class cola implements  Comparable<Object>{
 Queue<Object> q =new LinkedBlockingQueue <Object>();
 public void comprar(Acciones accion){
   q.add(accion);
 }
 public void Sell(Acciones accion, int precio){
    compareTo(accion);
    int TotalEarns=+accion.getPrice()-precio;
    q.remove(accion);

 }
  public int compareTo(Acciones accion) {
        return Double.compare(, otro.precio);
    }
}
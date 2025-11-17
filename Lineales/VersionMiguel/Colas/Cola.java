package Colas;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;


/**
* Cola que gestiona acciones compradas y permite venderlas.
*/
public class Cola {
Queue<Acciones> q = new LinkedBlockingDeque<>();
private int TotalEarns;


/**
* Vende una cantidad de acciones al precio indicado.
* @param cantidad cantidad a vender
* @param precio precio de venta
* @return ganancias totales
*/
public int Sell(int cantidad ,int precio){
for(Acciones a:q){
TotalEarns = +(a.getamount()*precio - a.getamount()*a.getPrice());
a.SetAmount(cantidad);
if(a.getamount()==0){
q.remove(a);
}
}
return TotalEarns;
}


/**
* Compra una acción y la añade a la cola.
* @param accion acción a comprar
* @return true si se agregó correctamente
*/
public boolean buy (Acciones accion){
if(q.add(accion)==true){
return true;
}
return false;
}


/**
* Representación textual de la cola.
*/
public String toString(){
return q.toString();
}


/**
* Obtiene las ganancias totales acumuladas.
* @return ganancias
*/
public int getTotalEarn(){
return TotalEarns;
}
}
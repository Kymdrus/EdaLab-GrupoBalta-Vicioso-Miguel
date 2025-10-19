import java.util.Queue;
import java.util.LinkedList;

public class Cartera {
    private int ganancia = 0;
    private Queue<Paquete> cola;
    public Cartera (){
        cola =  new LinkedList<Paquete>();
    }

    public void comprar(int n_acciones, int valor_accion) {
        Paquete new_paquete = new Paquete(n_acciones, valor_accion);
        cola.add(new_paquete);
        
        System.out.println("La ganancia acumulada es: " + ganancia);

    }

    public void vender(int acciones_vender, int valor_accion) {

        if(acciones_vender > getAcciones()){
            System.out.println("No hay suficientes acciones para vender");
            return;
        }
        if(acciones_vender < 0){
            System.out.println("No se pueden vender acciones negativas");
            return;
        }
        while(acciones_vender > 0){
            if(cola.isEmpty()){
                System.out.println("No hay suficientes acciones para vender");
                return;
            }
            int acciones_antes = acciones_vender;
            acciones_vender = cola.peek().vender(acciones_vender);
            ganancia += valor_accion* (acciones_antes-acciones_vender);
            if(cola.peek().getN_acciones() == 0){
                cola.remove();
            }
            
        }

        System.out.println("La ganancia acumulada es: " + ganancia);
    }

    public int getGanancia(){
        return ganancia;
    }

    public int getAcciones(){
        int acciones_total = 0;
        for(Paquete p : cola){
            acciones_total += p.getN_acciones();
        }
        return acciones_total;
    }
}

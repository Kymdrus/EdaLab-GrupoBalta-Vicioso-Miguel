import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class Main {

static Scanner sc = new Scanner(System.in);
    public static void main (String args[]){
        Queue<Paquete> cola = new LinkedList<Paquete>();
        

    }



    public int comprar(Queue<Paquete> cola){
        int n_acciones;
        int valor_acciones;

        System.out.println("Introduzca el número de acciones: ");
        n_acciones = sc.nextInt();
        System.out.println("Introduzca el valor actual de las acciones: ");
        valor_acciones = sc.nextInt();

        Paquete paquete_x = new Paquete(n_acciones,valor_acciones);
        cola.add(paquete_x);
        System.out.println("Se han comprado " + n_acciones + " acciones a " + valor_acciones + " euros cada una.");
        return n_acciones*valor_acciones;

    }

    public int vender(Queue<Paquete> cola){
        int n_acciones_vendidas;
        int valor_acciones_vendidas;
        System.out.println("Introduzca el número de acciones a vender: ");
        n_acciones_vendidas = sc.nextInt();
        System.out.println("Introduzca el valor actual de las acciones: ");
        valor_acciones_vendidas = sc.nextInt();

        try{
            cola = cola_posventa(n_acciones_vendidas, cola);
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("Ha vendido " + n_acciones_vendidas + " a un precio de " + valor_acciones_vendidas + "\nGanancia: " + n_acciones_vendidas*valor_acciones_vendidas);
        return n_acciones_vendidas*valor_acciones_vendidas;
    }

    private Queue<Paquete> cola_posventa(int n_acciones_vendidas, Queue<Paquete> cola){

        if(n_acciones_vendidas == 0){
            return cola;
        }

        if(cola.isEmpty()){
            throw new NoSuchElementException("Ha intentado vender mas acciones de la que posee");
        }
        else{
            Paquete paquete_x = cola.peek();
            n_acciones_vendidas -= paquete_x.getN_acciones();

            if(n_acciones_vendidas < 0){
                paquete_x.setN_acciones(paquete_x.getN_acciones() + n_acciones_vendidas);
                return cola;
            }
            else{
                cola.remove();
                cola = cola_posventa(n_acciones_vendidas, cola);
                return cola;
            }
        }

    }

}

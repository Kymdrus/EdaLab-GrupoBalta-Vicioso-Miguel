import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;



public class Main {

static Scanner sc = new Scanner(System.in);
    public static void main (String args[]){
        Queue<Paquete> cola = new LinkedList<Paquete>();

    }



    public void comprar(Queue cola){
        int n_acciones;
        int valor_acciones;

        System.out.println("Introduzca el número de acciones: ");
        n_acciones = sc.nextInt();
        System.out.println("Introduzca el valor actual de las acciones: ");
        valor_acciones = sc.nextInt();

        Paquete paquete_x = new Paquete(n_acciones,valor_acciones);
        cola.add(paquete_x);

    }

    public void vender(Queue cola){
        
    }
}

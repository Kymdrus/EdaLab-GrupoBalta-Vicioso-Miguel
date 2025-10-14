package Colas;

public class mains {
    public static void main(String[] args) {
        
    
    Cola colas= new Cola();
    colas.buy(new Acciones(1, 15, 100)); // Enero
    colas.buy(new Acciones(2, 25, 100)); // Febrero
    colas.buy(new Acciones(3, 20, 100)); // Marzo
    colas.Sell(200);
    System.out.println(colas.toString());
  
    }
}

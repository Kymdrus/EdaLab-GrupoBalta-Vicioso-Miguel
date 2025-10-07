public class App {
    public static void main(String[] args) throws Exception {
     PilaEstatica<Integer> pila = new PilaEstatica<>(10);
     
    

    
     PilaDinamica<Integer> piladinamica= new PilaDinamica<>();
     piladinamica.push(10);
     piladinamica.push(9);
     piladinamica.push(8);
     piladinamica.push(6);
     piladinamica.push(7);
     piladinamica.pop(); 
     System.out.println(piladinamica.toString());     
    }
    
}

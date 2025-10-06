public class App {
    public static void main(String[] args) throws Exception {
     PilaEstatica<Integer> pila = new PilaEstatica<>(10);
     
     pila.push(10);
     pila.push(9);
     pila.push(8);
     pila.push(6);
     pila.push(7);

     pila.pop();
    

    }
    
}

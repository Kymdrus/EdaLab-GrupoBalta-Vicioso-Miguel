package Colas;
import java.util.Scanner;
public class mains {
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int number=0;
    Cola colas= new Cola();
    while(number!=4){ 
    System.out.print("1. Comprar\n2. Vender\n3. Consultar precio\n4. Salir\n");
    number=sc.nextInt();
    System.out.println(colas.toString());
    System.out.println("Ingrese un número");
    if(number== 1 || number==2){
        System.out.println("Ingrese el precio");
        int precio=sc.nextInt();
        System.out.println("Ingrese la cantidad");
        int cantidad=sc.nextInt();
        if (number==1){
            System.out.println("Usted está comprando");
            if(colas.buy(new Acciones(precio,cantidad))==true){
            System.out.println("Añadido con éxito");
            }
        }else if(number==2){
            System.out.println("Usted está vendiendo");
            
             colas.Sell(cantidad, precio);
        }
    
    }else if(number==3){
        System.out.println(colas.getTotalEarn());
    }
    }
}
}

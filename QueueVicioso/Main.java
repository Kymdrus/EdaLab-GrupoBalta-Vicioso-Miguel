
import java.util.InputMismatchException;
import java.util.Scanner;

/*  Esta clase es el programa principal en el que implementamos las opciones al usuario y la llamada a los métodos de las distintas clases */

public class Main {

    public static void main (String args[]){
        Cartera cartera = new Cartera();
        Scanner sc = new Scanner(System.in);

        int opcion;
        
        do{
            imprimir_menu();
            opcion = sc.nextInt();
            switch(opcion){

                case 1:
                        try{
                            System.out.println("Ingrese el número de acciones a comprar:");
                            int n_acciones = sc.nextInt();
                            System.out.println("Ingrese el valor por acción:");
                            int valor_accion = sc.nextInt();
                            cartera.comprar(n_acciones, valor_accion);
                        }
                        catch(InputMismatchException e){
                            System.out.println(e.getMessage());
                        }   
                        break;
                case 2:
                    try{
                        System.out.println("Ingrese el número de acciones a vender:");
                        int acciones_vender = sc.nextInt();
                        System.out.println("Ingrese el valor por acción:");
                        int valor_accion_vender = sc.nextInt();
                        cartera.vender(acciones_vender, valor_accion_vender);
                        }
                    catch(InputMismatchException e){
                        System.out.println(e.getMessage());
                        }                       
                        break;
                case 3:
                    System.out.println("La ganancia acumulada es: " + cartera.getGanancia());
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;               
            
            }
        }while(opcion != 4);

        sc.close();
    }
/*  Este método los imprime el menú de opciones */
    public static void imprimir_menu(){
        System.out.println("Elija una de las siguientes opciones");
        System.out.println("1. Comprar acciones");
        System.out.println("2. Vender acciones");
        System.out.println("3. Ver ganancia acumulada");
        System.out.println("4. Salir");
    }

}



    



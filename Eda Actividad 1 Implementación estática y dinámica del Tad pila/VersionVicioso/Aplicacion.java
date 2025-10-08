import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el numero a convertir: \n");
        String numero = sc.nextLine();
        System.out.print("Introduzca la base a utilizar: \n");
        int base = sc.nextInt();
        System.out.println("Introduzca la pila a usar: D o d (Para dinamica) o S o s (Para estatica) ");
        char seleccion = sc.next().charAt(0);
        boolean valido = true;
        while (valido) {
            if(seleccion == 'D' || seleccion == 'd'){
                PilaDinamica<Integer> pila = new PilaDinamica<>();
                System.out.print("El numero " + numero + " en base " + base + " es: " + Cambiar_base(numero, base, pila) + "\n");
                valido = false;
            }
            else if(seleccion == 'S' || seleccion == 's'){
                PilaEstatica<Integer> pila = new PilaEstatica<>(10);
                System.out.print("El numero " + numero + " en base " + base + " es: " + Cambiar_base(numero, base, pila) + "\n");
                valido = false;
            }
            else{
                System.out.print("Opcion no valida, introduzca D o d (Para dinamica) o S o s (Para estatica) \n");
                valido = true;
            }
            
        }

    }

    public static String Cambiar_base(String numero, int base, Interfaz_pila<Integer> pila){
        
        int dividendo = Integer.parseInt(numero);
        int resto = dividendo % base;
        int cociente = dividendo/base;
        
        if(cociente < base){
            
            pila.push(resto);
            pila.push(cociente);

            return pila.toString();
        }
        else{
            pila.push(resto);
            return Cambiar_base(String.valueOf(cociente), base, pila);

        }
        

    }
    
}

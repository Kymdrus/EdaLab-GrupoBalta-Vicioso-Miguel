import java.util.Scanner;

public class Aplicacion {
    /**Este es el método main, en el que pedimos al usuario que introduzca un número y la base a la que quiere convertirlo,
     * así como el tipo de pila que quiere usar (estática o dinámica). Luego se llama al método Cambiar_base para realizar
     * la conversión y se muestra el resultado por pantalla.
     * */
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
            sc.close();
        }

    }

/**Este método realiza de forma recursiva el cambio de base usando una pila auxiliar. Nuestro caso base consiste
 * en que el cociente de la división sea menor que la base, en ese caso simplemente apilamos el resto y el cociente
 * y devolvemos la pila convertida a cadena de caracteres usando toString. En el caso recursivo apilamos el resto y
 * se actializa el dividendo al cociente, llamando de nuevo al método.
 * Detalle importante: el método recibe como parámetro una pila que puede ser estática o dinámica, ya que ambas
 * implementan la misma interfaz.
 */
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

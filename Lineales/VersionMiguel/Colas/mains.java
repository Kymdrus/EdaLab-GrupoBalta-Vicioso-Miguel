package Colas;

import java.util.Scanner;

/**
 * Clase principal del programa encargada de gestionar un menú interactivo
 * para comprar, vender y consultar información relacionada con acciones.
 *
 * <p>El programa permite al usuario realizar las siguientes operaciones:</p>
 * <ul>
 *   <li>Comprar acciones</li>
 *   <li>Vender acciones</li>
 *   <li>Consultar las ganancias totales</li>
 *   <li>Salir del programa</li>
 * </ul>
 *
 * <p>Las operaciones se gestionan mediante una instancia de {@link Cola},
 * que contiene la lógica de almacenamiento y actualización de acciones.</p>
 */
public class mains {

    /**
     * Método principal que ejecuta el programa de gestión de acciones.
     * Presenta un menú al usuario y procesa su selección hasta que decide salir.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        Cola colas = new Cola();

        while (number != 4) {
            System.out.print("1. Comprar\n2. Vender\n3. Consultar precio\n4. Salir\n");
            number = sc.nextInt();
            System.out.println(colas.toString());
            System.out.println("Ingrese un número");

            if (number == 1 || number == 2) {
                System.out.println("Ingrese el precio");
                int precio = sc.nextInt();
                System.out.println("Ingrese la cantidad");
                int cantidad = sc.nextInt();

                if (number == 1) {
                    System.out.println("Usted está comprando");
                    if (colas.buy(new Acciones(precio, cantidad)) == true) {
                        System.out.println("Añadido con éxito");
                    }
                } else if (number == 2) {
                    System.out.println("Usted está vendiendo");
                    colas.Sell(cantidad, precio);
                }

            } else if (number == 3) {
                System.out.println(colas.getTotalEarn());
            }
        }
    }
}

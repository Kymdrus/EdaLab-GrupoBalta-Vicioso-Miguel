import java.util.Scanner;

/**
 * Clase principal que contiene el menú de interacción
 * con el usuario para gestionar el diccionario.
 */
public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        Diccionario diccionario = new Diccionario();
        int opcion;

        do {
            System.out.println("--------------- MENU DICCIONARIO ---------------");
            System.out.println("1. Añadir término");
            System.out.println("2. Eliminar término");
            System.out.println("3. Buscar definición");
            System.out.println("4. Número de términos");
            System.out.println("5. Salir");
            System.out.print("Elige opción: ");
            opcion = Scanner.nextInt();
            Scanner.nextLine(); // limpiar buffer

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Introduce término: ");
                        String termino = Scanner.nextLine();
                        System.out.print("Introduce definición: ");
                        String definicion = Scanner.nextLine();
                        diccionario.anadir(termino, definicion);
                        System.out.println("Término añadido correctamente.");
                        break;
                    case 2:
                        System.out.print("Introduce término a eliminar: ");
                        termino = Scanner.nextLine();
                        diccionario.eliminar(termino);
                        System.out.println("Término eliminado.");
                        break;
                    case 3:
                        System.out.print("Introduce término a buscar: ");
                        termino = Scanner.nextLine();
                        System.out.println("Definición: " + diccionario.buscar(termino).getDefinicion());
                        break;
                    case 4:
                        System.out.println("Número de términos: " + diccionario.numeroTerminos());
                        break;
                    case 5:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 5);

    }
}



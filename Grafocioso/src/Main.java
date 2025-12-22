import java.util.Scanner;
import java.util.StringTokenizer;
import graphsDSESIUCLM.Edge;
import graphsDSESIUCLM.Graph;
import graphsDSESIUCLM.TreeMapGraph;
import graphsDSESIUCLM.Vertex;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

/**
 * Clase principal para la gestión de interacciones entre personajes de Star Wars mediante grafos.
 * Permite cargar datos desde archivos CSV y realizar análisis de centralidad y rutas (BFS/DFS).
 * * @author BALTER MANUEL CASTILLO CUEVAS
 * @author MIGUEL ROMO SERRANO
 * @author ALEJANDRO VICIOSO OVIEDO
 */
public class Main {
    
    /**
     * Punto de entrada de la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Graph<Personaje<String>, Relacion<Integer>> g = new TreeMapGraph<>();
        ArrayList<Vertex<Personaje<String>>> lista_personajes = new ArrayList<Vertex<Personaje<String>>>();
        
        try {
             crear_Graph(g, lista_personajes);
        } catch (IOException e) {
            System.out.println("Error al buscar el archivo\nSaliendo del programa...");
            return;
        }
        
        System.out.println("Numero de personajes: " + g.getN());
        System.out.println("Numero de relaciones: " + g.getM());

        ArrayList<Vertex<Personaje<String>>> mayor = new ArrayList<>();
        ArrayList<Vertex<Personaje<String>>> menor = new ArrayList<>();

        getMayor_Menor(mayor, menor, g);

        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Personajes con MAS relaciones:");
        for(Vertex<Personaje<String>> v : mayor){
            System.out.println("  - " + v.getID());
        }

        System.out.println("\nPersonajes con MENOS relaciones:");
        for(Vertex<Personaje<String>> v : menor){
            System.out.println("  - " + v.getID());
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el método que desea utilizar(BFS o DFS):");
        String MetodoUtilizar = sc.nextLine();
        
        if(MetodoUtilizar.equalsIgnoreCase("BFS")){
            System.out.println("Ingrese 2 personajes y se mostrará la ruta usando BFS");
            System.out.println("Diga el Primer personaje que desea conectar:");
            String Personaje1 = sc.nextLine();
            System.out.println("Diga el Segundo personaje que desea conectar:");
            String Personaje2 = sc.nextLine();
            
            Vertex<Personaje<String>> v1 = buscarPorNombre(lista_personajes, Personaje1.toUpperCase());
            Vertex<Personaje<String>> v2 = buscarPorNombre(lista_personajes, Personaje2.toUpperCase());

            Deque<Vertex<Personaje<String>>> bfs = BFS(v1, v2, g);
            imprimir_BFS(bfs);
            
        } else if(MetodoUtilizar.equalsIgnoreCase("DFS")){    
            System.out.println("Diga el Primer personaje que desea conectar:");
            String Personaje1 = sc.nextLine();
            System.out.println("Diga el Segundo personaje que desea conectar:");
            String Personaje2 = sc.nextLine();
            
            Vertex<Personaje<String>> v1 = buscarPorNombre(lista_personajes, Personaje1.toUpperCase());
            Vertex<Personaje<String>> v2 = buscarPorNombre(lista_personajes, Personaje2.toUpperCase());
            DFS(v1, v2, g);
        } else {
            System.out.println("No es un método válido");
        }
    }

    /**
     * Realiza la creación del grafo cargando vértices y aristas desde archivos CSV específicos.
     * * @param g Grafo donde se insertarán los datos.
     * @param lista_personajes Lista para almacenar las referencias a los vértices creados.
     * @throws IOException Si los archivos del dataset no se encuentran o no pueden leerse.
     */
    public static void crear_Graph(Graph<Personaje<String>,Relacion<Integer>> g, ArrayList<Vertex<Personaje<String>>> lista_personajes) throws IOException {
        Scanner sc_vertices = new Scanner(new File("src/dataset/starwars-full-interactions-allCharacters_vertices.csv"));
        Scanner sc_aristas = new Scanner(new File("src/dataset/starwars-full-interactions-allCharacters_aristas.csv"));
 
        while(sc_vertices.hasNextLine()){
            String linea_vertice = sc_vertices.nextLine();
            StringTokenizer tokenizador = new StringTokenizer(linea_vertice, ",");
            
            String personaje = tokenizador.nextToken();
            int peso = Integer.parseInt(tokenizador.nextToken());
            String color = tokenizador.nextToken();

            Personaje<String> ps = new Personaje<String>(personaje, peso, color);
            lista_personajes.add(g.insertVertex(ps));
        }
        sc_vertices.close();

        System.out.println("Vértices cargados: " + lista_personajes.size());

        while(sc_aristas.hasNextLine()){
            String linea_arista = sc_aristas.nextLine();
            StringTokenizer tokenizador = new StringTokenizer(linea_arista, ",");

            int n1 = Integer.parseInt(tokenizador.nextToken());
            int n2 = Integer.parseInt(tokenizador.nextToken());
            int peso = Integer.parseInt(tokenizador.nextToken());

            Vertex<Personaje<String>> ps1 = lista_personajes.get(n1);
            Vertex<Personaje<String>> ps2 = lista_personajes.get(n2);

            Relacion<Integer> arista = new Relacion<Integer>(peso, ps1.getID(), ps2.getID());
            g.insertEdge(ps1, ps2, arista);
        }
        sc_aristas.close();
    }

    /**
     * Cuenta el número de relaciones incidentes sobre un personaje.
     * * @param g El grafo de estudio.
     * @param p El vértice que representa al personaje.
     * @return El número de aristas incidentes.
     */
    public static int getNrelaciones(Graph<Personaje<String>, Relacion<Integer>> g, Vertex<Personaje<String>> p){
        Iterator<Edge<Relacion<Integer>>> i = g.incidentEdges(p);
        int contador = 0;
        while(i.hasNext()){
            contador++;
            i.next(); 
        }
        return contador;
    }

    /**
     * Identifica los personajes con mayor y menor número de interacciones en el grafo.
     * * @param mayor Lista para almacenar los personajes con el máximo de relaciones.
     * @param menor Lista para almacenar los personajes con el mínimo de relaciones.
     * @param g El grafo a analizar.
     */
    public static void getMayor_Menor(ArrayList<Vertex<Personaje<String>>> mayor, ArrayList<Vertex<Personaje<String>>> menor, Graph<Personaje<String>, Relacion<Integer>> g){
        Iterator<Vertex<Personaje<String>>> i = g.getVertices();
        int max = 0, min = 0;
        
        while(i.hasNext()){
            Vertex<Personaje<String>> actual = i.next();
            int contador = getNrelaciones(g, actual);

            if(max == 0 && min == 0){
                max = min = contador;
                mayor.add(actual);
                menor.add(actual);
            }

            if(contador > max){
                max = contador;
                mayor.clear();
                mayor.add(actual);
            } else if(contador == max){
                mayor.add(actual);
            }

            if(contador < min){
                min = contador;
                menor.clear();
                menor.add(actual);
            } else if(contador == min){
                menor.add(actual);
            }
        }
    }

    /**
     * Ejecuta el algoritmo BFS para encontrar un camino directo entre dos personajes.
     * * @param eleccion1 Personaje de origen.
     * @param eleccion2 Personaje de destino.
     * @param g El grafo de interacciones.
     * @return Deque con el camino encontrado, o null si no existe conexión.
     */
public static Deque<VertexDeque<Deque<Vertex<Personaje<String>>>> cola = new LinkedList<>();

    Deque<Vertex<Personaje<String>>> inicio = new LinkedList<>();
    inicio.add(eleccion1);
    cola.add(inicio);
    eleccion1.getElement().setVisitado(true);

    while (!cola.isEmpty()) {
        Deque<Vertex<Personaje<String>>> camino = cola.poll();
        Vertex<Personaje<String>> u = camino.getLast();

        if (u == eleccion2) {
            System.out.println("Camino mas corto encontrado");
            return camino; 
        }

        Iterator<Edge<Relacion<Integer>>> it = g.incidentEdges(u);
        while (it.hasNext()) {
            Edge<Relacion<Integer>> e = it.next();
            Vertex<Personaje<String>> v = g.opposite(u, e);

            if (!v.getElement().getVisitado()) {
                v.getElement().setVisitado(true);

                Deque<Vertex<Personaje<String>>> nuevoCamino = new LinkedList<>(camino);
                nuevoCamino.addLast(v);

                if (v == eleccion2) {
                    System.out.println("Camino mas corto encontrado");
                    return nuevoCamino;
                }

                cola.add(nuevoCamino);
            }
        }
    }
    
    System.out.println("No se encontró camino");
    return null;
}




    /**
     * Método auxiliar recursivo para el algoritmo DFS buscando el camino de menor peso acumulado.
     * * @param actual Vértice actual en la recursión.
     * @param destino Vértice objetivo.
     * @param g Grafo de estudio.
     * @param caminoActual Lista de vértices que componen la ruta actual.
     * @param pesoAcumulado Suma de pesos de las aristas en la ruta actual.
     * @param pesoMinimo Array de un elemento para almacenar el peso mínimo global encontrado.
     * @param mejorCamino Lista que almacena el camino con el peso mínimo.
     */
    public static void DFSRECUR(Vertex<Personaje<String>> actual, Vertex<Personaje<String>> destino, Graph<Personaje<String>, Relacion<Integer>> g, ArrayList<Vertex<Personaje<String>>> caminoActual, int pesoAcumulado, int[] pesoMinimo, ArrayList<Vertex<Personaje<String>>> mejorCamino) {
       actual.getElement().setVisitado(true);
       caminoActual.add(actual);
       
       if(actual.getID().equals(destino.getID())){
           if(pesoAcumulado < pesoMinimo[0]){
                pesoMinimo[0] = pesoAcumulado;
                mejorCamino.clear();
                mejorCamino.addAll(caminoActual);
            }
       } else {
            Iterator<Edge<Relacion<Integer>>> it = g.incidentEdges(actual);
            while(it.hasNext()){
                Edge<Relacion<Integer>> e = it.next();
                Vertex<Personaje<String>> vecino = g.opposite(actual, e);
                int pesoArista = e.getElement().getPeso();
                if(!vecino.getElement().getVisitado()){
                    DFSRECUR(vecino, destino, g, caminoActual, pesoAcumulado + pesoArista, pesoMinimo, mejorCamino);
                    return;            
                }
            }  
       }
       actual.getElement().setVisitado(false);
       caminoActual.remove(caminoActual.size() - 1);
    }

    /**
     * Ejecuta el algoritmo DFS para encontrar el camino de menor peso entre dos personajes.
     * * @param origen Vértice de inicio.
     * @param destino Vértice final.
     * @param g El grafo de interacciones.
     */
    public static void DFS(Vertex<Personaje<String>> origen, Vertex<Personaje<String>> destino, Graph<Personaje<String>, Relacion<Integer>> g) {
        ArrayList<Vertex<Personaje<String>>> caminoActual = new ArrayList<>();
        ArrayList<Vertex<Personaje<String>>> mejorCamino = new ArrayList<>();
        if (origen == null || destino == null) {
            System.out.println("Origen o destino no válido");
            return;
        }
        int[] pesoMinimo = {Integer.MAX_VALUE};
        DFSRECUR(origen, destino, g,  caminoActual, 0, pesoMinimo, mejorCamino);     
        
        if (mejorCamino.isEmpty()) {
            System.out.println("No existe camino entre los personajes");
            return;
        }
        
        System.out.println("Camino de menor peso:");
        for(Vertex<Personaje<String>> v : mejorCamino){
            System.out.print(v.getID() + " -> ");
        }
        System.out.println("FIN\nPeso total: " + pesoMinimo[0]);
    }

    /**
     * Imprime en consola los resultados obtenidos mediante el recorrido BFS.
     * @param bfs Deque con la secuencia de vértices del camino.
     */
    public static void imprimir_BFS(Deque<Vertex<Personaje<String>>> bfs){
        if (bfs == null) return;
        while(!bfs.isEmpty()){
            Vertex<Personaje<String>> v = bfs.poll();
            v.getElement().setVisitado(false);
            System.out.print(v.getID() + "-->");
        }
        System.out.println("FIN");
    }

    /**
     * Busca un vértice en la lista de personajes comparando el nombre (ID) de forma insensible a mayúsculas.
     * * @param lista Lista de vértices de personajes.
     * @param nombre Nombre del personaje a buscar.
     * @return El vértice encontrado, o null si no existe.
     */
    public static Vertex<Personaje<String>> buscarPorNombre(ArrayList<Vertex<Personaje<String>>> lista, String nombre) {
        for (Vertex<Personaje<String>> v : lista) {
            if (v.getElement().getPersonaje().equalsIgnoreCase(nombre)) {
                return v;     
            }
        }
        System.out.println("No se ha encontrado a: " + nombre);
        return null;
    } 
}



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
public class Main {
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
        if(MetodoUtilizar.equals("BFS")){
            System.out.println("Ingrese 2 personajes y se mostrará la ruta usando BFS");

        int personajes = 1;
        int eleccion = -1;
        Vertex<Personaje<String>> eleccion1 = null;
        Vertex<Personaje<String>> eleccion2 = null;
        System.out.println("Diga el Primer personaje que desea conectar:");
        String Personaje1= sc.nextLine();
        System.out.println("Diga el Segundo personaje que desea conectar:");
        String Personaje2= sc.nextLine();
        
        Vertex<Personaje<String>> v1=  buscarPorNombre(lista_personajes,Personaje1.toUpperCase());
        Vertex<Personaje<String>> v2=  buscarPorNombre(lista_personajes,Personaje2.toUpperCase());

        Deque<Vertex<Personaje<String>>> bfs = BFS(v1, v2, g);

        imprimir_BFS(bfs);
        }else if(MetodoUtilizar.equals("DFS")){    
            System.out.println("Diga el Primer personaje que desea conectar:");
            String Personaje1= sc.nextLine();
            System.out.println("Diga el Segundo personaje que desea conectar:");
            String Personaje2= sc.nextLine();
            
            Vertex<Personaje<String>> v1=  buscarPorNombre(lista_personajes,Personaje1.toUpperCase());
            Vertex<Personaje<String>> v2=  buscarPorNombre(lista_personajes,Personaje2.toUpperCase());
            DFS(v1,v2,g);
        }else{
            System.out.println("No es un método válido");
        }
        
     
      
       
    }
/*  Este metodo realiza la creacion del grafo y la lista de los personajes */
    public static void crear_Graph(Graph<Personaje<String>,Relacion<Integer>> g, ArrayList<Vertex<Personaje<String>>> lista_personajes) throws IOException{

        Scanner sc_vertices = new Scanner(new File("src/dataset/starwars-full-interactions-allCharacters_vertices.csv"));
        Scanner sc_aristas = new Scanner(new File("src/dataset/starwars-full-interactions-allCharacters_aristas.csv"));
 
        String linea_vertice;
        String linea_arista;

        while(sc_vertices.hasNextLine()){
            
            linea_vertice = sc_vertices.nextLine();
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
            linea_arista = sc_aristas.nextLine();
            StringTokenizer tokenizador = new StringTokenizer(linea_arista, ",");

            int n1 = Integer.parseInt(tokenizador.nextToken());
            int n2 = Integer.parseInt(tokenizador.nextToken());
            int peso = Integer.parseInt(tokenizador.nextToken());

            Vertex <Personaje<String>> ps1;
            Vertex <Personaje<String>> ps2;

            ps1 = lista_personajes.get(n1);
            ps2 = lista_personajes.get(n2);

            Relacion<Integer> arista = new Relacion<Integer>(peso, ps1.getID(), ps2.getID());

            System.out.println("Insertando arista: " + ps1.getElement().getPersonaje() + " -> " + ps2.getElement().getPersonaje() + " (peso: " + peso + ")");
            
            g.insertEdge(ps1, ps2, arista);
            
        }
        sc_aristas.close();
    }
/*  Este metodo saca el numero de relaciones que tiene un personaje con el resto */
    public static int getNrelaciones(Graph<Personaje<String>, Relacion<Integer>> g, Vertex<Personaje<String>> p){
    
        Iterator<Edge<Relacion<Integer>>> i = g.incidentEdges(p);
        int contador = 0;

        while(i.hasNext()){
            contador++;
            i.next(); 
        }

        return contador;
    }
/*  Este metodo saca cual es el persoanje con mas numero de interaciones y cual el que menos */
    public static void getMayor_Menor(ArrayList<Vertex<Personaje<String>>> mayor, ArrayList<Vertex<Personaje<String>>> menor, Graph<Personaje<String>, Relacion<Integer>> g){

        Iterator<Vertex<Personaje<String>>> i = g.getVertices();

        int max = 0, min = 0;
        int contador = 0;

        
        Vertex<Personaje<String>> actual;

        while(i.hasNext()){
            actual = i.next();
            contador = getNrelaciones(g, actual);
            System.out.println("Personaje: " + actual.getID() + " | Relaciones: " + contador);

            if(max == 0 && min == 0){
                max = contador;
                min = contador;
                mayor.add(actual);
                menor.add(actual);
            }

            if(contador > max){
                max = contador;
                mayor.clear();
                mayor.add(actual);
            }
            else if(contador == max){
                mayor.add(actual);
            }

            if(contador < min){
                min = contador;
                menor.clear();
                menor.add(actual);
            }
            else if(contador == min){
                menor.add(actual);
            }


        }

    }
/*  Este metodo realiza el algoritmo de bfs */
    public static Deque<Vertex<Personaje<String>>> BFS(Vertex<Personaje<String>> eleccion1, Vertex<Personaje<String>> eleccion2, Graph<Personaje<String>, Relacion<Integer>> g){
        
        Deque<Vertex<Personaje<String>>> cola = new LinkedList<>();
        cola.add(eleccion1);

        while(!cola.isEmpty()){

            Vertex<Personaje<String>> u = cola.poll();

            Iterator<Edge<Relacion<Integer>>> it = g.incidentEdges(u);
            while(it.hasNext()) {
                
                Vertex<Personaje<String>> v = g.opposite(u, it.next());

                if(v == eleccion2){
                    System.out.println("Camino mas corto encontrado");
                    cola.add(v);
                    cola.addFirst(eleccion1);
                    return cola;
                }

                if(v.getElement().getVisitado() == false && cola.contains(v) == false){
                    v.getElement().setVisitado(true);
                    cola.add(v);
                }

            }

        }
        System.out.println("No se encontró camino");
        return null;
    }
/*  Este metodo realiza el algoritmo DFS */   
    public static void DFSRECUR(Vertex<Personaje<String>> actual, Vertex<Personaje<String>> destino, Graph<Personaje<String>, Relacion<Integer>> g, ArrayList<Vertex<Personaje<String>>> caminoActual,int pesoAcumulado, int[] pesoMinimo, ArrayList<Vertex<Personaje<String>>> mejorCamino) {
   
       actual.getElement().setVisitado(true);
       caminoActual.add(actual);
       if(actual.getID().equals(destino.getID())){
       if(pesoAcumulado < pesoMinimo[0]){
            pesoMinimo[0] = pesoAcumulado;
            mejorCamino.clear();
            mejorCamino.addAll(caminoActual);
           // return;
        }
      }else{
        Iterator<Edge<Relacion<Integer>>> it = g.incidentEdges(actual);
           while(it.hasNext()){
             Edge<Relacion<Integer>> e = it.next();
             Vertex<Personaje<String>> vecino = g.opposite(actual, e);
              int pesoArista = e.getElement().getPeso();
         if(vecino.getElement().getVisitado()==false){
            DFSRECUR(vecino, destino, g, caminoActual, pesoAcumulado + pesoArista, pesoMinimo, mejorCamino);
            return;            
         }
          }  
       }
        actual.getElement().setVisitado(false);
        caminoActual.remove(caminoActual.size() - 1);
    }
/*  Este metodo se encarga de imprimir el resultado de DFS */    
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
        System.out.println("FIN");
        System.out.println("Peso total: " + pesoMinimo[0]);

    }
/*  Este metodo se encarga de imprimir el resultado de BFS */
    public static void imprimir_BFS(Deque<Vertex<Personaje<String>>> bfs){
        Vertex<Personaje<String>> v;
        
        while(!bfs.isEmpty()){
            v = bfs.poll();
            v.getElement().setVisitado(false);
            System.out.print(v.getID() + "-->");
            

        }

        System.out.println("FIN");
    }
/*  Este metodo se encarga de buscar los personajes usando el nombre */    
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
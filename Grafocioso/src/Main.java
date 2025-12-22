import graphsDSESIUCLM.*;
import java.util.Scanner;
import java.util.StringTokenizer;
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
        Graph <Personaje, Relacion> g = new TreeMapGraph<>();
        ArrayList<Vertex<Personaje>> lista_personajes = new ArrayList<Vertex<Personaje>>();
        
        try {
             crear_Graph(g, lista_personajes);

        } catch (IOException e) {
            System.out.println("Error al buscar el archivo\nSaliendo del programa...");
            return;
        }
        System.out.println("Numero de personajes: " + g.getN());
        System.out.println("Numero de relaciones: " + g.getM());
        
        

        ArrayList<Vertex<Personaje>> mayor = new ArrayList<>();
        ArrayList<Vertex<Personaje>> menor = new ArrayList<>();

        getMayor_Menor(mayor, menor, g);

        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Personajes con MAS relaciones:");
        for(Vertex<Personaje> v : mayor){
            System.out.println("  - " + v.getID());
        }

        System.out.println("\nPersonajes con MENOS relaciones:");
        for(Vertex<Personaje> v : menor){
            System.out.println("  - " + v.getID());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el método que desea utilizar(BFS o DFS):");
        String MetodoUtilizar = sc.nextLine();
        if(MetodoUtilizar == "BFS"){
            System.out.println("Ingrese 2 personajes y se mostrará la ruta mas corta (BFS)\nSolo se debe ingresar un numero del 0 al 111");

        int personajes = 1;
        int eleccion = -1;
        Vertex<Personaje> eleccion1 = null;
        Vertex<Personaje> eleccion2 = null;

//        do{
//
//            System.out.println("Ingrese su personaje numero" + personajes + ": ");
//            try{
//                eleccion = sc.nextInt();
//            }
//            catch(Exception e){
//                System.out.println("Valor incorrecto, intente de nuevo");
//                continue;
//            }
//
//            if(eleccion >= 0 && eleccion <= 111){
//                
//                if(personajes == 1){
//                    eleccion1 = lista_personajes.get(eleccion);
//                    System.out.println("Personaje seleccionado:\n" + eleccion1.getID());
//                }
//                else{
//                    eleccion2 = lista_personajes.get(eleccion);
//                    System.out.println("Personaje seleccionado:\n" + eleccion2.getID());
//
//                }
//            }
//            else{
//                System.out.println("Indexación no válida, pruebe otro numero\nDebe ser entre 0 y 111\n");
//                continue;
//            }
//            personajes++;
//        }while(personajes < 3);

        Deque<Vertex<Personaje>> bfs = BFS(eleccion1, eleccion2, g);

        imprimir_BFS(bfs);
        }else if(MetodoUtilizar=="DFS"){    
            System.out.println("Diga el Primer personaje que desea conectar:");
            String Personaje1= sc.nextLine();
            Personaje
            DFS()
        }
        
      //DFS 
      
       
    }

    public static void crear_Graph(Graph <Personaje,Relacion> g, ArrayList<Vertex<Personaje>> lista_personajes) throws IOException{

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

            Personaje ps = new Personaje(personaje, peso, color);
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

            Vertex <Personaje> ps1;
            Vertex <Personaje> ps2;

            ps1 = lista_personajes.get(n1);
            ps2 = lista_personajes.get(n2);

            Relacion arista = new Relacion(peso, ps1.getID(), ps2.getID());

            System.out.println("Insertando arista: " + ps1.getElement().getPersonaje() + " -> " + ps2.getElement().getPersonaje() + " (peso: " + peso + ")");
            
            g.insertEdge(ps1, ps2, arista);
            
        }
        sc_aristas.close();
    }

    public static int getNrelaciones(Graph<Personaje, Relacion> g, Vertex<Personaje> p){
    
        Iterator<Edge<Relacion>> i = g.incidentEdges(p);
        int contador = 0;

        while(i.hasNext()){
            contador++;
            i.next(); 
        }

        return contador;
    }

    public static void getMayor_Menor(ArrayList<Vertex<Personaje>> mayor, ArrayList<Vertex<Personaje>> menor, Graph<Personaje, Relacion> g){

        Iterator<Vertex<Personaje>> i = g.getVertices();

        int max = 0, min = 0;
        int contador = 0;

        
        Vertex<Personaje> actual;

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

    public static Deque<Vertex<Personaje>> BFS(Vertex<Personaje> eleccion1, Vertex<Personaje> eleccion2, Graph<Personaje, Relacion> g){
        
        Deque<Vertex<Personaje>> cola = new LinkedList<>();
        cola.add(eleccion1);

        while(!cola.isEmpty()){

            Vertex<Personaje> u = cola.poll();

            Iterator<Edge<Relacion>> it = g.incidentEdges(u);
            while(it.hasNext()) {
                
                Vertex<Personaje> v = g.opposite(u, it.next());

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
   
    public static void DFSRECUR(Vertex<Personaje> actual, Vertex<Personaje> destino, Graph<Personaje, Relacion> g, ArrayList<Vertex<Personaje>> caminoActual,int pesoAcumulado, int[] pesoMinimo, ArrayList<Vertex<Personaje>> mejorCamino) {
       actual.getElement().setVisitado(true);
       caminoActual.add(actual);
      if(actual.equals(destino)){
        if(pesoAcumulado < pesoMinimo[0]){
            pesoMinimo[0] = pesoAcumulado;
            mejorCamino.clear();
            mejorCamino.addAll(caminoActual);
        }
      }else{
        Iterator<Edge<Relacion>> it = g.incidentEdges(actual);
           while(it.hasNext()){
             Edge<Relacion> e = it.next();
             Vertex<Personaje> vecino = g.opposite(actual, e);
              int pesoArista = e.getElement().getPeso();
         if(vecino.getElement().getVisitado()==false){
            DFSRECUR(vecino, destino, g, caminoActual, pesoAcumulado + pesoArista, pesoMinimo, mejorCamino);            
         }
          }  
       }
        caminoActual.remove(caminoActual.size() - 1);
    }
    
    public static void DFS(Vertex<Personaje> origen, Vertex<Personaje> destino, Graph<Personaje, Relacion> g) {
        HashSet<Vertex<Personaje>> visitados = new HashSet<>();
        ArrayList<Vertex<Personaje>> caminoActual = new ArrayList<>();
        ArrayList<Vertex<Personaje>> mejorCamino = new ArrayList<>();
         int[] pesoMinimo = {Integer.MAX_VALUE};
        DFSRECUR(origen, destino, g,  caminoActual, 0, pesoMinimo, mejorCamino);     
        System.out.println("Camino de menor peso:");
         for(Vertex<Personaje> v : mejorCamino){
        System.out.print(v.getID() + " -> ");
         }
        System.out.println("FIN");
        System.out.println("Peso total: " + pesoMinimo[0]);

}

    public static void imprimir_BFS(Deque<Vertex<Personaje>> bfs){
        Vertex<Personaje> v;
        
        while(!bfs.isEmpty()){
            v = bfs.poll();
            v.getElement().setVisitado(false);
            if(bfs.size() == 1){
                System.out.println(v.getID());
                return;
            }
            System.out.print(v.getID() + "-->");
            

        }
    }
    public static void SaberCamino(Vertex<Personaje<String>> personaje1, Vertex<Personaje> personaje2, iterator g){
        Vertex<Personaje<String>> v1= g.getVertex(personaje1.toUpperCase());

    }
    

}
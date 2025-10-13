import java.util.Scanner;
public class ChangeBase<T> {
     Scanner sc =new Scanner(System.in);

    //Change Base
    public  String ChangeBaseStatic( String number, int  base, Interfaz_pila<Integer> pila)
     {
      int numberConverted = Integer.parseInt(number);
     while(numberConverted!=0){
        int result= numberConverted%base;
        pila.push(result);
        numberConverted=numberConverted/base;
     }
     return pila.toString(); 
    }
    public void AskUser(){
        System.out.println("Responda que tipo de Pila desea piladinamica o pilaestatica" );
        String pilaType = sc.nextLine();
        
    }
}

import java.util.Scanner;
public class App {
   
    public static void main(String[] args) throws Exception {
     PilaEstatica<Integer> pila = new PilaEstatica<>();
      Scanner sc=new Scanner(System.in);
     PilaDinamica<Integer> piladinamica= new PilaDinamica<>();
    System.out.println("Que tipo de pila Desea usar: Dinámica o Estática:");
    String StackType= sc.nextLine(); 
      ChangeBase<Object> cambiarBase = new ChangeBase<>();   
     System.out.println("Di un número");
      String number= sc.nextLine(); 
      System.out.println("Di una base");
           int base= sc.nextInt();
      if(StackType=="Dinámica"){
        cambiarBase.ChangeBaseStatic(number,base, piladinamica);  
      }else if(StackType=="Estática"){
        cambiarBase.ChangeBaseStatic(number, base, pila);  
      }
         
    
    
    
       cambiarBase.ChangeBaseStatic("4", 2, piladinamica);     
    
    
    
}
}

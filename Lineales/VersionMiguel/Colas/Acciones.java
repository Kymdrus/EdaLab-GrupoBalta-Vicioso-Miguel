package Colas;

public class Acciones {
    private int price;
    private int amount;
    public Acciones(int price ,int amount){
      
      this.price=price;
      this.amount=amount;
    }
    public int getPrice(){
        return price;
    }

    public void SetAmount(int amount){
     this.amount-=amount;
    }
    public int getamount(){
        return amount;
    }
    
    public String toString() {
    return "Accion ="+  "|Precio "+ price + " |Cantidad "+ amount;
    }
}

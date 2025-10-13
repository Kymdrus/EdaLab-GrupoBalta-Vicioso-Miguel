package Colas;

public class Acciones {
    private String date;
    private int price;
    private int amount;
    public Acciones(String date ,int price ,int amount){
      this.date=date;
      this.price=price;
      this.amount=amount;
    }
    public int getPrice(){
        return price;
    }
    public String date(){
        return date;
    }
}

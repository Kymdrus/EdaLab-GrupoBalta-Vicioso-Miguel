package Colas;

public class Acciones implements  Comparable<Acciones> {
    private int date;
    private int price;
    private int amount;
    public Acciones(int date ,int price ,int amount){
      this.date=date;
      this.price=price;
      this.amount=amount;
    }
    public int getPrice(){
        return price;
    }
    public int date(){
        return date;
    }
    public void SetAmount(int amount){
     this.amount-=amount;
    }
    public int getamount(){
        return amount;
    }
    @Override
    public String toString() {
    return "Accion ="+ " |Fecha " +date+ "|Precio "+ price + " |Cantidad "+ amount;
    }
   

    @Override
    public int compareTo(Acciones accion){
     return Double.compare(this.date, accion.date);
    }
}

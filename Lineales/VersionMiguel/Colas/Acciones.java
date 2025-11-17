package Colas;


/**
* Representa una acción con precio y cantidad.
*/
public class Acciones {
private int price;
private int amount;


/**
* Construye una acción.
* @param price precio de la acción
* @param amount cantidad disponible
*/
public Acciones(int price ,int amount){
this.price=price;
this.amount=amount;
}


/**
* Obtiene el precio.
* @return precio
*/
public int getPrice(){
return price;
}


/**
* Reduce la cantidad disponible.
* @param amount cantidad a restar
*/
public void SetAmount(int amount){
this.amount-=amount;
}


/**
* Obtiene la cantidad disponible.
* @return cantidad
*/
public int getamount(){
return amount;
}


/**
* Retorna representación en texto
*/
public String toString() {
return "Accion ="+ "|Precio "+ price + " |Cantidad "+ amount;
}
}
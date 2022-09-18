package gameobjects;

public class Grocery extends Thing{
    int price;

    public Grocery(String aName, String aDescription, int pc) {
        super(aName, aDescription);
        price = pc;
    }
    public int getPrice(){return price;}
}

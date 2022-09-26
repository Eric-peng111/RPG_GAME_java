package gameobjects;

public class Weapons extends Grocery{
    private int dmg;
    public Weapons(String aName, String aDescription, int pc, int damage) {
        super(aName, aDescription, pc);
        dmg = damage;
    }
    public int getDmg() {
        return dmg;
    }
    public int getPrice(){return price;}
}

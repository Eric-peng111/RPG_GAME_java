package gameobjects;

public class Weapons extends Thing{
    private int dmg;
    public Weapons(String aName, String aDescription, int damage) {
        super(aName, aDescription);
        dmg = damage;
    }
    public int getDmg() {
        return dmg;
    }

    public void setDmg(int damage) {
        dmg = damage;
    }
}

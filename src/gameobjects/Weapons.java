package gameobjects;

public class Weapons extends Thing{
    private int dmg;
    public Weapons(String aName, String aDescription, int dmg) {
        super(aName, aDescription);
        this.dmg =dmg;
    }
}

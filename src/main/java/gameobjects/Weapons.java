package gameobjects;
/** Represents types of items
 * @author Nha Ngo
 */
public class Weapons extends Grocery{
    /** Represents the damage of the weapon.
     */
    private int dmg;

    /**
     * Class Constructor for Weapons
     * @author Nha Ngo
     */
    public Weapons(String aName, String aDescription, int pc, int damage) {
        super(aName, aDescription, pc);
        dmg = damage;
    }
    /**
     * Method to get damage of Weapons
     * @author Nha Ngo
     * @return - int of damage of the Weapons
     */
    public int getDmg() {
        return dmg;
    }
    /**
     * Method to get price of Weapons
     * @author Nha Ngo
     * @return - int of price of the Weapons
     */
    public int getPrice(){return price;}
}

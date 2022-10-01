package gameobjects;

import java.util.ArrayList;
/** Represents an arraylist of weapons
 * @author Enze Peng
 */
public class WeaponContainer extends ArrayList<Weapons> implements java.io.Serializable {

    /**
     * Method to print out list of items in an WeaponContainer
     * @author Enze Peng
     * @return - String describing all items in the WeaponContainer
     */
    public String describeWeapons() {
        String s = "";

        if (this.size() == 0) {
            s = "";
        } else {
            for (int i = 0; i <= this.size() - 1; i++) {
                Weapons t = this.get(i);
                int serial = i + 1;
                s = s + "(" + serial + ") " + t.getName() + ": " + t.getDescription() + "\nDamage per attack: "+t.getDmg() +"\nPrice: " + t.price + "\n";
            }
        }
        return s;
    }
}

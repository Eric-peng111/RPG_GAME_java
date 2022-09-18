package gameobjects;

import java.util.ArrayList;

public class WeaponContainer extends ArrayList<Weapons> implements java.io.Serializable {

    public String describeWeapons() {
        String s = "";

        if (this.size() == 0) {
            s = "";
        } else {
            for (Weapons t : this) {
                s = s + t.getName() + ": " + t.getDescription() + "\nDamage per attack: \n"+t.getDmg();
            }
        }
        return s;
    }
}

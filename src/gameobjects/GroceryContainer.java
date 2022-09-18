package gameobjects;

import java.util.ArrayList;

public class GroceryContainer extends ArrayList<Grocery> implements java.io.Serializable {
    public String describeWeapons() {
        String s = "";

        if (this.size() == 0) {
            s = "";
        } else {
            for (int i = 0; i <= this.size() - 1; i++) {
                Grocery t = this.get(i);
                int serial = i + 1;
                if (t instanceof Weapons)
                {
                s = s + "(" + serial + ") " + t.getName() + ": " + t.getDescription() + "\nDamage per attack: "+ ((Weapons) t).getDmg() +"\nPrice: " + t.price + "\n";}
                else if (t instanceof Item){
                    s = s + "(" + serial + ") " + t.getName() + ": " + t.getDescription() +"\nPrice: " + t.price + "\n";
                }
            }
        }
        return s;
    }
}

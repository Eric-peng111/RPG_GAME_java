package gameobjects;

import java.util.ArrayList;

public class GroceryContainer extends ArrayList<Grocery>  {
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



    public String describeThings() {
        String s = "";

        if (this.size() == 0) {
            s = "Unfortunately, nothing here";
        } else {
            for (Grocery t : this) {
                s = s + t.getName() + ": " + t.getDescription() + "\n";
            }
        }
        return s;
    }



    public Thing thisOb(String aName) {
        Thing athing = null;
        String thingName = "";
        String aNameLowCase = aName.trim().toLowerCase();

        for (Thing t : this) {
            thingName = t.getName().trim().toLowerCase();
            if (thingName.equals(aNameLowCase)) {
                athing = t;
            }
        }
        return athing;
    }
}

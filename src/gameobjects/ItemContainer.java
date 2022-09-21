package gameobjects;

import java.util.ArrayList;

public class ItemContainer extends ArrayList<Item> {


    public String describeThings() {
        String s = "";
        int i=0;

        if (this.size() == 0) {
            s = "";
        } else {
            i++;
            for (Item t : this) {
                s = s + "(" + i + ") " +t.getName() + ": " + t.getDescription() + "\n";
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

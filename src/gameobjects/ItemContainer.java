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
}

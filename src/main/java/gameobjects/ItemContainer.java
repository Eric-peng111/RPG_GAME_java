package gameobjects;

import java.util.ArrayList;
/** Represents an arraylist of items
 * @author Enze Peng
 */
public class ItemContainer extends ArrayList<Item> {

    /**
     * Method to print out list of items in an ItemContainer
     * @author Enze Peng
     * @return - String describing all items in the itemContainer
     */
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

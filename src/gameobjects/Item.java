package gameobjects;

import globals.ItemType;
/** Represents an item in the game
 * @author Sijie Fan
 */
public class Item extends Grocery{
    /** Represents the stat of the item
     */
    public int stat;
    /** Represents the type of the item
     */
    public ItemType type;
    /**
     * Class Constructor for item
     * @author Sijie Fan
     * @param aName - String for name of an item
     * @param aDescription - String for description of an item
     * @param pc - int for price of an item
     * @param st - int for
     */
    public Item(String aName, String aDescription, int pc, int st, ItemType t) {
        super(aName, aDescription, pc);
        stat = st;
        type = t;
    }
    /**
     * Method to use an item in the bag
     * @author Sijie Fan
     * @return - String describing how the item has been used
     */
    public String useItem(){
        Player player = Player.getInstance();
        ItemType tp = type;
        int value = stat;
        switch(tp) {
            case BUFF:
                player.attack = player.attack + value;
            case HEAL:
                if (player.hp + value <= player.maxHp)
                player.hp = player.hp + value;
                else {
                    player.hp = player.maxHp;
                }
        }
        player.bag.remove(this);
        return "You have successfully used "+this.getName()+" !";
    }
}

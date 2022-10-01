package gameobjects;
/** Represents an purchasable thing in the game
 * @author Sijie Fan
 */
public class Grocery extends Thing{
    /** Represents the price of the grocery
     */
    int price;
    /**
     * Class Constructor for Grocery
     * @author Sijie Fan
     * @param aName - String for name of grocery
     * @param aDescription - String for description of grocery
     * @param pc - int for price of grocery
     */
    public Grocery(String aName, String aDescription, int pc) {
        super(aName, aDescription);
        price = pc;
    }
    /**
     * Method to get price of a grocery
     * @author Sijie Fan
     * @return - price of the grocery
     */
    public int getPrice(){return price;}

}

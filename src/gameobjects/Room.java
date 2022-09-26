package gameobjects;

/** Represents a room in the game
 * @author Enze Peng
 */
public class Room extends Thing {
    /** Represents room number in the north of this room
     */
    private int n;
    /** Represents room number in the south of this room
     */
    private int s;
    /** Represents room number in the west of this room
     */
    private int w;
    /** Represents room number in the east of this room
     */
    private int e;
    /** Represents room number down of this room
     */
    private int d;
    /** Represents room number in the town direction of this room
     */
    private int t;
    /** Represents room number in the inside of this room
     */
    private int i;
    /** Represents room number in the outside of this room
     */
    private int o;
    /** Represents all groceries in a room
     */
    private GroceryContainer gc;
    /**
     * Class Constructor for Room
     * @author Enze Peng
     * @param aName - String for name of room
     * @param aDescription - String for description of room
     * @param aN - int for room number in the north of this room
     * @param aS - int for room number in the south of this room
     * @param aW - int for room number in the west of this room
     * @param aE - int for room number in the east of this room
     * @param aD - int for room number down of this room
     * @param aT - int for room number in the town direction of this room
     * @param aI - int for room number in the inside of this room
     * @param aO - int for room number in the outside of this room
     */
    public Room(String aName, String aDescription, int aN, int aS, int aW, int aE, int aD, int aT, int aI, int aO) {
        super(aName, aDescription); // init superclass
        n = aN;
        s = aS;
        w = aW;
        e = aE;
        d = aD;
        t = aT;
        i = aI;
        o = aO;
        this.gc=new GroceryContainer();

    }

    /**
     * Method to get room number in the north of this room
     * @author Enze Peng
     * @return - int representing index of the room in the north of this room
     */
    public int getN() {
        return n;
    }
    /**
     * Method to get room number in the south of this room
     * @author Enze Peng
     * @return - int representing index of the room in the south of this room
     */
    public int getS() {
        return s;
    }
    /**
     * Method to set room number in the south of this room
     * @author Enze Peng
     * @param aS - int representing index of the room in the south of this room
     */
    public void setS(int aS) {
        s = aS;
    }
    /**
     * Method to get room number in the east of this room
     * @author Enze Peng
     * @return - int representing index of the room in the east of this room
     */
    public int getE() {
        return e;
    }
    /**
     * Method to get room number in the west of this room
     * @author Enze Peng
     * @return - int representing index of the room in the west of this room
     */
    public int getW() {
        return w;
    }
    /**
     * Method to get room number down of this room
     * @author Enze Peng
     * @return - int representing index of the room down of this room
     */
    public int getD() {
        return d;
    }
    /**
     * Method to get room number in the town direction of this room
     * @author Enze Peng
     * @return - int representing index of the room in the town direction of this room
     */
    public int getT() {
        return t;
    }
    /**
     * Method to get room number in the inside of this room
     * @author Enze Peng
     * @return - int representing index of the room in the inside of this room
     */
    public int getI() {
        return i;
    }
    /**
     * Method to get room number in the outside of this room
     * @author Enze Peng
     * @return - int representing index of the room in the outside of this room
     */
    public int getO() {
        return o;
    }

    /**
     * Method to set groceries in a room
     * @author Enze Peng
     * @param IC - ItemContainer representing items to be added to the room
     * @param WC - WeaponContainer representing weapons to be added to the room
     */
    public void randomInit(ItemContainer IC,WeaponContainer WC){
        this.gc.clear();
        int i=(int)(Math.random()*IC.size());
        int w=(int)(Math.random()*WC.size());
        ItemContainer ic=(ItemContainer) IC.clone();
        WeaponContainer wc=(WeaponContainer) WC.clone();
        for(int j=0;j<i;j++){
            int t=(int)Math.random()*ic.size();
            this.gc.add(ic.get(t));
            ic.remove(t);
        }

        for(int j=0;j<w;j++){
            int t=(int)Math.random()*wc.size();
            this.gc.add(wc.get(t));
            wc.remove(t);
        }
    }

    /**
     * Method to get all groceries in the room
     * @author Enze Peng
     * @return - GroceryContainer of all groceries in the room
     */
    public GroceryContainer getThings(){
        return this.gc;
    }


    /**
     * Method to be printed out everytime the player enters a room
     * @author Enze Peng
     * @return - String describing a room
     */
    public String describe() {
        String roomdesc;
        String thingsdesc;

        roomdesc = String.format("%s. %s.", getName(), getDescription());
        thingsdesc = getThings().describeThings();
        if (!thingsdesc.isEmpty()) {
            roomdesc += "\nThings here:\n" + thingsdesc;
        }
        return roomdesc+"\n\nif u wanna go deeper to find more adventures，type fight";
    }



}

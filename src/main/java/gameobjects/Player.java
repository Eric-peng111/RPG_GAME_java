package gameobjects;

import java.text.SimpleDateFormat;
import java.util.Date;

/** Represents the player in the game
 * @author Enze Peng
 */
public class Player extends Character {
    /** Singleton instance of player
     */
    private static Player single_instance = null;
    /** Represents the xp of the player
     */
    public int xp;
    /** Represents the gold of the player
     */
    public int gold;
    /** Represents the weapons the player hold
     */
    public WeaponContainer wp;
    /** Represents the bag containing items the player hold
     */
    public ItemContainer bag;

    public String ds;

    /**
     * Class Constructor for Player
     * @author Enze Peng, Sijie Fan
     * @param aName - String for name of player
     * @param aDescription - String for description of player
     * @param aRoom - Room for current location of player
     * @param maxHp - int for max health of player
     * @param attack - int for base attack of player
     * @param xp - int for base xp of player
     * @param gold - int for starting gold of player
     * @param level - int for starting level of player
     * @param weapon - Weapons that the player have from the start
     */
    //the player class constructor is private since this is singleton mode
    //which mean only one player ever created
    private Player(String aName, String aDescription, Room aRoom,int maxHp, int attack, int xp, int gold, int level, Weapons weapon) {
        super(aName, aDescription, aRoom, maxHp, attack, level);//init superclass
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
        this.bag = new ItemContainer();
        this.wp=new WeaponContainer();
        wp.add(weapon); //add default weapon which is a self dagger
    }
    private Player(String aName, String aDescription, Room aRoom,int maxHp, int attack, int xp, int gold, int level, WeaponContainer wp,ItemContainer ic,String time) {
        super(aName, aDescription, aRoom, maxHp, attack, level);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
        this.bag = ic;
        this.wp=wp;
        this.ds=time;
    }
    /**
     * Method to get current gold of player
     * @author Sijie Fan
     * @return - int of current gold the player has
     */
    public int getGold(){
        return this.gold;
    }

    /**
     * Method to get the current player
     * @author Enze Peng
     * @return - Player corresponding to the current player
     */
    public static Player getInstance()
    {
        Weapons sword = new Weapons("self dagger", "one dagger one hero", 100, 250);
        //get instance from singleton mode
        if (single_instance == null)
            single_instance = new Player("player","player in the game", null,1100, 200 , 200, 1000, 1, sword);

        return single_instance;
    }
    /**
     * Method to setup player only for init data before game
     * @author Enze Peng
     * @param aName - String for name of player
     * @param aDescription - String for description of player
     * @param aRoom - Room for current location of player
     * @param maxHp - int for max health of player
     * @param attack - int for base attack of player
     * @param xp - int for base xp of player
     * @param gold - int for starting gold of player
     * @param level - int for starting level of player
     * @param wp - Weapons that the player have from the start
     * @param ic - items that the player have from the start
     * @param t - current time
     * @return - an instance of player
     */

    public static Player setPlayer(String aName, String aDescription, Room aRoom,int maxHp, int attack, int xp, int gold, int level, WeaponContainer wp,ItemContainer ic,String t){
        single_instance=new Player(aName, aDescription, aRoom,maxHp, attack,xp, gold, level,wp,ic,t);
        return single_instance;

    }
    /**
     * Method to generate attack damage of the player
     * @author Enze Peng
     * @return - int of attack damage of the player
     */
    public int attack(){
        return (int) (Math.random()*xp/4+this.level*this.attack);
    }// randomly generate attack value of player in a proper range
    /**
     * Method to generate attack damage of player with a weapon
     * @author Enze Peng
     * @param w - Weapons that Player holds
     * @return - int of attack damage of the player
     */
    public int w_attack(Weapons w){return (int) (Math.random()*xp/4+w.getDmg()*level);}//randomly get attacking value from weapon in a range
    /**
     * Method to check if the player should be upgraded
     * @author Sijie Fan
     */
    public void checkUpgrade(){
        if (xp >= 10){
            xp = xp - 10;
            level = level + 1;
            System.out.println("You have upgraded one level, you are now level " + level + "!.");
            maxHp = maxHp + 100;
            hp = maxHp;
        }
    }
    /**
     * Method to add an item to the bag
     * @author Enze Peng
     * @param t - Item to be added
     */
    public void addToBags(Item t){
        bag.add(t);
    }
    /**
     * Method to add an weapon to Weapons
     * @author Enze Peng
     * @param w - Weapons to be added
     */
    public void addWeapons(Weapons w){
        wp.add(w);
    }
    /**
     * Method to drop item form bag
     * @author Enze Peng
     * @param t - Item to be dropped
     */
    public void dropFromBags(Thing t){
        bag.remove(t);
    }
    /**
     * Method to drop an weapon from Weapons
     * @author Enze Peng
     * @param w - Weapons to be dropped
     */
    public void dropWeapons(Weapons w){
        wp.remove(w);
    }
    /**
     * Method to extract an weapon to or from a room
     * @author Enze Peng
     * @param w - Weapons to be extracted
     * @param i - int of index of the item in the room
     */
    public int extract_W(Weapons w,int i){
        //from param t to decide if to take or drop
        //param t= 1 : take , 2 : drop
       if(i!=1){
           //add this weapon to weapon container of this room
          this.getLocation().getThings().add(w);
          this.dropWeapons(w);
          return i;
       }
        for(Grocery g:getLocation().getThings()){
            if(w.getName().equals(g.getName()))
            {
                //remove thing from location after player takes
                this.getLocation().getThings().remove(g);
                this.addWeapons(w);
                break;
            }

        }
        return i;

    }
    /**
     * Method to extract an item to or from a room
     * @author Enze Peng
     * @param i - Item to be extracted
     * @param t - int of index of the item in the room
     */
    public int extract_I(Item i,int t){
        //from param t to decide if to take or drop
        //param t= 1 : take , 2 : drop
        // item instance from the global weapon repo
       if(t!=1){
           //add this item to item container of this room
           this.getLocation().getThings().add(i);
           // remove this item form bag
           this.dropFromBags(i);
           return t;
       }
       //
        for(Grocery g:getLocation().getThings()){
            if(i.getName().equals(g.getName()))
            {
                ////remove thing from location after player takes
                this.getLocation().getThings().remove(i);
                this.addToBags(i);
                break;
            }

        }
        return t;

    }

    /**
     * Method to return profile of the player
     * @author Enze Peng
     * @return - String of the profile
     */
    public String profile(){
        String s="";
        //setup print line for profile
        s=s+"Name: "+this.getName()+"\nMax fight health: "+maxHp+"\nAttacking: "
                +attack+"\nLevel: "+level+"\nExperience point: "+xp+"\nGold:"+gold;
        return s;
    }
    /**
     * Method to setup  current time to string ds
     * @author Enze Peng
     */

    public void setDate(){
        // setup the current time once call this method
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        ds =formatter.format(date);

    }


}

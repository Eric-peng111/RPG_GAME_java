package gameobjects;
/** Represents an enemy in the game
 * @author Enze Peng
 */
public class Enemy extends Character {
    /** Represents all potential enemies
     */
    public static String[] enemies = {"Giant", "Goblin", "Wolf", "vampire", "Snake", "Demon", "Scorpion", "Slime"};
    /** Represents all potential boss enemies
     */
    public static String[] boss;
    /** Represents gold reward of killing an enemy
     */
    public int goldReward;
    /** Represents exp reward of killing an enemy
     */
    public int expReward;
    /** Represents Reward of defeating an enemy
     */
    public Weapons treasure;
    /**
     * Class Constructor for enemy
     * @author Enze Peng
     * @param aName - String for name of player
     * @param aDescription - String for description of player
     * @param aRoom - Room for current location of player
     * @param maxHp - int for max health of player
     * @param attack - int for base attack of player
     * @param level - int for starting level of player
     * @param goldRwd - int for gold reward of an enemy
     * @param expRwd - int for exp reward of an enemy
     * @param drop - Weapons for the reward dropped
     */
    public Enemy(String aName, String aDescription, Room aRoom, int maxHp,
                 int attack, int level, int goldRwd, int expRwd, Weapons drop) {
        super(aName, aDescription, aRoom, maxHp, attack, level);
        this.hp = maxHp;
        this.goldReward = goldRwd;
        this.expReward = expRwd;
        this.treasure = drop;

    }
    /**
     * Another Class Constructor for enemy
     * @author Enze Peng
     * @param i - int for index in enemy list
     * @param level - int for level of an enemy
     * @param playHP - int for player hp
     */
    public Enemy(int i,int level,int playHP){

        super(enemies[i], "The "+enemies[i]+" is coming", null, 0, 0,level);
        //due to player will be in different stage
        //so the enemy attributes such as attacking value will be setup based on player attributes
        this.attack=200*level/2;
        this.maxHp=3*playHP/2;
        this.hp =3*playHP/2;
        this.goldReward = level * 10;
        this.expReward=10;
    }
    /**
     * Method to generate attack damage of an enemy
     * @author Enze Peng
     * @return - int of attack damage of an enemy
     */
    public int attack(){
        return (int) (Math.random()*10+this.attack);
    }//attack value will be setup in a range randomly

}

/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */

package gameobjects;
/** Represents all characters in the game
 * @author Enze Peng
 */
public class Character {
    /** Represents name of character
     */
    private final String name;
    /** Represents description of character
     */
    private final String description;
    /** Represents location of the character
     */
    private Room location;
    /** Represents the max hp of the character
     */
    public int maxHp;
    /** Represents the hp of the character
     */
    public int hp;
    /** Represents the attack of the character
     */
    public int attack;
    /** Represents the level of the character
     */
    public int level;
    /**
     * Class Constructor for item
     * @author Enze Peng
     * @param aName - String for name of a character
     * @param aDescription - String for description of a character
     * @param aRoom - Room for location of character
     * @param maxHp - int for max health of character
     * @param attack - int for base attack of character
     * @param level - int for level of character
     */
    public Character(String aName, String aDescription, Room aRoom, int maxHp, int attack, int level) {
        this.name = aName;
        this.description = aDescription;
        this.location = aRoom;
        this.maxHp = maxHp;
        this.attack = attack;
        this.level = level;
    }
    /**
     * Method to change location of a character
     * @author Enze Peng
     * @param aRoom - Room for location of character
     */
    public void setLocation(Room aRoom) {
        location = aRoom;
    }
    /**
     * Method to get name of a character
     * @author Enze Peng
     * @return - String representing name of character
     */
    public String getName() {
        return name;
    }
    /**
     * Method to get description of a character
     * @author Enze Peng
     * @return - String representing description of character
     */
    public String getDescription() {
        return description;
    }
    /**
     * Method to get location of a character
     * @author Enze Peng
     * @return - Room representing location of character
     */
    public Room getLocation() {
        return location;
    }
}

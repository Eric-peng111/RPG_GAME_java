/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */

package gameobjects;
/** Represents all objects in the game
 * @author Enze Peng
 */
public class Thing {
     // Basic Thing type that defines all objects in the Adventure
    /** Represents name of the thing
     */
    private final String name;
    /** Represents description of the thing
     */
    private final String description;
    /**
     * Class Constructor for Thing
     * @author Enze Peng
     * @param aName - String for name of thing
     * @param aDescription - String for description of thing
     */
    public Thing(String aName, String aDescription) {
        // constructor
        name = aName;
        description = aDescription;
    }
    /**
     * Method to get name of a thing
     * @author Enze Peng
     * @return - String of the name
     */
    public String getName() {
        return name;
    }
    /**
     * Method to get description of a thing
     * @author Enze Peng
     * @return - String of the description
     */
    public String getDescription() {
        return description;
    }

}

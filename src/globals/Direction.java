package globals;
/** Represents directions the player can go
 * @author Nha Ngo
 */

public enum Direction {
    /** Represents direction north
     */
    NORTH,
    /** Represents direction south
     */
    SOUTH,
    /** Represents direction east
     */
    EAST,
    /** Represents direction west
     */
    WEST,
    /** Represents direction back to town
     */
    TOWN,
    /** Represents direction going inside
     */
    IN,
    /** Represents direction going outside
     */
    OUT,
    /** Represents direction to dungeon
     */
    DUNGEON;
    /** Represents an invalid direction
     */
    public static final int NOEXIT = -1;
};
/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */

package gameobjects;

public class Actor {

    private String name;
    private String description;
    private Room location; // the Room where the Person is at present

    public Actor(String aName, String aDescription, Room aRoom) {
        this.name = aName;
        this.description = aDescription;
        location = aRoom;
    }

    public void setLocation(Room aRoom) {
        location = aRoom;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public Room getLocation() {
        return location;
    }
}

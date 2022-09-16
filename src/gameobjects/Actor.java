/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */

package gameobjects;

public class Actor extends Thing {

    private Room location; // the Room where the Person is at present

    public Actor(String aName, String aDescription, Room aRoom) {
        super(aName, aDescription); // init super class
        location = aRoom;
    }

    public void setLocation(Room aRoom) {
        location = aRoom;
    }

    public Room getLocation() {
        return location;
    }
}

package function;

import gameobjects.Room;
import globals.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    Room town = new Room("town", "A quiet town, with 4 paths and road to the Dungeon\n" + "Where do you wish to go?\n" + "[n,e,s,w or d]\n", 1, 2, 3, 4,5,Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT);

    @Test
    public void getFunc(){
        assertEquals("town",town.getName());
        assertEquals("A quiet town, with 4 paths and road to the Dungeon\n" + "Where do you wish to go?\n" + "[n,e,s,w or d]\n",town.getDescription());

        assertEquals(5,town.getD());
        assertEquals(2,town.getS());
        assertEquals(4,town.getE());
        assertEquals(-1,town.getI());
        assertEquals(1,town.getN());
        assertEquals(-1,town.getO());
        assertEquals(-1,town.getT());
        assertEquals(3,town.getW());
    }
}

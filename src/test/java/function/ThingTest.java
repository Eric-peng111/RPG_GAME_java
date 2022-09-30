package test.java.function;

import gameobjects.*;
import globals.Direction;
import globals.ItemType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThingTest {

    Thing thing = new Thing("thing","a thing");
    Thing grass = new Item("grass","Rough drug",50,30, ItemType.HEAL);
    Thing chain = new Grocery("chain","A golden chain",1000);
    Thing lake = new Room("the Lake", " A beautiful blue lake that sparkles in the night and in the middle floats an orb of water. ", 0, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT);
    Thing blade = new Weapons("blade","a broken blade",25,50);

    @Test
    public void getName(){
        assertEquals("thing", thing.getName());
        assertEquals("blade", blade.getName());
        assertEquals("grass", grass.getName());
        assertEquals("chain", chain.getName());
        assertEquals("the Lake", lake.getName());
    }
    @Test
    public void getDescription(){
        assertEquals("a thing", thing.getDescription());
        assertEquals("a broken blade", blade.getDescription());
        assertEquals("Rough drug", grass.getDescription());
        assertEquals("A golden chain", chain.getDescription());

        assertEquals(" A beautiful blue lake that sparkles in the night and in the middle floats an orb of water. ", lake.getDescription());
    }

}

package test.java.function;

import gameobjects.Actor;
import gameobjects.Enemy;
import gameobjects.Grocery;
import gameobjects.Room;
import globals.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ActorTest {

    Room town = new Room("town", "A quiet town, with 4 paths and road to the Dungeon\n" + "Where do you wish to go?\n" + "[n,e,s,w or d]\n", 1, 2, 3, 4,5, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT);
    Grocery broken_blade = new Grocery("broken blade","a broken blade", 100);
    Actor guide = new Actor("Gary","A friendly guy",town,100,50,10);
    Actor goblin = new Enemy("Goblin","A goblin",town,200,75,10,100,100,broken_blade);
    @Test
    public void getName(){
        assertEquals("Gary",guide.getName());
        assertEquals("Goblin",goblin.getName());
    }
    @Test
    public void getDescription(){
        assertEquals("A friendly guy",guide.getDescription());
        assertEquals("A goblin", goblin.getDescription());
    }
    @Test
    public void getLocation(){
        assertEquals(town,guide.getLocation());
        assertEquals(town,goblin.getLocation());
    }
    @Test
    public void checkInfo(){
        assertEquals(50,guide.attack);
        assertEquals(75,goblin.attack);
        assertEquals(100,guide.maxHp);
        assertEquals(200,goblin.maxHp);
        assertEquals(10,guide.level);
        assertEquals(10,goblin.level);
    }
}

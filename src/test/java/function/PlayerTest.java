package test.java.function;

import gameobjects.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest{
    Player player = Player.getInstance();

    @Test
    public void getGold() {
        int expected = 1000;
        assertEquals(expected, player.getGold());
    }
}
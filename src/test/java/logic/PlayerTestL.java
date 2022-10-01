package test.java.logic;

import game.AdventureGame;
import game.Game;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class PlayerTestL{

    String input,output;
    AdventureGame AG;
    @BeforeClass
    public static void setup(){
        String input,output;
        input ="2";
        InputStream in=new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        AdventureGame AG=new AdventureGame();
    }

    @Test
    public void allGameSample1(){

        AG.game=new Game();
        AG.game.runCommand("e");
        output=AG.game.runCommand("take grass");
        assertEquals("grass is not here",output);
    }

}

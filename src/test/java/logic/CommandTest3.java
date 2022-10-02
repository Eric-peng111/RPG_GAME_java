package test.java.logic;

import game.AdventureGame;
import game.Game;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandTest3 {

    String input,output;
    AdventureGame AG;
    @BeforeClass
    public static void setup(){
        String input,output;
        input ="2";
        InputStream in=new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        AdventureGame AG=new AdventureGame();
        ArrayList<String> list=new ArrayList<>();
    }


    @Test
    public void allGame3(){
        ArrayList<String> list=new ArrayList<>();

        // Set the standard output to use newConsole.
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();

        AG.game=new Game();
        AG.game.runCommand("e");
        System.setOut(new PrintStream(newConsole));
        AG.game.runCommand("profile");
        output=newConsole.toString();
        assertEquals("Name: player\n" +
                "Max fight health: 1100\n" +
                "Attacking: 200\n" +
                "Level: 1\n" +
                "Experience point: 200\n" +
                "Gold:1000\n",output);
    }
}

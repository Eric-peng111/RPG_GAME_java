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

public class CommandTest2 {

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
    public void allGame1(){
        ArrayList<String> list=new ArrayList<>();
        AG.game=new Game();
        AG.game.runCommand("e");
        output=AG.game.runCommand("take grass");
        list.add("grass is not here");
        list.add("grass taken!");
        assertTrue(list.contains(output));
        list.clear();
        output=AG.game.runCommand("take sword");
        list.add("sword is not here");
        list.add("sword taken!");
        assertTrue(list.contains(output));
        list.clear();
        output=AG.game.runCommand("take drug");
        list.add("drug is not here");
        list.add("drug taken!");
        assertTrue(list.contains(output));

    }


}

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

public class CommandTest1 {

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
    public void allGame2(){
        ArrayList<String> list=new ArrayList<>();

        // Set the standard output to use newConsole.
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();

        AG.game=new Game();
        AG.game.runCommand("e");
        System.setOut(new PrintStream(newConsole));
        AG.game.runCommand("help");
        output=newConsole.toString();
        assertEquals("Available commands: \n" +
                "take: take object\n" +
                "drop: drop object from bag\n" +
                "fight: fight with an enemy\n" +
                "shop: access town shop\n" +
                "bag: check bag\n" +
                "profile: check profile\n" +
                "map: check map\n" +
                "save: save current game\n" +
                "load: load game from history\n",output);

    }


}

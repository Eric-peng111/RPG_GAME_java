/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package game;

import java.awt.*;
import java.util.*;     // required for ArrayList
import java.util.List;

import gameobjects.Actor;
import gameobjects.Player;
import gameobjects.Room;
import globals.Direction;

import javax.swing.*;

public class Game {

    private ArrayList <Room>map; // the map - an ArrayList of Rooms    
    private Actor player;  // the player - provides 'first person perspective'
    JFrame window;
    Container container;
    JPanel title, startButton, intro;
    JLabel titleLabel;
    JButton start;

    List<String> commands = new ArrayList<>(Arrays.asList(
            "take", "drop", "look",
            "n", "s", "w", "e"));
    List<String> objects = new ArrayList<>(Arrays.asList("sword", "ring", "snake"));

    public Game() {
        map = new ArrayList<Room>(); // TODO: Make map a Generic list of Room
        // --- construct a new adventure ---
        // Add Rooms to the map
        //                 Room( name,   description,                             N,        S,      W,      E )
        map.add(new Room("town", "you have returned to town", 1, 2, 3, 4));
        map.add(new Room("Lava", "a Lava River. Your path is cut by it, and across the stream is the orb of fire, you see a bridge.", Direction.NOEXIT, 0, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("Water", " a Lake. A beautiful blue lake that sparkles in the night and in the middle floats an orb of water. ", 0, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("Forest", " a Lush Forest.  A field of trees surrounds you, in the distance is an orb of air floating. ", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0));
        map.add(new Room("Cave", "a Cave. As you go deeper, you enter a great opening surrounded by wall of rocks covered in moss, you see an orb of earth in the wall. ", Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT));
        map.add(new Room("Hole", "a massive metal door. In the door, there are 4 elemental locks for air, water, earth and fire", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        
        // create player and place in Room 0 (i.e. the Room at 0 index of map)
        player = Player.getInstance();
        // setup GUI layout
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        container = window.getContentPane();
        // set title for the game
        title = new JPanel();
        title.setBounds(100, 100, 600, 150);
        title.setBackground(Color.white);
        titleLabel = new JLabel("Game Name");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 90));
        // set start button
        startButton = new JPanel();
        startButton.setBounds(300, 400, 200, 100);
        startButton.setBackground(Color.BLUE);
        start = new JButton("START");
        start.setBackground(Color.BLACK);
        start.setForeground(Color.white);
        title.add(titleLabel);
        container.add(title);
        startButton.add(start);
        container.add(startButton);
    }
    public void createGameScreen(){
        intro = new JPanel();
        intro.setBounds(100, 100, 600, 250);
        intro.setBackground(Color.BLUE);
        container.add(intro);
    }

    // access methods
    // map
    private ArrayList getMap() {
        return map;
    }

    private void setMap(ArrayList<Room> aMap) {
        map = aMap;
    }

    // player
    public Actor getPlayer() {
        return player;
    }

    public void setPlayer(Actor aPlayer) {
        player = aPlayer;
    }

    // move a Person (typically the player) to a Room
    private void moveActorTo(Actor p, Room aRoom) {
        p.setLocation(aRoom);
    }

    // move an Actor in direction 'dir'
    private int moveTo(Actor anActor, Direction dir) {
        // return: Constant representing the room number moved to
        // or NOEXIT
        //
        // try to move any Person (typically but not necessarily player)
        // in direction indicated by dir
        Room r = anActor.getLocation();
        int exit;

        switch (dir) {
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            default:
                exit = Direction.NOEXIT; // noexit - stay in same room
                break;
        }
        if (exit != Direction.NOEXIT) {
            moveActorTo(anActor, map.get(exit));
        }
        return exit;
    }

    public int movePlayerTo(Direction dir) {
        // return: Constant representing the room number moved to
        // or NOEXIT (see moveTo())
        //        
        return moveTo(player, dir);
    }

    private void goN() {
        updateOutput(movePlayerTo(Direction.NORTH));
    }

    private void goS() {
        updateOutput(movePlayerTo(Direction.SOUTH));
    }

    private void goW() {
        updateOutput(movePlayerTo(Direction.WEST));
    }

    private void goE() {
        updateOutput(movePlayerTo(Direction.EAST));
    }

    private void updateOutput(int roomNumber) {
        // if roomNumber = NOEXIT, display a special message, otherwise
        // display text (e.g. name and description of room)        
        String s;
        if (roomNumber == Direction.NOEXIT) {
            s = "No Exit!";
        } else {
            Room r = getPlayer().getLocation();
            s = "You are in "
                    + r.getName() + ". " + r.getDescription();
        }
        System.out.println(s);
    }

    public String processVerb(List<String> wordlist) {
        String verb;
        String msg = "";
        
        verb = wordlist.get(0);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        } else {
            switch (verb) {
                case "n":
                    goN();
                    break;
                case "s":
                    goS();
                    break;
                case "w":
                    goW();
                    break;
                case "e":
                    goE();
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    public String processVerbNoun(List<String> wordlist) {
        String verb;
        String noun;
        String msg = "";
        
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        }
        if (!objects.contains(noun)) {
            msg += (noun + " is not a known noun!");
        }
        msg += " (not yet implemented)";
        return msg;
    }

    public String parseCommand(List<String> wordlist) {
        String msg;
        if (wordlist.size() == 1) {
            msg = processVerb(wordlist);
        } else if (wordlist.size() == 2) {
            msg = processVerbNoun(wordlist);
        } else {
            msg = "Only 2 word commands allowed!";
        }
        return msg;
    }

    public static List<String> wordList(String input) {        
        String delims = "[ \t,.:;?!\"']+"; 
        List<String> strlist = new ArrayList<>();      
        String[] words = input.split(delims);
    
        for (String word : words) {
            strlist.add(word);
        }        
        return strlist;
    }

    public void showIntro(){
        String s;
        s = "The king had summoned you to defeat the evil magician VOID.\n " +
                "While you were on your bravery path, the evil magician teleported you into the DUGEON OF DEATH.\n " +
                "You wake up and see 4 paths, facing north, east, south, west and a hole you can jump in.\n" +
                " Where do you wish to go?  \n" +
                "\n" +
                " ";
        System.out.println(s);
    }
    
    public String runCommand(String inputstr) {
        List<String> wordlist;
        String s = "ok";
        String lowstr = inputstr.trim().toLowerCase();        
        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You must enter a command";
            } else {
                wordlist = wordList(lowstr);                
                s = parseCommand(wordlist);
            }
        }
        return s;
    }

}

/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */
package game;

import java.util.*;     // required for ArrayList
import gameobjects.Actor;
import gameobjects.Room;
import globals.Direction;

public class Game {

    private ArrayList <Room>map; // the map - an ArrayList of Rooms    
    private Actor player;  // the player - provides 'first person perspective'

    List<String> commands = new ArrayList<>(Arrays.asList(
            "take", "drop", "look",
            "n", "s", "w", "e"));
    List<String> objects = new ArrayList<>(Arrays.asList("sword", "ring", "snake"));

    public Game() {
        map = new ArrayList<Room>(); // TODO: Make map a Generic list of Room
        // --- construct a new adventure ---
        // Add Rooms to the map
        //                 Room( name,   description,                             N,        S,      W,      E )
        map.add(new Room("Troll Room", "A dank room that smells of troll", Direction.NOEXIT, 2, Direction.NOEXIT, 1));
        map.add(new Room("Forest", "A leafy woodland", Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT));
        map.add(new Room("Cave", "A dismal cave with walls covered in luminous moss", 0, Direction.NOEXIT, Direction.NOEXIT, 3));
        map.add(new Room("Dungeon", "A nasty, dark cell", Direction.NOEXIT, Direction.NOEXIT, 2, Direction.NOEXIT));
        
        // create player and place in Room 0 (i.e. the Room at 0 index of map)
        player = new Actor("player", "a loveable game-player", map.get(0));
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
        s = "You have fallen down a rabbit hole and arrived in\n"+
                "an underground cavern that smells strongly of troll.\n" +
                "Where do you want to go? [Enter n, s, w or e]?\n" +
                "(or enter q to quit)";
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

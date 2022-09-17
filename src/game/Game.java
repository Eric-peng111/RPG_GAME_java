package game;

import java.awt.*;
import java.util.*;     // required for ArrayList
import java.util.List;

import gameobjects.*;
import globals.Direction;
import gameobjects.Player;
import gameobjects.Enemy;
import gameobjects.Room;
import globals.Direction;

import javax.swing.*;



public class Game {
    private BattleSystem bs;

    private ArrayList <Room>map; // the map - an ArrayList of Rooms
    private Player player;  // the player - provides 'first person perspective'

    List<String> commands = new ArrayList<>(Arrays.asList(
            "take", "drop", "look","fight",
            "n", "s", "w", "e","d","t","i","o"));

    public Game() {
        map = new ArrayList<Room>(); // TODO: Make map a Generic list of Room
        Weapons sword = new Weapons("Iron Sword", "A trusty sword", 100);
        Weapons bow = new Weapons("Wooden Bow", "An accurate bow", 150);
        Weapons staff = new Weapons("Magical Staff", "A staff filled with power", 200);
        // --- construct a new adventure ---
        // Add Rooms to the map
        //                 Room( name,   description,                             N,        S,      W,      E,      D,      T,      I,      O )
        map.add(new Room("the Town", "A quiet town, with 4 paths and road to the Dungeon\n" + "Where do you wish to go?\n" + "[n,e,s,w or d]\n", 1, 2, 3, 4,5, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("the Lava River", " Your path is cut by it, and across the stream is the orb of fire, you see a bridge.", Direction.NOEXIT, 0, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT,Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("the Lake", " A beautiful blue lake that sparkles in the night and in the middle floats an orb of water. ", 0, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("the Forest", " A field of trees surrounds you, in the distance is an orb of air floating. ", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("the Cave", " As you go deeper, you enter a great opening surrounded by wall of rocks covered in moss, you see an orb of earth in the wall. ", Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
        map.add(new Room("the DUNGEON OF DEATH", " A massive metal door stand before you. In the door, there are 4 elemental locks for air, water, earth and fire.\n" + "Return to town [t] or Enter in [i]" , Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT,0,6,Direction.NOEXIT));
        map.add(new Room("the arena of the Dungeon", "An Arena covered in blood, before you stands the evil magician VOID.\n" + "Leave the Arena [o]", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT,Direction.NOEXIT,Direction.NOEXIT,5));
        // create player and place in Room 0 (i.e. the Room at 0 index of map)
        bs=new BattleSystem();
        player = Player.getInstance();

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
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player aPlayer) {
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
            case DUNGEON:
                exit = r.getD();
                break;
            case TOWN:
                exit = r.getT();
                break;
            case IN:
                exit = r.getI();
                break;
            case OUT:
                exit = r.getO();
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
        int t =moveTo(player, dir);


        if (t == Direction.NOEXIT) {
            print("No Exit!");
        } else {
            showDetails();
        }
        return t;
    }

    public void showDetails(){
        print("You are in the " + getPlayer().getLocation().describe());
    }
    public void print(String s){
        System.out.println(s);
    }

    void goN() {
        updateOutput(movePlayerTo(Direction.NORTH));
    }

    void goS() {
        updateOutput(movePlayerTo(Direction.SOUTH));
    }

    void goW() {
        updateOutput(movePlayerTo(Direction.WEST));
    }

    void goE() {
        updateOutput(movePlayerTo(Direction.EAST));
    }

    void goD() {
        updateOutput(movePlayerTo(Direction.DUNGEON));
    }

    void goT() {
        updateOutput(movePlayerTo(Direction.TOWN));
    }

    void goI() {
        updateOutput(movePlayerTo(Direction.IN));
    }

    void goO() {
        updateOutput(movePlayerTo(Direction.OUT));
    }


    private void updateOutput(int roomNumber) {
        // if roomNumber = NOEXIT, display a special message, otherwise
        // display text (e.g. name and description of room)
        String s;
        if (roomNumber == Direction.NOEXIT) {
            s = "No Exit!";
        } else {
            Room r = getPlayer().getLocation();
            s = "You arrived at "
                    + r.getName() + ". " + r.getDescription();
        }
        System.out.println(s);
    }


    public String parseCommand(List<String> wordlist) {
        String msg;
        if (wordlist.size() == 1) {
            msg = Command.processVerb(wordlist);
        } else if (wordlist.size() == 2) {
            msg = Command.processVerbNoun(wordlist);
        } else {
            msg = "please input 2 word commands !";
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



    public  void randomFight() {
        print("----------Fight---------------");
        print("you encountered an enemy. Time to fight");
        this.player=bs.battle(new Enemy((int)(Math.random()*5), getPlayer().level, getPlayer().maxHp),getPlayer());
    }


    public void showIntro(){
        String s;
        s = "The king had summoned you to defeat the evil magician VOID.\n"+
                "As you seek for the magician, you found out that he had hid himself in the DUNGEON OF DEATH.\n" +
                "You enter a town and see 4 paths, facing north, east, south, west and the path into the Dungeon.\n" +
                "Where do you wish to go?\n" +
                "[n,e,s,w or d]\n";
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


//public String processVerb(List<String> wordlist) {
//        String verb;
//        String msg = "";
//
//        verb = wordlist.get(0);
//        if (!commands.contains(verb)) {
//            msg = verb + " is not a known verb! ";
//        } else {
//            switch (verb) {
//                case "n":
//                    goN();
//                    break;
//                case "s":
//                    goS();
//                    break;
//                case "w":
//                    goW();
//                    break;
//                case "e":
//                    goE();
//                    break;
//                case "d":
//                    goD();
//                    break;
//                case "t":
//                    goT();
//                    break;
//                case "i":
//                    goI();
//                    break;
//                case "o":
//                    goO();
//                    break;
//                default:
//                    msg = verb + " (not yet implemented)";
//                    break;
//            }
//        }
//        return msg;
//    }
package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Command {

    static List<String> commands = new ArrayList<>(Arrays.asList(
            "take", "drop", "look", "l", "i", "inventory","fight",
            "n", "s", "w", "e",
            "save", "load"));
    static List<String> objects = new ArrayList<>(Arrays.asList("carrot", "sausage",
            "paper", "pencil", "ring", "wombat"));




    static String processVerbNoun(List<String> wordlist) {
        String verb;
        String noun;
        String msg = "";
        boolean error = false;
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
            error = true;
        }
        if (!objects.contains(noun)) {
            msg += (noun + " is not a known noun!");
            error = true;
        }
        if (!error) {
            switch (verb) {
                case "take":
                    //msg = AdventureGame.game.takeOb(noun);
                    break;
                case "drop":
                    //msg = AdventureGame.game.dropOb(noun);
                    break;
                default:
                    msg += " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    static String processVerb(List<String> wordlist) {
        String verb;
        String msg = "";
        verb = wordlist.get(0);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        } else {
            switch (verb) {
                case "n":
                    AdventureGame.game.goN();
                    break;
                case "s":
                    AdventureGame.game.goS();
                    break;
                case "w":
                    AdventureGame.game.goW();
                    break;
                case "e":
                    AdventureGame.game.goE();
                    break;
                case "d":
                    AdventureGame.game.goD();
                    break;
                case "t":
                    AdventureGame.game.goT();
                    break;
                case "i":
                    AdventureGame.game.goI();
                    break;
                case "o":
                    AdventureGame.game.goO();
                    break;
                case "l":
                case "fight":
                    AdventureGame.game.randomFight();
                case "look":
                    //AdventureGame.game.look();
                    break;
                case "inventory":
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    public static void main(String[] args) {

    }
}



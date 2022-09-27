package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Represents commands that the player can use
 * @author Enze Peng, Sijie Fan, Nha Ngo, Qiuyu Chen
 */
public class Command {
    /** Represents the list of available commands
     */
    static List<String> commands = new ArrayList<>(Arrays.asList(
            "take", "drop", "look", "l", "i", "inventory","fight","shop","bag","profile","help","map",
            "n", "s", "w", "e","d","t","i","o",
            "save", "load"));
    /**
     * Method to process dropping or taking an object
     * @author Qiuyu Chen
     * @param wordlist - list of strings representing the word to be processed
     * @param objects - list of strings representing available nouns
     * @return - String representing the result of action
     */
    static String processVerbNoun(List<String> wordlist,List<String> objects) {
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
            msg += (noun + " is not here");
            error = true;
        }
        if (!error) {
            switch (verb) {
                case "take":
                    msg = AdventureGame.game.takeOb(noun);
                    break;
                case "drop":
                    msg = AdventureGame.game.dropOb(noun);
                    break;
                default:
                    msg += " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }
    /**
     * Method to process general user commands
     * @author Nha Ngo, Enze Peng, Sijie Fan
     * @param wordlist - list of strings representing the word to be processed
     * @return - String representing the result of action
     */
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
                case "save":
                    AdventureGame.game.saveGame();
                    break;
                case "fight":
                    AdventureGame.game.randomFight();
                    break;
                case "shop":
                    AdventureGame.game.accessShop();
                    break;
                case "bag":
                    AdventureGame.game.accessBag();
                    break;
                case "profile":
                    AdventureGame.game.showProfile();
                    break;
                case "look":
                    //AdventureGame.game.look();
                    break;
                case "map":
                    AdventureGame.game.showMap();
                case "inventory":
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }
}



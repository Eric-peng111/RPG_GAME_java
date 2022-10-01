package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Represents commands that the player can use
 * @author Enze Peng, Sijie Fan, Nha Ngo, Qiuyu Chen
 * @author Huw Collingbourne (from external resource)
 */
public class Command {
    /** Represents the list of available commands
     */
    static List<String> commands = new ArrayList<>(Arrays.asList(
            "fight","duel","shop","bag","profile","help","map",
            "n", "s", "w", "e","d","t","i","o",
            "save", "load"));
    static List<String> interactions = new ArrayList<>(Arrays.asList(
            "take", "drop"));
    /**
     * Method to process dropping or taking an object
     * @author Qiuyu Chen
     * @param wordlist - list of strings representing the word to be processed
     * @param objects - list of strings representing available nouns
     * @return - String representing the result of action
     */
    static String processVerbNoun(List<String> wordlist,List<String> objects) {
        //the game is only allow two words commands
        //
        String verb;
        String noun = "";
        String msg = "";
        boolean error = false;
        verb = wordlist.get(0);
        if (wordlist.size() == 2)
            noun = wordlist.get(1);
        else {
            noun = wordlist.get(1) + " " + wordlist.get(2);
        }
        // check first word of commands if it contains two words
        if (!interactions.contains(verb)) {
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
     * @author Huw Collingbourne (from external resource)
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
            // convert command into internal functions or sections to make action
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
                case "duel":
                    AdventureGame.game.duel();
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
                case "help":
                    AdventureGame.game.help();
                    break;
                case "map":
                    AdventureGame.game.showMap();
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }
}



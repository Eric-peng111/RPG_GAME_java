package game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/** Class to run the game
 * @author Enze Peng
 */
public class AdventureGame {
    /** Represents the game to be run
     */
    static Game game;
    /**
     * Main Method that runs the game
     * @author Enze Peng
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output;
        game = new Game();
        in = new BufferedReader(new InputStreamReader(System.in));
        game.showIntro();
        do {
            System.out.print("> ");
            input = in.readLine();
            output = game.runCommand(input);
            System.out.println(output);
        } while (!"q".equals(input));
    }

}
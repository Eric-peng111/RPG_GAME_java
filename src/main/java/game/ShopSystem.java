package game;

import gameobjects.*;

import java.util.Scanner;
/** Represents the shopping system in the game
 * @author Sijie Fan
 */
public class ShopSystem {
    /** Represents the scanner to receive user input
     */
    private Scanner scanner;
    /** Represents the current player
     */
    Player player = Player.getInstance();
    /**
     * Class Constructor for ShopSystem
     * @author Sijie Fan
     */
    public ShopSystem(){
        scanner = new Scanner(System.in);
    }

    /**
     * Method for receiving user int put for item for purchase.
     * @author Sijie Fan
     * @param max - int for number of choices allowed
     * @return int acquired from user input
     */
    public int readChoice(int max){
        int input;
        do{
            try{
                input=Integer.parseInt(scanner.next());
            }catch (Exception e){
                input=-1;
                print("pls enter a valid number");
            }
        }while (false);

        return input;
    }
    /**
     * Method for user buying items in the shop
     * @author Sijie Fan
     * @param wc - GroceryContainer for shop items
     */
    public void buyItem(GroceryContainer wc){
        int input = readChoice(wc.size());
        if (input == 0){
            print("You have quited the shop and entered back to the town.");
            return;
        }
        else if (input < 0 || input>wc.size()){
            print("Item does not exist!");
            AdventureGame.game.accessShop();
        }
        for (int i = 0; i <= wc.size() - 1; i++){
            Grocery grocery = wc.get(i);
            int g = player.getGold();
            int p = grocery.getPrice();
            if (input == i + 1){
                if (p > g){
                    print("You don`t have enough balance!");
                    AdventureGame.game.accessShop();
                }
                else{
                    player.gold = player.getGold() - p;
                    if (grocery instanceof Weapons){
                        player.wp.add((Weapons) grocery);
                    }
                    else {
                        player.bag.add((Item) grocery);
                    }
                print("You have successfully purchased the item, you have " + player.gold + " remaining.");}
                AdventureGame.game.accessShop();
            }
        }



    }
    /**
     * Method for printing our text in the terminal
     * @author Enze Peng
     * @param s - String to be printed
     */
    public void print(String s){
        System.out.println(s);
    }

}


package game;

import gameobjects.*;

import java.util.Scanner;

public class ShopSystem {
    private Scanner scanner;
    Player player = Player.getInstance();
    public ShopSystem(){
        scanner = new Scanner(System.in);
    }
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
                    player.bag.add(grocery);
                print("You have successfully purchased the item, you have " + player.gold + " remaining.");}
                AdventureGame.game.accessShop();
            }
        }



    }
    public void print(String s){
        System.out.println(s);
    }

}

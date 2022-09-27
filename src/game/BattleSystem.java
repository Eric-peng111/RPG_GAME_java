package game;

import gameobjects.Enemy;
import gameobjects.Item;
import gameobjects.Player;
import globals.ItemType;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
/** Represents the fighting system in the game
 * @author Enze Peng
 */
public class BattleSystem implements java.io.Serializable{
    /** Represents the scanner to receive user input
     */
    private  Scanner scan;
    /**
     * Class Constructor for BattleSystem
     * @author EnzePeng
     */
    public BattleSystem(){
        scan=new Scanner(System.in);
    }
    /**
     * Method for fighting with an enemy
     * @author Enze Peng
     * @param e - Enemy to be fought with
     * @param player - Player representing current player
     */
    public void battle(Enemy e, Player player) {
        int input,i=1;
        Boolean v=false;
        int buff=0;
        print(e.getDescription());
        while(true){
            print("enemy hp -> "+e.hp );
            print("your hp -> "+player.hp );//+"\nyour attacking value -> "+player.attack
            print("--------------"+"\nchoose action:"+"\n(1) Fight\n(2) use items \n(3) Run away\n\nplease enter a number");

            input = readChoice(3);
            int et=0;int pt=0;int play_attack=0;
            if(input == 1){
                play_attack=fight(player)+buff;
                buff=0;//clear last round buff
            }
            else if(input ==2){
                Item temp= getItems(player);
                temp.useItem();
            }
            else if(input==3){
                print("You are in the " + player.getLocation().describe());
                break;
            }

            et=e.hp-play_attack;
            pt=player.hp-e.attack();

            print("\n\n----------Battle round "+i+"--------------\nYou caused "+(e.hp-et)+ " damage to the "+e.getName());
            print(e.getName()+" caused "+(player.hp-pt)+" damage to you\n\n\n");

            if(pt<=0 && et>0){
                player.hp=0;
            }
            if(et<=0){
                print("you have defeated the enemy "+e.getName());
                player.xp=++e.expReward;
                print("you have got new XP from enemy for "+e.expReward+ " points");
                player.gold=++e.goldReward;
                print("you have gained "+e.expReward+ " gold from this battle, you have "+player.gold+" gold now.");
                player.checkUpgrade();

                break;
            }
            i++;
            e.hp=et;player.hp=pt;
        }



    }
    /**
     * Method for choosing to fight in what way
     * @author Enze Peng
     * @param player - Player representing current player
     */
    public int fight(Player player){
        print("you have 2 options to fight:\n(1)with a weapon in your bag\n(2)with your hand");
        int input=(readChoice(2));
        if(input==1){
            print(player.wp.describeWeapons());
            print("which weapon u want to choose to fight with? Enter a num:");
            int input2=(readChoice(player.wp.size()));
            return player.w_attack(player.wp.get(input2-1));

        }else if(input==2){
            return player.attack();
        }

        return 0;

    }
    /**
     * Method choosing to use an item from the bag
     * @author Enze Peng
     * @param player - Player representing current player
     * @return - item to be used
     */
    public Item getItems(Player player){
        print("Here are items in your bag");
        print(player.bag.describeThings());
        print("\nwhich items u want to use in the fight? Enter a num");
        int input=(readChoice(player.bag.size()));
        return player.bag.get(input-1);
    }
    /**
     * Method for receiving user int put for fighting
     * @author Enze Peng
     * @param max - int for number of choices allowed
     * @return int acquired from user input
     */
    public  int readChoice(int max){
        int input;
        do{
            try{
                input=Integer.parseInt(scan.next());
            }catch (Exception e){
                input=-1;
                print("pls enter a valid number");
            }
            if(input>max || input<=0)
                print("u only have "+max+" choices");

        }while(input>max || input<=0);

        return input;

    }
    /**
     * Method for printing our text in the terminal
     * @author Enze Peng
     * @param s - String to be printed
     */
    public static void print(String s){
        System.out.println(s);
    }
}

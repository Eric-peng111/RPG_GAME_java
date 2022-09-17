package game;

import gameobjects.Enemy;
import gameobjects.Player;

import java.util.Scanner;

public class BattleSystem implements java.io.Serializable{


    private  Scanner scan;

    public BattleSystem(){
        scan=new Scanner(System.in);
    }

    public Player battle(Enemy e, Player player) {
        int input,i=1;
        Boolean v=false;
        print(e.getDescription());
        while(true){
            print("enemy hp -> "+e.hp +"\nenemy attacking value -> "+e.attack);
            print("your hp -> "+player.hp +"\nyour attacking value -> "+player.attack);
            print("--------------"+"\nchoose action:"+"\n(1) Fight\n(2) use items \n(3) Run away\n\nplease enter a number");

            input = readChoice(3);
            if(input == 1){
                int et=e.hp-player.attack();
                int pt=player.hp-e.attack();

                print("\n\n----------Battle round "+i+"--------------\nYou caused "+(e.hp-et)+ " damage to the "+e.getName());
                print(e.getName()+" caused "+(player.hp-pt)+" damage to you\n\n\n");

                if(pt<=0 && et>0){
                    player.hp=0;
                }
                if(et<=0){
                    et=0;
                    v=true;
                    print("you have defeated the enemy "+e.getName());
                    player.xp=++e.expReward;
                    print("you have got new XP from enemy for "+e.expReward+ " points");
                    break;
                }
                i++;
                e.hp=et;player.hp=pt;

            }


        }
        return player;


    }

    public  int readChoice(int max){
        int input;
        do{
            try{
                input=Integer.parseInt(scan.next());
            }catch (Exception e){
                input=-1;
                print("pls enter the right num for choice");
            }
        }while (input<0 || input>max);

        return input;

    }

    public static void print(String s){
        System.out.println(s);
    }
}

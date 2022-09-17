package gameobjects;

import java.util.ArrayList;

public class Player extends Actor{


    private static Player single_instance = null;
    public int maxHp, hp, attack, level,xp,gold;
    private ArrayList<Thing> bag;
    private Player(String aName, String aDescription, Room aRoom,int maxHp, int attack, int xp, int gold, int level) {
        super(aName, aDescription, aRoom);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
        this.bag = new ArrayList<Thing>();
    }

    public static Player getInstance()
    {
        Room startRoom = new Room("town", "you have returned to town", 1, 2, 3, 4);
        if (single_instance == null)
            single_instance = new Player("player","player in the game", startRoom,2000, 300, 200, 0, 1);

        return single_instance;
    }


    public int attack(){
        return (int) (Math.random()*xp/4+this.level*this.attack);
    }


    public int levelUp(){
        if(this.level<10){
            this.level++;
            return this.level;
        }
        else
            return -1;
    }

    public void setHP(int i){
        this.hp=this.hp-i;
    }

}

package gameobjects;

import globals.Direction;

import java.util.ArrayList;
import java.util.Dictionary;

public class Player extends Actor{


    private static Player single_instance = null;
    public int maxHp, hp, attack, level,xp,gold;
    public ArrayList<Weapons> wp;
    public ThingContainer bag;
    private Player(String aName, String aDescription, Room aRoom,int maxHp, int attack, int xp, int gold, int level, Weapons weapon) {
        super(aName, aDescription, aRoom);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
        this.bag = new ThingContainer();
        this.wp=new ArrayList<>();
        wp.add(weapon);
    }
    public Weapons getWp(int i) {
        return wp.get(i);
    }

    public void setWp(Weapons weapon) {
        wp.add(weapon);
    }

    public static Player getInstance()
    {
        Weapons sword = new Weapons("Iron Sword", "A trusty sword", 100);
        Room startRoom = new Room("town", "you have returned to town", 1, 2, 3, 4, 5, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT);
        if (single_instance == null)
            single_instance = new Player("player","player in the game", startRoom,1100, 300 + sword.getDmg() , 200, 0, 1, sword);

        return single_instance;
    }

    public int attack(){
        return (int) (Math.random()*xp/4+this.level*this.attack);
    }

    public int w_attack(Weapons w){return (int) (Math.random()*xp/4);}

    public void showBags(){
        System.out.println(bag);
    }

    public void showWeapons(){
        for(int i=0;i<wp.size();i++){
            System.out.println((i+1)+" "+wp.get(i));
        }
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

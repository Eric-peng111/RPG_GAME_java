package gameobjects;

import globals.Direction;

import java.util.ArrayList;
import java.util.Dictionary;

public class Player extends Actor{


    private static Player single_instance = null;
    private int maxHp, hp, attack, level,xp,gold;
    private Weapons weapon;
    private ArrayList<Thing> bag;
    private Player(String aName, String aDescription, Room aRoom,int maxHp, int attack, int xp, int gold, int level, Weapons weapon) {
        super(aName, aDescription, aRoom);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
        this.weapon = weapon;
        this.bag = new ArrayList<Thing>();
    }

    public static Player getInstance()
    {
        Weapons sword = new Weapons("Iron Sword", "A trusty sword", 100);
        Room startRoom = new Room("town", "you have returned to town", 1, 2, 3, 4, 5, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT);
        if (single_instance == null)
            single_instance = new Player("player","player in the game", startRoom,1100, 300 + sword.getDmg(), 200, 0, 1, sword);

        return single_instance;
    }
}

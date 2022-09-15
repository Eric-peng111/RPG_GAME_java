package gameobjects;

import globals.Direction;

import java.util.ArrayList;
import java.util.Dictionary;

public class Player extends Actor{


    private static Player single_instance = null;
    private int maxHp, hp, attack, level,xp,gold;
    private String weapon;
    private ArrayList<Thing> bag;
    private Player(String aName, String aDescription, Room aRoom,int maxHp, int attack, int xp, int gold, int level, String weapon) {
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
        Room startRoom = new Room("town", "you have returned to town", 1, 2, 3, 4, 5, Direction.NOEXIT);
        if (single_instance == null)
            single_instance = new Player("player","player in the game", startRoom,1100, 300, 200, 0, 1, "Iron Sword");

        return single_instance;
    }
}

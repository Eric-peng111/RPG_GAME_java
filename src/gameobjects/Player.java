package gameobjects;

public class Player extends Actor{

    private static Player single_instance = null;
    private int maxHp, hp, attack, defense, level,xp,gold;
    private Player(String aName, String aDescription, Room aRoom,int maxHp, int attack, int defense, int xp, int gold, int level) {
        super(aName, aDescription, aRoom);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
    }

    public static Player getInstance()
    {
        if (single_instance == null)
            single_instance = new Player("player","player in the game",null,1100, 300, 200, 0, 0,1);

        return single_instance;
    }
}

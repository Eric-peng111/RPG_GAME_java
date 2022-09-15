package gameobjects;

public class Enemy extends Actor{

    private int maxHp, hp, attack, level, goldReward, expReward;
    // The thing you get after you defeat the enemy
    Thing treasure;
    public Enemy(String aName, String aDescription, Room aRoom, int maxHp,
                 int attack, int level, int goldRwd, int expRwd, Thing drop) {
        super(aName, aDescription, aRoom);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.level = level;
        this.goldReward = goldRwd;
        this.expReward = expRwd;
        this.treasure = drop;

    }
}

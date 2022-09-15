package gameobjects;

public class Enemy extends Actor{

    private int maxHp, hp, attack, defense, level;
    public Enemy(String aName, String aDescription, Room aRoom) {
        super(aName, aDescription, aRoom);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
    }
}

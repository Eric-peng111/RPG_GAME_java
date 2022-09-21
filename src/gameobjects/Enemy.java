package gameobjects;

public class Enemy extends Actor{

    public static String[] enemies = {"Giant", "Goblin", "Wolf", "vampire", "Snake"};

    public int maxHp, hp, attack, level, goldReward, expReward;
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
    public Enemy(int i,int level,int playHP){

        super(enemies[i], "The "+enemies[i]+" is coming", null);
        this.attack=200*level/2;
        this.maxHp=3*playHP/2;
        this.hp =3*playHP/2;
        this.expReward=10;

    }

    public int attack(){
        return (int) (Math.random()*10+this.attack);
    }

    public void setHP(int i){
        this.hp=this.hp-i;
    }
}

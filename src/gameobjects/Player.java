package gameobjects;

import globals.Direction;

import java.util.ArrayList;
import java.util.Dictionary;

public class Player extends Actor{


    private static Player single_instance = null;
    public int maxHp, hp, attack, level,xp,gold;
    public WeaponContainer wp;
    public ItemContainer bag;
    private Player(String aName, String aDescription, Room aRoom,int maxHp, int attack, int xp, int gold, int level, Weapons weapon) {
        super(aName, aDescription, aRoom);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
        this.bag = new ItemContainer();
        this.wp=new WeaponContainer();
        wp.add(weapon);
    }
    public Weapons getWp(int i) {
        return wp.get(i);
    }
    public ItemContainer getThings(){
        return this.bag;
    }
    public int getGold(){
        return this.gold;
    }


    public static Player getInstance()
    {
        Weapons sword = new Weapons("self dagger", "one dagger one hero", 100, 250);
        Room startRoom = new Room("town", "you have returned to town", 1, 2, 3, 4, 5, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT);
        if (single_instance == null)
            single_instance = new Player("player","player in the game", startRoom,1100, 200 , 200, 1000, 1, sword);

        return single_instance;
    }

    public int attack(){
        return (int) (Math.random()*xp/4+this.level*this.attack);
    }

    public int w_attack(Weapons w){return (int) (Math.random()*xp/4+w.getDmg()*level);}

    public void showBags(){
        System.out.println(bag);
    }

    public void showWeapons(){
        for(int i=0;i<wp.size();i++){
            System.out.println((i+1)+" "+wp.get(i));
        }
    }

    public void addToBags(Item t){
        bag.add(t);
    }
    public void addWeapons(Weapons w){
        wp.add(w);
    }
    public void dropFromBags(Thing t){
        bag.remove(t);
    }
    public void dropWeapons(Weapons w){
        wp.remove(w);
    }
    public String use(Thing t){
        for (Thing x : bag){
            if (t.getName().equals(x.getName())){
                if (x instanceof Weapons){
                    attack = ((Weapons) x).getDmg();
                    return "You have equipped this weapon.";
                }
                else if (x instanceof Item) {
                    return ((Item) x).useItem();
                }
            }
        }
        return "item not found.";
    }

    public int extract_W(Weapons w,int i){
       if(i!=1){
          this.getLocation().getThings().add(w);
          this.dropWeapons(w);
          return i;
       }

        for(Grocery g:getLocation().getThings()){
            if(w.getName().equals(g.getName()))
            {
                this.getLocation().getThings().remove(g);
                this.addWeapons(w);
                break;
            }

        }
        return i;

    }

    public int extract_I(Item i,int t){
       if(t!=1){
           this.getLocation().getThings().add(i);
           this.dropFromBags(i);
           return t;
       }
        for(Grocery g:getLocation().getThings()){
            if(i.getName().equals(g.getName()))
            {
                this.getLocation().getThings().remove(i);
                this.addToBags(i);
                break;
            }

        }
        return t;

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

    public String profile(){
        String s="";
        s=s+"Name: "+this.getName()+"\nMax fight health: "+maxHp+"\nAttacking: "
                +attack+"\nLevel: "+level+"\nExperience point: "+xp+"\nGold:"+gold;
        return s;
    }


}

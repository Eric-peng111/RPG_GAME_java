package gameobjects;

import globals.ItemType;

public class Item extends Grocery{
    public int stat;
    public ItemType type;
    public Item(String aName, String aDescription, int pc, int st, ItemType t) {
        super(aName, aDescription, pc);
        stat = st;
        type = t;
    }
    public String useItem(){
        Player player = Player.getInstance();
        ItemType tp = type;
        int value = stat;
        switch(tp) {
            case BUFF:
                player.attack = ++value;
            case HEAL:
                if (player.hp + value <= player.maxHp)
                player.hp = ++value;
                else {
                    player.hp = player.maxHp;
                }
        }
        return "You have successfully used this item!";
    }




}

package test.java.function;

import gameobjects.Item;
import globals.ItemType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    Item grass = new Item("grass","Rough drug",50,30, ItemType.HEAL);
    Item drug = new Item("drug","drug get u excited",50,30, ItemType.BUFF);

    @Test
    public void getPrice(){
        assertEquals(50,grass.getPrice());
    }
    @Test
    public void stat(){
        assertEquals(30,grass.stat);
    }
    @Test
    public void ItemType(){
        assertEquals(ItemType.HEAL,grass.type);
        assertEquals(ItemType.BUFF,drug.type);
    }
}

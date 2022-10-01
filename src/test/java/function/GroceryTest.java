package function;

import gameobjects.Grocery;

import gameobjects.Item;
import globals.ItemType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroceryTest {
    Grocery chain = new Grocery("chain","A golden chain",1000);


    @Test
    public void getPrice(){
        assertEquals(1000,chain.getPrice());
    }
}


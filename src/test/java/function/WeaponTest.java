package test.java.function;

import gameobjects.Weapons;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeaponTest {

    Weapons blade = new Weapons("blade","a broken blade",25,50);
    Weapons shield_bow = new Weapons("shield bow","a shield bow",300,300);



    @Test
    public void getName(){
        assertEquals("blade", blade.getName());
        assertEquals("shield bow", shield_bow.getName());
    }
    @Test
    public void getDescription(){
        assertEquals("a broken blade", blade.getDescription());
        assertEquals("a shield bow", shield_bow.getDescription());
    }
    @Test
    public void getPrice(){
        assertEquals(25, blade.getPrice());
        assertEquals(300, shield_bow.getPrice());
    }
    @Test
    public void getDmg(){
        assertEquals(50, blade.getDmg());
        assertEquals(300, shield_bow.getDmg());
    }
}

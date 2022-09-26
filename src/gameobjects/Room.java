package gameobjects;

import java.util.ArrayList;
import java.util.Arrays;

public class Room extends Thing {

    private int n, s, w, e, d, t, i, o;
    private GroceryContainer gc;

    public Room(String aName, String aDescription, int aN, int aS, int aW, int aE, int aD, int aT, int aI, int aO) {
        super(aName, aDescription); // init superclass
        n = aN;
        s = aS;
        w = aW;
        e = aE;
        d = aD;
        t = aT;
        i = aI;
        o = aO;
        this.gc=new GroceryContainer();

    }

    // --- accessor methods ---
    // n
    public int getN() {
        return n;
    }


    // s
    public int getS() {
        return s;
    }

    public void setS(int aS) {
        s = aS;
    }

    // e
    public int getE() {
        return e;
    }

    // w
    public int getW() {
        return w;
    }


    // d
    public int getD() {
        return d;
    }


    // t
    public int getT() {
        return t;
    }

    // i
    public int getI() {
        return i;
    }

    // t
    public int getO() {
        return o;
    }


    public void randomInit(ItemContainer IC,WeaponContainer WC){
        this.gc.clear();
        int i=(int)(Math.random()*IC.size());
        int w=(int)(Math.random()*WC.size());
        ItemContainer ic=(ItemContainer) IC.clone();
        WeaponContainer wc=(WeaponContainer) WC.clone();
        for(int j=0;j<i;j++){
            int t=(int)Math.random()*ic.size();
            this.gc.add(ic.get(t));
            ic.remove(t);
        }

        for(int j=0;j<w;j++){
            int t=(int)Math.random()*wc.size();
            this.gc.add(wc.get(t));
            wc.remove(t);
        }
    }


    public GroceryContainer getThings(){
        return this.gc;
    }



    public String describe() {
        String roomdesc;
        String thingsdesc;

        roomdesc = String.format("%s. %s.", getName(), getDescription());
        thingsdesc = getThings().describeThings();
        if (!thingsdesc.isEmpty()) {
            roomdesc += "\nThings here:\n" + thingsdesc;
        }
        return roomdesc+"\n\nif u wanna go deeper to find more adventures，type fight";
    }

    public GroceryContainer merge(WeaponContainer wc,ItemContainer ic){
        GroceryContainer gr=new GroceryContainer();
        for(Grocery g:ic){
            gr.add(g);
        }
        for(Grocery g:wc){
            gr.add(g);
        }
        return  gr;
    }



}

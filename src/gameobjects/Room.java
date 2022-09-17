package gameobjects;

import java.util.ArrayList;
import java.util.Arrays;

public class Room extends Thing {

    private int n, s, w, e, d, t, i, o;
    private ThingContainer tc;

    private ArrayList<String> random_thing;

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
        random_thing=new ArrayList<>(Arrays.asList("sword", "ring", "Wombat", "shield", "potion"));
        this.tc=new ThingContainer();
        randomInit();

    }

    // --- accessor methods ---
    // n
    public int getN() {
        return n;
    }

    public void setN(int aN) {
        n = aN;
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

    public void setE(int aE) {
        e = aE;
    }

    // w
    public int getW() {
        return w;
    }

    void setW(int aW) {
        w = aW;
    }

    // d
    public int getD() {
        return d;
    }

    void setD(int aD) {
        d = aD;
    }

    // t
    public int getT() {
        return t;
    }

    void setT(int aT) {
        t = aT;
    }
    // i
    public int getI() {
        return i;
    }

    void setI(int aI) {
        i = aI;
    }
    // t
    public int getO() {
        return o;
    }

    void setO(int aO) {
        t = aO;
    }

    public void randomInit(){
        int i=(int)(Math.random()*random_thing.size());
        for(int j=0;j<i;j++){
            int t=(int)Math.random()*random_thing.size();
            this.tc.add(new Thing(random_thing.get(t),"this is a thing to get"));
            random_thing.remove(t);
        }
    }

    public ThingContainer setupThings(Thing t){
        tc.add(t);
        return tc;
    }

    public ThingContainer getThings(){
        return this.tc;
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



}

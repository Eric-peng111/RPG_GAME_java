/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */

package gameobjects;

public class Room extends Thing {

    private int n, s, w, e, d, t, i, o;

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



}

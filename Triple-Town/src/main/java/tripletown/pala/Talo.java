
package tripletown.pala;

/**
 * Luokka, jolla luodaan Talo-olioita
 */
public class Talo implements Pala {

    private int x;
    private int y;
    
    public Talo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getPisteet() {
        return 1500;
    }
    
    public String toString() {
        return "4";
    }
}

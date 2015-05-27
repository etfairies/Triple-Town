package tripletown.pala;

/**
 * Luokka, jolla luodaan Linna-olioita
 */
public class Linna implements Pala {

    private int x;
    private int y;

    public Linna(int x, int y) {
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
        return 20000;
    }
    
    @Override
    public String toString() {
        return "6";
    }
}

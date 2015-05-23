package tripletown.pala;

public class Puu implements Pala {

    private int x;
    private int y;
    private final int pisteet = 100;

    public Puu(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public int getPisteet() {
        return this.pisteet;
    }

    @Override
    public String toString() {
        return "3";
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

}

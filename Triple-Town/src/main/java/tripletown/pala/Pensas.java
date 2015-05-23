package tripletown.pala;

public class Pensas implements Pala {

    private int x;
    private int y;
    private final int pisteet = 20;

    public Pensas(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int getPisteet() {
        return this.pisteet;
    }
    
    @Override
    public String toString() {
        return "2";
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

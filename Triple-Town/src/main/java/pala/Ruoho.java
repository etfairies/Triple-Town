package pala;

public class Ruoho implements Pala {

    private int x;
    private int y;
    private final int pisteet = 5;

    public Ruoho(int x, int y) {
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
        return this.pisteet;
    }

    @Override
    public String toString() {
        return "R";
    }

    
}

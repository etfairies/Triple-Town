package pala;

public class Ruoho implements Pala {

    private int x;
    private int y;

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
    public String toString() {
        return "R";
    }
}

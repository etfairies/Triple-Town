package tripletown.pala;

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
    public int getPisteet() {
        return 5;
    }

    @Override
    public String toString() {
        return "1";
    }

}

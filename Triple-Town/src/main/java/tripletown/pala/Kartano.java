
package tripletown.pala;


public class Kartano implements Pala {
    private int x;
    private int y;
    
    public Kartano(int x, int y) {
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
        return 5000;
    }
    
    @Override
    public String toString() {
        return "5";
    }
}

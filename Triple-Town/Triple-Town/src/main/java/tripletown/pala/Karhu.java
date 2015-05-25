
package tripletown.pala;


public class Karhu implements Pala {

    private int x;
    private int y;
    
    public Karhu(int x, int y) {
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
    
    public void liiku(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getPisteet() {
        return 0;
    }
    
    @Override
    public String toString() {
        return "K";
    }
    
}

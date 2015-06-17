package tripletown.pala;

/**
 * Kaikkien Pala-olioiden yliluokka, jonka avulla luodaan muut Pala-oliot
 */
public class Pala {

    private int x;
    private int y;

    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
       return this.x;
    }

    public int getY() {
       return this.y;
    }
    
    public void liiku(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getPisteet() {
        return 0;
    }
    
    public int getId() {
        return 1;
    }

}


package tripletown.pala;

/**
 * Luokka, jolla luodaan Karhu-olioita ja hallitaan niiden sijaintia 
 */
public class Karhu extends Pala {

    private int x;
    private int y;
    
    public Karhu(int x, int y) {
       super(x, y);
    }

    @Override
    public int getId() {
        return 0;
    }
    
}

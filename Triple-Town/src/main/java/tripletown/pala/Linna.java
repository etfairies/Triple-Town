package tripletown.pala;

/**
 * Luokka, jolla luodaan Linna-olioita
 */
public class Linna extends Pala {

    public Linna(int x, int y) {
       super(x, y);
    }

    public int getPisteet() {
        return 20000;
    }
    
    @Override
    public String toString() {
        return "6";
    }
}

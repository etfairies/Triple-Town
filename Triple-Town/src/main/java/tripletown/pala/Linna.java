package tripletown.pala;

/**
 * Luokka, jolla luodaan Linna-olioita
 */
public class Linna extends Pala {

    public Linna(int x, int y) {
       super(x, y);
    }

    @Override
    public int getPisteet() {
        return 20000;
    }
 
    @Override
    public int getId() {
        return 6;
    }
}

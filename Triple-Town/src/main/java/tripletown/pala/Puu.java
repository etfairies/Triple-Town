package tripletown.pala;

/**
 * Luokka, jolla luodaan Puu-olioita
 */
public class Puu extends Pala {

    public Puu(int x, int y) {
        super(x, y);
    }

    public int getPisteet() {
        return 100;
    }

    @Override
    public String toString() {
        return "3";
    }

}

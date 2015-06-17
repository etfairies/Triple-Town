package tripletown.pala;

/**
 * Luokka, jolla luodaan Talo-olioita
 */
public class Talo extends Pala {

    public Talo(int x, int y) {
        super(x, y);
    }

    @Override
    public int getPisteet() {
        return 1500;
    }

    @Override
    public int getId() {
        return 4;
    }
}

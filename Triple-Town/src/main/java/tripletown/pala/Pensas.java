package tripletown.pala;

/**
 * Luokka, jolla luodaan Pensas-olioita
 */
public class Pensas extends Pala {

    public Pensas(int x, int y) {
        super(x, y);
    }

    public int getPisteet() {
        return 20;
    }

    @Override
    public String toString() {
        return "2";
    }

}

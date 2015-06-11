package tripletown.pala;

/**
 * Luokka, jolla luodaan Pensas-olioita
 */
public class Pensas extends Pala {

    public Pensas(int x, int y) {
        super(x, y);
    }

    @Override
    public int getPisteet() {
        return 20;
    }
    
    @Override
    public int getId() {
        return 2;
    }

}

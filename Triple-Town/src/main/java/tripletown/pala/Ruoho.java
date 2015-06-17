package tripletown.pala;

/**
 * Luokka, jolla luodaan Ruoho-olioita
 */
public class Ruoho extends Pala {

    public Ruoho(int x, int y) {
        super(x, y);
    }

    @Override
    public int getPisteet() {
        return 5;
    }

}

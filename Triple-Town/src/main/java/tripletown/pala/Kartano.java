
package tripletown.pala;

/**
 * Luokka, jolla luodaan Kartano-olioita
 */
public class Kartano extends Pala {

    public Kartano(int x, int y) {
       super(x, y);
    }

    @Override
    public int getPisteet() {
        return 5000;
    }
    
    @Override
    public int getId() {
        return 5;
    }
}

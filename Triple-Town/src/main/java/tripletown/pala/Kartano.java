
package tripletown.pala;

/**
 * Luokka, jolla luodaan Kartano-olioita
 */
public class Kartano extends Pala {

    public Kartano(int x, int y) {
       super(x, y);
    }

    public int getPisteet() {
        return 5000;
    }
    
    @Override
    public String toString() {
        return "5";
    }
}


package tripletown.pala;

import java.awt.font.TextAttribute;

/**
 * Luokka, jolla luodaan Talo-olioita
 */
public class Talo extends Pala {

    public Talo(int x, int y) {
        super(x, y);
    }

    public int getPisteet() {
        return 1500;
    }
    
    public String toString() {
        return "4";
    }
}

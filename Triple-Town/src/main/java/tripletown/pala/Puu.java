
package tripletown.pala;

public class Puu implements Pala {

    private final int pisteet = 100;
    
    @Override
    public int getPisteet() {
        return this.pisteet;
    }
    
    @Override
    public String toString() {
        return "U";
    }
    
    
}

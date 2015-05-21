package tripletown.pala;

public class Pensas implements Pala {

    private final int pisteet = 20;


    @Override
    public int getPisteet() {
        return this.pisteet;
    }
    
    @Override
    public String toString() {
        return "P";
    }

}

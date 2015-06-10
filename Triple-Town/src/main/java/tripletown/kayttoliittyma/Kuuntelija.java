package tripletown.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tripletown.pala.Pala;
import tripletown.sovellus.Peli;

/**
 * Luokka hoitaa peliruudussa tapahtuvat klikkaukset.
 * 
 */
public class Kuuntelija implements ActionListener {

    private final Peli peli;
    private final Kayttoliittyma gui;
    private final int x;
    private final int y;
    

    public Kuuntelija(Peli peli, Kayttoliittyma gui, int x, int y) {
        this.peli = peli;
        this.gui = gui;
        this.x = x;
        this.y = y;
    }

    
    /**
     * Metodi hoitaa palan asettamisen tyhjään ruutuun.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
         if (peli.getRuutu(x, y) == null) {
            Pala asetettu =  peli.asetaPala(gui.getArvottuPala(), x, y);
            peli.vierekkaistenPalojenHaku(asetettu);
            gui.paivita();
        } 
    }

}

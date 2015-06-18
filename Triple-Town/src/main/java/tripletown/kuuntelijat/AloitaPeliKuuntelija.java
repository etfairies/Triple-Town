
package tripletown.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tripletown.kayttoliittyma.Kayttoliittyma;

/**
 * Luokka kuuntelee aloitusruudun nappia 'Pelaa'.
 */
public class AloitaPeliKuuntelija implements ActionListener {

    private final Kayttoliittyma kl;
 
    public AloitaPeliKuuntelija(Kayttoliittyma kl) {
        this.kl = kl;
    }

    /**
     * Metodi kutsuu Käyttöliittymä-luokan metodia, joka luo peliruudukon graafisen ulkoasun.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        kl.aloitaPeli();
    }
    
}

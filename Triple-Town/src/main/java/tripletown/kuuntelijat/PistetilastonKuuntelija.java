
package tripletown.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tripletown.kayttoliittyma.Kayttoliittyma;

/**
 * Luokka kuuntelee aloitusruudun nappia 'Pistetilasto'.
 */
public class PistetilastonKuuntelija implements ActionListener {
private Kayttoliittyma kl;
    public PistetilastonKuuntelija(Kayttoliittyma kl) {
        this.kl = kl;
    }
    /**
     * Metodi
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
       kl.luoPistetilastoruutu();
    }
    
}

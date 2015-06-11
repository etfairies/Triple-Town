
package tripletown.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tripletown.kayttoliittyma.Kayttoliittyma;


public class AloitaPeliKuuntelija implements ActionListener {

    private final Kayttoliittyma kl;
    
    public AloitaPeliKuuntelija(Kayttoliittyma kl) {
        this.kl = kl;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        kl.aloitaPeli();
    }
    
}

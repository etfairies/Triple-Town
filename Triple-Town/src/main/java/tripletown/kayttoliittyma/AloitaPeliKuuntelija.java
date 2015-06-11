
package tripletown.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class AloitaPeliKuuntelija implements ActionListener {

    private Kayttoliittyma kl;
    
    public AloitaPeliKuuntelija(Kayttoliittyma kl) {
        this.kl = kl;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        kl.aloitaPeli();
    }
    
}

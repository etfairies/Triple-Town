
package tripletown.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka kuuntelee aloitus- ja peliruudun nappia 'Lopeta'.
 */

public class LopetaPeliKuuntelija implements ActionListener {

    /**
     * Metodi sulkee sovelluksen.
     * @param ae 
     */

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
    
}

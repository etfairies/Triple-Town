package tripletown.kayttoliittyma;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws Exception {

//        Tekstikayttoliittyma tekstikayttoliittyma = new Tekstikayttoliittyma();
//        tekstikayttoliittyma.kaynnista();

      Kayttoliittyma gui = new Kayttoliittyma();
      SwingUtilities.invokeLater(gui);
        
    }

}

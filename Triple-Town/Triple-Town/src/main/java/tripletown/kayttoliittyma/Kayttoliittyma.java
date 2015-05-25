package tripletown.kayttoliittyma;

import javax.swing.JFrame;
import javax.swing.JPanel;
import tripletown.sovellus.Peli;

public class Kayttoliittyma extends JFrame {

    Peli peli;
    private final String[] palat = {"", "ruoho", "pensas", "puu", "talo", "kartano", "linna"};
    private JPanel pelilauta;

    public Kayttoliittyma() {
        this.peli = new Peli();

    }
}

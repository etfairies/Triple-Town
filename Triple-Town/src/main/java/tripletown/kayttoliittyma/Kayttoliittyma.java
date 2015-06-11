package tripletown.kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import tripletown.sovellus.Peli;
import tripletown.sovellus.Pistetilasto;

public class Kayttoliittyma implements Runnable {

    JFrame frame;
    private final Peli peli;
    private final int leveys = 6;
    private final int korkeus = 6;
    private final JButton[][] ruudut;
    private int arvottuPala;
    private Pistetilasto tilasto;
    private final String[] kuvat = {
        "src/main/java/tripletown/kayttoliittyma/kuvat/karhu.png", 
        "src/main/java/tripletown/kayttoliittyma/kuvat/ruoho.png", 
        "src/main/java/tripletown/kayttoliittyma/kuvat/pensas.png", 
        "src/main/java/tripletown/kayttoliittyma/kuvat/puu.png", 
        "src/main/java/tripletown/kayttoliittyma/kuvat/talo.png", 
        "src/main/java/tripletown/kayttoliittyma/kuvat/kartano.png", 
        "src/main/java/tripletown/kayttoliittyma/kuvat/linna.png"};

    /**
     * Luokka luo pelin graafisen käyttöliittymän.
     */
    public Kayttoliittyma() {
        peli = new Peli(leveys, korkeus);
        ruudut = new JButton[leveys][korkeus];
        tilasto = new Pistetilasto();
    }

    @Override
    public void run() {
        frame = new JFrame("Triple Town");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(leveys, korkeus));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();

        lisaaRuudukko();
        frame.setVisible(true);

        peli.alustaPelilauta();
        paivita();

    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Metodi luo peliruudut ja lisää ne frameen.
     */
    private void lisaaRuudukko() {

        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {

                JButton ruutu = new JButton();

                ruutu.addActionListener(new Kuuntelija(peli, this, x, y));
                ruutu.setBackground(Color.green);
                ruudut[x][y] = ruutu;

                frame.add(ruutu);
            }
        }
    }

    /**
     * Metodi päivittää pelilaudan ajan tasalle.
     *
     */
    public void paivita() {

        peli.liikutaKarhua();

        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {

                asetaRuudunSisalto(x, y);
            }
        }

        if (peli.pelilautaTaynna()) {
            tallennaPisteet();

        } else {
            this.arvottuPala = peli.arvoPala();
            System.out.print(arvottuPala);
        }
    }

    /**
     * Metodi tulostaa ruutuun sen sisällön.
     *
     * @param x Ruudun x-koordinaatti
     * @param y Ruudun y-koordinaatti
     */
    private void asetaRuudunSisalto(int x, int y) {

        if (peli.getRuutu(x, y) != null) {
            int palanumero = peli.getRuutu(x, y).getId();
            
                ruudut[x][y].setIcon(new ImageIcon(kuvat[palanumero]));
            }
        else {
            ruudut[x][y].setIcon(null);
        }

    }

    /**
     * Metodi palauttaa Palan, joka on sillä hetkellä asetettavana.
     *
     * @return Palauttaa asetettavan Palan palanumeron.
     */
    public int getArvottuPala() {
        return this.arvottuPala;
    }

    /**
     * Metodi hakee pelin lopussa kertyneet pisteet ja lähettää käskyn tallettaa
     * pisteet.
     */
    private void tallennaPisteet() {
        tilasto = new Pistetilasto();
        tilasto.tallennaPisteet(peli.pistetilanne());
    }

}

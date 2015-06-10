package tripletown.kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
    private final Pistetilasto tilasto;

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

        lisaaKomponentit();
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
    private void lisaaKomponentit() {

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

        this.arvottuPala = peli.arvoPala();
        System.out.print(arvottuPala);

        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {

                asetaRuudunSisalto(x, y);
            }
        }

    }

    /**
     * Metodi tulostaa ruutuun sen sisällön.
     *
     * @param x Ruudun x-koordinaatti
     * @param y Ruudun y-koordinaatti
     */
    private void asetaRuudunSisalto(int x, int y) {
        String sisalto = "";

        if (peli.getRuutu(x, y) != null) {
            sisalto = peli.getRuutu(x, y).toString();
        }

        ruudut[x][y].setText(sisalto);
    }

    /**
     * Metodi palauttaa Kuuntelijalle Palan, joka on sillä hetkellä
     * asetettavana.
     *
     * @return palauttaa asetettavan Palan palanumeron.
     */
    public int getArvottuPala() {
        return this.arvottuPala;
    }

}

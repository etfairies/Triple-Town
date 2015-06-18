package tripletown.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tripletown.kuuntelijat.AloitaPeliKuuntelija;
import tripletown.kuuntelijat.LopetaPeliKuuntelija;
import tripletown.kuuntelijat.RuutuKuuntelija;
import tripletown.kuuntelijat.ValikkoKuuntelija;
import tripletown.sovellus.Peli;
import tripletown.sovellus.Pistetilasto;

/**
 * Luokka piirtää pelin graafisen käyttöliittymän sekä päivittää pelitilanteen.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private JPanel aloitusPaneeli;
    private JPanel pistePaneeli;
    private JPanel peliPaneeli;
    private JPanel peliruudunYlaPalkki;
    private JLabel loppuTeksti;
    private JLabel pisteet;
    private Peli peli;
    private final int leveys = 6;
    private final int korkeus = 6;
    private JButton[][] ruudut;
    private int arvottuPala;
    private final String[] kuvat = {
        "src/tiedostot/kuvat/karhu.png",
        "src/tiedostot/kuvat/ruoho.png",
        "src/tiedostot/kuvat/pensas.png",
        "src/tiedostot/kuvat/puu.png",
        "src/tiedostot/kuvat/talo.png",
        "src/tiedostot/kuvat/kartano.png",
        "src/tiedostot/kuvat/linna.png"};
    private final String[] palat = {"", "ruoho", "pensas", "puu", "talo", "kartano", "linna"};

    /**
     * Metodi luo sovelluksen kehyksen ja lisää siihen aloitusruudun.
     */
    @Override
    public void run() {
        luoIkkuna();

        luoAloitusRuutu();
        luoPistetilastoruutu();
    }

    public void luoIkkuna() {
        frame = new JFrame("Triple Town");
        frame.setPreferredSize(new Dimension(400, 420));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void luoAloitusRuutu() {
        aloitusPaneeli = new JPanel();
        frame.add(aloitusPaneeli, BorderLayout.NORTH);

        JButton pelaaNappi = new JButton("Pelaa");
        JButton lopetaNappi = new JButton("Lopeta");
        pelaaNappi.addActionListener(new AloitaPeliKuuntelija(this));
        lopetaNappi.addActionListener(new LopetaPeliKuuntelija());

        aloitusPaneeli.add(pelaaNappi);
        aloitusPaneeli.add(lopetaNappi);
    }

    public void luoPistetilastoruutu() {
        pistePaneeli = new JPanel(new GridLayout(11, 1));

        frame.add(pistePaneeli, BorderLayout.CENTER);

        Pistetilasto tilasto = new Pistetilasto();

        List<Integer> kaikkiPisteet = tilasto.lueTiedosto();
        JLabel p = new JLabel("Pistetilasto");
        pistePaneeli.add(p);

        for (int i = 0; i < kaikkiPisteet.size(); i++) {
            JLabel piste = new JLabel(i + 1 + ": " + kaikkiPisteet.get(i));
            pistePaneeli.add(piste);
        }
    }

    /**
     * Metodi luo peliruudun komponentit.
     */
    public void aloitaPeli() {
        peli = new Peli(leveys, korkeus);
        ruudut = new JButton[leveys][korkeus];
        frame.remove(aloitusPaneeli);
        luoPeliruudunYlaPalkki();
        luoRuudukko();

        frame.add(peliruudunYlaPalkki, BorderLayout.NORTH);
        frame.add(peliPaneeli);
        peli.alustaPelilauta();

        paivita();
    }

    /**
     * Metodi luo peliruudun yläpalkin, jossa näkyvät pisteet ja nappi, josta
     * palataan päävalikkoon.
     *
     */
    private void luoPeliruudunYlaPalkki() {
        peliruudunYlaPalkki = new JPanel();

        pisteet = new JLabel("Pisteet: " + peli.pistetilanne());
        loppuTeksti = new JLabel(" ");
        JButton valikkoNappi = new JButton("Päävalikko");
        valikkoNappi.addActionListener(new ValikkoKuuntelija(this));

        peliruudunYlaPalkki.add(pisteet);
        peliruudunYlaPalkki.add(loppuTeksti);
        peliruudunYlaPalkki.add(valikkoNappi);
    }

    /**
     * Metodi luo peliruudut ja lisää ne kehykseen.
     */
    private void luoRuudukko() {

        peliPaneeli = new JPanel(new GridLayout(leveys, korkeus));

        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {

                peliPaneeli.add(luoRuutu(x, y));
            }
        }
    }

    private JButton luoRuutu(int x, int y) {
        JButton ruutu = new JButton();

        ruutu.addMouseListener(new RuutuKuuntelija(peli, this, x, y));
        ruutu.setBackground(Color.green);
        ruudut[x][y] = ruutu;

        return ruutu;
    }

    /**
     * Metodi päivittää pelitilanteen ajan tasalle.
     *
     */
    public void paivita() {

        pisteet.setText("Pisteet: " + peli.pistetilanne());

        peli.liikutaKarhua();

        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {

                asetaRuudunSisalto(x, y);
            }
        }

        if (peli.pelilautaTaynna()) {
            tallennaPisteet();
            loppuTeksti.setText("Peli loppui!");
        }
        this.arvottuPala = peli.arvoPala();

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

        } else {
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
        Pistetilasto tilasto = new Pistetilasto();
        tilasto.tallennaPisteet(peli.pistetilanne());
    }

    /**
     * Metodi poistaa ikkunasta pelipaneelit ja luo aloitusruudun uudelleen.
     */
    public void palaaValikkoon() {
        frame.remove(peliruudunYlaPalkki);
        frame.remove(peliPaneeli);

        frame.add(aloitusPaneeli);
        luoPistetilastoruutu();

        frame.repaint();
    }

    public void lisaaRuutuunAsetettavanKuva(int x, int y) {

        int palanumero = arvottuPala;
        ImageIcon pala = new ImageIcon(kuvat[palanumero]);
        ruudut[x][y].setIcon(pala);

    }

    public void poistaRuudustaAsetettavanKuva(int x, int y) {
        ruudut[x][y].setIcon(null);
    }

}

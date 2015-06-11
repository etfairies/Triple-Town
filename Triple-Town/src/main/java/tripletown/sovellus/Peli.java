package tripletown.sovellus;

import java.util.ArrayList;
import java.util.Random;
import tripletown.pala.Karhu;
import tripletown.pala.Kartano;
import tripletown.pala.Linna;
import tripletown.pala.Pala;
import tripletown.pala.Pensas;
import tripletown.pala.Puu;
import tripletown.pala.Ruoho;
import tripletown.pala.Talo;

/**
 * Luokka hallinnoi pelilaudalla tapahtuvia muutoksia
 */
public class Peli {

    private final Pala[][] lauta;
    private final int leveys;
    private final int korkeus;
    private int pisteet;
    Random arpoja;
    Karhu karhu;

    /**
     * Luokan konstruktori, joka luo pelilaudan sekä alustaa pistemääräksi nolla ja luo Karhu-olion
     * 
     * @param leveys    Pelilaudan leveys
     * @param korkeus   Pelilaudan korkeus
     */
    public Peli(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.lauta = new Pala[leveys][korkeus];
        this.pisteet = 0;
        this.arpoja = new Random();
        this.karhu = new Karhu(3, 3);
    }

    /**
     * Metodi luo laudalle paloja ja karhun, kun peli aloitetaan
     */
    public void alustaPelilauta() {

        for (int i = 0; i < 15; i++) {
            int x = arpoja.nextInt(this.leveys);
            int y = arpoja.nextInt(this.korkeus);
            lauta[x][y] = luoPala(arvoPala(), x, y);
            vierekkaistenPalojenHaku(lauta[x][y]);
        }
        lauta[this.karhu.getX()][this.karhu.getY()] = karhu;
        this.pisteet = 0;
    }

    /**
     * Metodi arpoo asetettavan palan numeron. Suurin todennäköisyys
     * ruoholla(1), pienin talolla (4)
     *
     * @return Palauttaa numeron, jonka avulla voidaan luoda uusi Pala-olio
     */
    public int arvoPala() {
        double luku = arpoja.nextDouble();
        if (luku < 0.01) {
            return 4;
        }
        if (luku < 0.02) {
            return 3;
        }
        if (luku < 0.15) {
            return 2;
        }

        return 1;
    }
 

    /**
     * Metodi luo palaolion palanumeron perusteella.
     *
     * @param pala Palanumero, joka määrää mikä Pala palautetaan
     * @param x Luotavan palan x-koordinaatti
     * @param y Luotavan palan y-koordinaatti
     *
     * @return Palautetaan uusi Pala-olio
     */
    private Pala luoPala(int pala, int x, int y) {

        if (pala == 2) {
            return new Pensas(x, y);
        }

        if (pala == 3) {
            return new Puu(x, y);
        }

        if (pala == 4) {
            return new Talo(x, y);
        }

        if (pala == 5) {
            return new Kartano(x, y);
        }

        if (pala >= 6) {
            return new Linna(x, y);
        }

        return new Ruoho(x, y);
    }

    /**
     * Metodi asettaa palan pelilaudalle.
     *
     * @param palanumero Numero, jonka avulla luodaan tietyn tason Pala-olio
     * @param x Asetettavan palan x-koordinaatti
     * @param y Asetettavan palan y-koordinaatti
     *
     * @return Palauttaa luodun palan jos asettaminen onnistui, muuten palauttaa
     * null
     */
    public Pala asetaPala(int palanumero, int x, int y) {

        if (lauta[x][y] == null) {
            Pala pala = luoPala(palanumero, x, y);
            this.lauta[x][y] = pala;
            this.pisteet += pala.getPisteet();

            return pala;
        }
        return null;
    }

    /**
     * Metodi lisää vierekkäiset samanlaiset palat listaan ja kutsuu metodia
     * yhdistaPalat jos paloja on vähintään kolme. Listan ensimmäiseksi
     * asetetaan alkuperäinen pala, jonka vierusruutuja tarkistetaan. Jos
     * alkuperäisellä palalla on yksi vieruspala, tarkistetaan vierekkäisen
     * palan vierusruudut. Metodi suoritetaan 5 kertaa ketjureaktion varalta
     *
     * @param pala Pala, jonka vierekkäiset ruudut tarkistetaan
     */
    public void vierekkaistenPalojenHaku(Pala pala) {

        for (int i = 0; i < 5; i++) {

            Pala juuripala = lauta[pala.getX()][pala.getY()];

            ArrayList<Pala> naapurit = new ArrayList<>();
            naapurit.add(juuripala);

            tarkistaRuudut(naapurit, juuripala);

            if (naapurit.size() == 2) {
                tarkistaRuudut(naapurit, naapurit.get(1));
            }

            if (naapurit.size() >= 3) {
                yhdistaPalat(naapurit);
            }
        }
    }

    /**
     * Metodi tarkistaa palan vierekkäiset ruudut
     *
     * @param naapurit Lista vierekkäisistä paloista
     * @param juuripala Pala, jonka vierekkäiset ruudut tarkistetaan
     */
    private void tarkistaRuudut(ArrayList<Pala> naapurit, Pala juuripala) {
        tarkistaRuutu(naapurit, juuripala.getX() - 1, juuripala.getY(), juuripala.getClass());
        tarkistaRuutu(naapurit, juuripala.getX(), juuripala.getY() - 1, juuripala.getClass());
        tarkistaRuutu(naapurit, juuripala.getX() + 1, juuripala.getY(), juuripala.getClass());
        tarkistaRuutu(naapurit, juuripala.getX(), juuripala.getY() + 1, juuripala.getClass());
    }

    /**
     * Metodi tarkistaa onko tarkasteltavassa ruudussa samantasoinen pala.
     * Alkuperäistä palaa ei enää lisätä listaan.
     *
     * @param naapurit Lista vierekkäisistä paloista
     * @param x Tarkistettavan ruudun x-koordinaatti
     * @param y Tarkistettavan ruudun y-koordinaatti
     * @param palanLuokka Palan luokka. Jos tarkasteltavassa ruudussa olevan
     * palan luokka on sama kuin alkuperäisen palan luokka, pala lisätään
     * listaan
     */
    private void tarkistaRuutu(ArrayList<Pala> naapurit, int x, int y, Class palanLuokka) {
        if (x >= 0 && x < this.leveys && y >= 0 && y < this.korkeus) {
            
            if (lauta[x][y] != null && !naapurit.contains(lauta[x][y])) {
                if (lauta[x][y].getClass() == palanLuokka) {
                    naapurit.add(lauta[x][y]);
                }
            }
        }
    }

    /**
     * Metodi yhdistaa kolme samanlaista palaa uudeksi korkeamman tason palaksi.
     * Alkuperäisen palan palanumero + 1 luo korkeamman tason palan. Korkeimman
     * tason paloja, Linnoja, ei yhdistetä uudeksi palaksi.
     *
     * @param naapurit Lista vierekkäisistä paloista
     */
    private void yhdistaPalat(ArrayList<Pala> naapurit) {

        int uusiPala = naapurit.get(0).getId() + 1;
        int x = naapurit.get(0).getX();
        int y = naapurit.get(0).getY();

        if (uusiPala < 7) {
            poistaPalatLaudalta(naapurit);
            lauta[x][y] = asetaPala(uusiPala, x, y);
        }
    }

    /**
     * Metodi poistaa yhdistetyt palat pelilaudalta.
     *
     * @param naapurit Lista palan vieressä olevista paloista
     */
    private void poistaPalatLaudalta(ArrayList<Pala> naapurit) {
        for (Pala pala : naapurit) {
            lauta[pala.getX()][pala.getY()] = null;
        }
    }

    public int pistetilanne() {
        return this.pisteet;
    }

    public Pala getRuutu(int x, int y) {
        return lauta[x][y];
    }

    /**
     * Metodi arpoo suunnan, johon karhua liikutetaan
     */
    public void liikutaKarhua() {
        int ruutu = arpoja.nextInt(4);

        if (ruutu == 0) {
            liikutaKarhuRuutuun(this.karhu.getX() - 1, this.karhu.getY());

        } else if (ruutu == 1) {
            liikutaKarhuRuutuun(this.karhu.getX(), this.karhu.getY() - 1);

        } else if (ruutu == 2) {
            liikutaKarhuRuutuun(this.karhu.getX() + 1, this.karhu.getY());

        } else if (ruutu == 3) {
            liikutaKarhuRuutuun(this.karhu.getX(), this.karhu.getY() + 1);
        }
    }

    /**
     * Metodi siirtää karhun uuteen ruutuun ja muuttaa vanhan ruudun tyhjäksi.
     *
     * @param x Ruudun x-koordinaatti, johon Karhu siirretään
     * @param y Ruudun y-koordinaatti, johon Karhu siirretään
     */
    private void liikutaKarhuRuutuun(int x, int y) {
        if (x >= 0 && x < this.leveys && y >= 0 && y < this.korkeus) {
            if (lauta[x][y] == null) {
                lauta[this.karhu.getX()][this.karhu.getY()] = null;
                this.karhu.liiku(x, y);
                lauta[x][y] = this.karhu;
            }
        }
    }

    /**
     * Metodi tarkistaa, onko tyhjiä ruutuja vielä jäljellä.
     *
     * @return Jos joku ruutu on tyhjä, palautetaan false. Jos kaikki ruudut
     * ovat täynnä, palautetaan true.
     */
    public boolean pelilautaTaynna() {

        for (int y = 0; y < this.korkeus; y++) {
            for (int x = 0; x <this.leveys; x++) {
                if (this.lauta[x][y] == null) {
                    return false;
                }
            }
        }
        return true;
    }

}

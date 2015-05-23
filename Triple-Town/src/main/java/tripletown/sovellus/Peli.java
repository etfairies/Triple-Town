package tripletown.sovellus;

import java.util.ArrayList;
import java.util.Random;
import tripletown.pala.Pala;
import tripletown.pala.Pensas;
import tripletown.pala.Puu;
import tripletown.pala.Ruoho;

public class Peli {

    private final Pala[][] lauta = new Pala[6][6];
    private ArrayList<Pala> naapurit;
    private int pisteet;
    Random arpoja = new Random();

    public Peli() {
        this.pisteet = 0;
    }

    // Alustaa pelilaudan
    public void alustaPelilauta() {

        for (int i = 0; i < 2; i++) {
            int x = arpoja.nextInt(6);
            int y = arpoja.nextInt(6);
            lauta[x][y] = new Ruoho(x, y);
        }
    }

    // Arpoo asetettavan palan numeron
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

    // Palauttaa palaolion arvotun palanumeron perusteella
    public Pala luoPala(int pala, int x, int y) {
        if (pala == 1) {
            return new Ruoho(x, y);
        }
        if (pala == 2) {
            return new Pensas(x, y);
        }
        
        if (pala == 3) {
            return new Puu(x, y);
        }
        return new Ruoho(x, y);
    }

    // Asettaa palan pelilaudalle ja palauttaa luodun palan jos asettaminen onnistui, muuten palauttaa null
    public Pala asetaPala(int palanumero, int x, int y) {

        if (lauta[x][y] == null) {
            Pala pala = luoPala(palanumero, x, y);
            this.lauta[x][y] = pala;
            this.pisteet += pala.getPisteet();

            return pala;
        }
        return null;
    }


    // Hakee vierekkäiset samanlaiset palat ja tallettaa ne listaan
    public void vierekkaistenPalojenHaku(Pala juuripala) {
        naapurit = new ArrayList<>();
        naapurit.add(juuripala);

        tarkistaRuudut(naapurit, juuripala);

        if (naapurit.size() == 2) {
            tarkistaRuudut(naapurit, naapurit.get(1));
        }

        if (naapurit.size() >= 3) {
            yhdistaPalat(naapurit);
        }

    }

    // Tarkistaa onko vierekkäisissä ruuduissa samanlaista palaa
    public void tarkistaRuudut(ArrayList<Pala> naapurit, Pala juuripala) {
        tarkistaRuutu(naapurit, juuripala.getX() - 1, juuripala.getY(), juuripala.getClass());
        tarkistaRuutu(naapurit, juuripala.getX(), juuripala.getY() - 1, juuripala.getClass());
        tarkistaRuutu(naapurit, juuripala.getX() + 1, juuripala.getY(), juuripala.getClass());
        tarkistaRuutu(naapurit, juuripala.getX(), juuripala.getY() + 1, juuripala.getClass());
    }

   // Tarkistaa onko tarkasteltavassa ruudussa samanlainen pala
    public void tarkistaRuutu(ArrayList<Pala> naapurit, int x, int y, Class palanLuokka) {
        try {
            if (lauta[x][y] != null && !naapurit.contains(lauta[x][y])) {
                if (lauta[x][y].getClass() == palanLuokka) {
                    naapurit.add(lauta[x][y]);
                }
            }
        } catch (Exception e) {
        }
    }

    // Yhdistaa kolme samanlaista palaa uudeksi korkeamman tason palaksi
    public void yhdistaPalat(ArrayList<Pala> naapurit) {

        int uusiPala = Integer.parseInt(naapurit.get(0).toString()) + 1;
        int x = naapurit.get(0).getX();
        int y = naapurit.get(0).getY();

        poistaPalatLaudalta(naapurit);

        lauta[x][y] = asetaPala(uusiPala, x, y);
    }

    // Poistaa yhdistetyt palat pelilaudalta
    public void poistaPalatLaudalta(ArrayList<Pala> naapurit) {
        for (Pala pala : naapurit) {
            lauta[pala.getX()][pala.getY()] = null;
        }
    }

    public int pistetilanne() {
        return this.pisteet;
    }
    
    // Testejä varten
    public Pala getRuutu(int x, int y) {
        return lauta[x][y];
    }
    
    public Pala[][] getPelilauta() {
        return this.lauta;
    }
}

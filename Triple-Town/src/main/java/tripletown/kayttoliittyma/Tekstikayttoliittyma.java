package tripletown.kayttoliittyma;

import java.util.Scanner;
import tripletown.pala.Pala;
import tripletown.sovellus.Peli;

public class Tekstikayttoliittyma {

    Peli peli;
    private final Scanner lukija;
    private final String[] palat = {"", "ruoho", "pensas", "puu", "talo", "kartano", "linna"};

    public Tekstikayttoliittyma() {
        this.peli = new Peli();
        this.lukija = new Scanner(System.in);
    }

    public void kaynnista() {
        peli.alustaPelilauta();

        while (true) {

            peli.tulostaLauta();
            int pala = peli.arvoPala();
            
            while (true) {
                System.out.println("Mihin ruutuun haluat asettaa palan " + palat[pala] + "? Rivi:");
                int y = kysyKoordinaatti();
                System.out.println("Sarake:");
                int x = kysyKoordinaatti();

                if (this.peli.asetaPala(pala, x, y)) {
                    break;
                }
                System.out.println("Ruutu ei ollut tyhjä!");

            }
        }
    }

    //Varmistaa että pelaajan antama luku on 0:n ja 5:n väliltä
    public int kysyKoordinaatti() {
        int luku = -1;

        while (true) {

            try {
                luku = Integer.parseInt(lukija.nextLine());
            } catch (Exception e) {
            }

            if (luku >= 0 && luku <= 5) {
                return luku;
            }

            System.out.println("Anna luku väliltä 0-5");
        }
    }
}

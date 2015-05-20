package tripletown.sovellus;

import java.util.Random;
import java.util.Scanner;
import tripletown.kayttoliittyma.Pelilauta;
import tripletown.pala.Pala;
import tripletown.pala.Pensas;
import tripletown.pala.Ruoho;

public class Peli {

    private final Pelilauta lauta;
    private final Scanner lukija = new Scanner(System.in);
    Random arpoja = new Random();
    private final String[] palat = {"", "ruoho", "pensas", "puu", "talo", "kartano", "linna"};

    public Peli() {
        lauta = new Pelilauta();
    }

    // Alustaa pelilaudan
    public void aloita() {
        for (int i = 0; i < 2; i++) {

            int x = arpoja.nextInt(6);
            int y = arpoja.nextInt(6);
            this.lauta.asetaLaudalle(new Ruoho(x, y));
        }

        this.lauta.tulostaLauta();
        this.pelaa();
    }

    public void pelaa() {

        while (true) {
            int pala = arvoPala();
            asetaPala(pala);
        }
    }

    //Kysyy asetettavan palan sijainnin ja asettaa sen laudalle
    public void asetaPala(int pala) {

        while (true) {
            System.out.println("Mihin ruutuun haluat asettaa palan " + palat[pala] + "? Rivi:");
            int y = kysyKoordinaatti();
            System.out.println("Sarake:");
            int x = kysyKoordinaatti();

            if (this.lauta.tyhjaRuutu(x, y)) {
                this.lauta.asetaLaudalle(luoPala(pala, x, y));
                this.lauta.tulostaLauta();
                break;
            } else {
                System.out.println("Ruutu ei ollut tyhjä!");
            }
        }
    }

    // Arpoo asetettavan palan numeron
    public int arvoPala() {
        return 1;
    }

    // Luo palan palanumeron perusteella palat-taulukosta
    public Pala luoPala(int pala, int x, int y) {
        if (pala == 1) {
            return new Ruoho(x, y);
        }
        if (pala == 2) {
            return new Pensas(x, y);
        }
        return new Ruoho(x, y);
    }

    //Kysyy pelaajalta koordinaatin ja varmistaa että se on 0:n ja 5:n väliltä
    public int kysyKoordinaatti() {
        int luku = -1;
        
        while (true) {

            try {
                luku = Integer.parseInt(lukija.nextLine());
            } catch (Exception e) {
            }

            if (luku < 0 || luku > 5) {
                System.out.println("Anna luku väliltä 0-5");
            } else {
                return luku;
            }
        }
    }
}

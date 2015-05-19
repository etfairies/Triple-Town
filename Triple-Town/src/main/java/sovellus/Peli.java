package sovellus;

import java.util.Random;
import java.util.Scanner;
import pala.Pala;
import pala.Ruoho;

public class Peli {

    private Pelilauta lauta;
    private Scanner lukija = new Scanner(System.in);
    Random arpoja = new Random();
    private String[] palat = {"", "ruoho", "pensas", "puu"};

    public Peli() {
        lauta = new Pelilauta();
    }

    public void aloita() {
        for (int i = 0; i < 2; i++) {

            int x = arpoja.nextInt(6);
            int y = arpoja.nextInt(6);
            this.lauta.asetaLaudalle(new Ruoho(x, y));
        }

        this.lauta.tulostaLauta();
        this.pelaa();
    }

    private void pelaa() {

        while (true) {
            int pala = arvoPala();
            asetaPala(pala);
        }
    }

    private void asetaPala(int pala) {

        while (true) {
            System.out.println("Mihin ruutuun haluat asettaa palan " + palat[pala] + "? Anna rivinumero:");
            int y = kysyLuku();
            System.out.println("Anna sarakenumero:");
            int x = kysyLuku();

            if (this.lauta.tyhjaRuutu(x, y)) {
                this.lauta.asetaLaudalle(luoPala(pala, x, y));
                this.lauta.tulostaLauta();
                break;
            } else {
                System.out.println("Ruutu ei ollut tyhjä!");
            }
        }
    }

    private int arvoPala() {

        return 1;
    }
    
    private Pala luoPala(int pala, int x, int y) {
        
        return new Ruoho(x, y);
    }

    private int kysyLuku() {

        while (true) {
            int luku = Integer.parseInt(lukija.nextLine());

            if (luku < 0 || luku > 6) {
                System.out.println("Anna luku väliltä 0-5");
            } else {
                return luku;
            }
        }

    }

}

package sovellus;

import java.util.Random;
import java.util.Scanner;

public class Peli {

    private Pelilauta lauta;

    public Peli() {
        lauta = new Pelilauta();
    }

    public void aloita() {
        for (int i = 0; i < 2; i++) {

            int x = arvoKoordinaatti();
            int y = arvoKoordinaatti();

            while (this.lauta.tyhjaRuutu(x, y)) {
                this.lauta.asetaLaudalle(1, x, y);
            }
        }

        this.lauta.tulostaLauta();
        this.pelaa();
    }

    public int arvoKoordinaatti() {
        Random arpoja = new Random();
        return arpoja.nextInt(6);
    }

    private void pelaa() {

        while (true) {
            int pala = arvoPala();
            asetaPala(pala);
        }
    }

    private void asetaPala(int pala) {

        Scanner lukija = new Scanner(System.in);
        String[] palat = {"", "ruoho", "pensas", "puu"};
        
        while (true) {
            System.out.println("Mihin ruutuun haluat asettaa palan " + palat[pala] + "? Anna rivinumero:");
            int y = lukija.nextInt();
            System.out.println("Anna sarakenumero:");
            int x = lukija.nextInt();

            if (this.lauta.tyhjaRuutu(x, y)) {
                this.lauta.asetaLaudalle(pala, x, y);
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

}

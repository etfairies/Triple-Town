package sovellus;

import java.util.Random;
import pala.Pala;
import pala.Ruoho;

public class Peli {

    private Pelilauta lauta;

    public Peli() {
        lauta = new Pelilauta();
    }

    public void aloita() {
        for (int i = 0; i < 2; i++) {
            Pala pala = luoPala();
            
            pala.asetaKoordinaatit(arvoKoordinaatti(), arvoKoordinaatti());
            this.lauta.asetaLaudalle(pala);
        }

        this.lauta.tulostaLauta();
    }

    public Pala luoPala() {
        Ruoho ruoho = new Ruoho();
        return ruoho;
    }

    public boolean asetaPala(Pala pala, int x, int y) {
        if (this.lauta.tyhjaRuutu(x, y)) {
            pala.asetaKoordinaatit(x, y);
            return true;
        }
        return false;
    }

    public int arvoKoordinaatti() {
        Random arpoja = new Random();
        return arpoja.nextInt(6);
    }

}

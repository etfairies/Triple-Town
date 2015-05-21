package tripletown.sovellus;

import java.util.Random;
import tripletown.pala.Pala;
import tripletown.pala.Pensas;
import tripletown.pala.Ruoho;

public class Peli {

    private final Pala[][] lauta = new Pala[6][6];
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
            lauta[x][y] = new Ruoho();
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

    // Luo palan arvotun palanumeron perusteella
    public Pala luoPala(int pala) {
        if (pala == 1) {
            return new Ruoho();
        }
        if (pala == 2) {
            return new Pensas();
        }
        return new Ruoho();
    }

    // Asettaa palan pelilaudalle jos ruutu on tyhjä
    public boolean asetaPala(int palanumero, int x, int y) {

        if (lauta[x][y] == null) {
            Pala pala = luoPala(palanumero);
            this.lauta[x][y] = pala;
            this.pisteet += pala.getPisteet();
            
            return true;
        }
        return false;
    }

    public void tulostaLauta() {

        System.out.println("  0 1 2 3 4 5");

        for (int y = 0; y < 6; y++) {
            System.out.print(y + "|");
            for (int x = 0; x < 6; x++) {

                if (this.lauta[x][y] == null) {
                    System.out.print("_|");
                } else {
                    System.out.print(this.lauta[x][y] + "|");
                }
            }
            System.out.println("");
        }
    }

    public int pistetilanne() {
        return this.pisteet;
    }
}

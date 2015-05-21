package tripletown.sovellus;

import java.util.Random;
import tripletown.pala.Pala;
import tripletown.pala.Pensas;
import tripletown.pala.Ruoho;

public class Peli {

    private final Pala[][] lauta = new Pala[6][6];
    Random arpoja = new Random();

   
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
    public boolean asetaPala(int pala, int x, int y) {

        if (lauta[x][y] == null) {
            this.lauta[x][y] = luoPala(pala);
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

}

package sovellus;

import pala.Pala;

public class Pelilauta {

    private final Pala[][] lauta = new Pala[6][6];

    public Pelilauta() {

    }

    public void asetaLaudalle(Pala pala) {
        this.lauta[pala.getX()][pala.getY()] = pala;
    }

    public void tulostaLauta() {

        System.out.println("......");

        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {

                if (this.lauta[x][y] == null) {
                    System.out.print("_|");
                } 
                
                else {
                    System.out.print(this.lauta[x][y] + "|");
                }

            }
            System.out.println("");
        }
        System.out.println("......");
    }
    
    public boolean tyhjaRuutu(int x, int y) {
        if (this.lauta[x][y] == null) {
            return true;
        }
        
        return false;
    }

}

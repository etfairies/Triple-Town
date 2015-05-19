package kayttoliittyma;

import pala.Pala;


public class Pelilauta {

//    private final Pala[][] lauta = new Pala[6][6];
    private final Pala[][] lauta = new Pala[6][6];


    public void asetaLaudalle(Pala pala) {
        this.lauta[pala.getX()][pala.getY()] = pala;
    }

    public void tulostaLauta() {

        System.out.println("  0 1 2 3 4 5");

        for (int y = 0; y < 6; y++) {
            System.out.print(y + "|");
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
      
    }
    
    public boolean tyhjaRuutu(int x, int y) {
        if (this.lauta[x][y] == null) {
            return true;
        }
        
        return false;
    }

  
}

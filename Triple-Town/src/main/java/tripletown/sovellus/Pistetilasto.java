package tripletown.sovellus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Luokka käsittelee tekstitiedostoa pistetilasto.txt, johon pisteet talletetaan.
 */

public class Pistetilasto {
    private ArrayList<Integer> kaikkiPisteet;

    public Pistetilasto() {
        this.kaikkiPisteet = new ArrayList<>();
    }
    
    /**
     * Metodi kutsuu lueTiedosto-metodia, jonka jälkeen listaan talletetut pisteet järjestetään.
     * Tämän jälkeen metodi kutsuu tallenna -metodia.
     * 
     * @param pisteet       Pistetilanne nykyisen pelin päättyessä     *  
     */

    public void tallennaPisteet(int pisteet) {
        File pistetilasto = new File("src/main/resources/pistetilasto.txt");

        kaikkiPisteet = lueTiedosto(pistetilasto);
        kaikkiPisteet.add(pisteet);
        
        Collections.sort(kaikkiPisteet);
        Collections.reverse(kaikkiPisteet);
        
        tallenna(pistetilasto, kaikkiPisteet);
    }

    /**
     * Metodi lukee tekstitiedostoa pistetilasto.txt.
     * Tiedostossa olevat pisteet talletetaan listaan.
     * 
     * @param pistetilasto      Tiedosto, johon pisteet on talletettu.
     * @return                  Palauttaa listan, johon pisteet on talletettu.     * 
     */
    private ArrayList<Integer> lueTiedosto(File pistetilasto) {
        try {
            
            Scanner tiedostonlukija = new Scanner(pistetilasto);
            
            tiedostonlukija.nextLine();
            while (tiedostonlukija.hasNextLine()) {
                String pisteet = tiedostonlukija.nextLine();
                kaikkiPisteet.add(Integer.parseInt(pisteet));
            }
                    
        } catch (FileNotFoundException ex) {
            System.out.println("Pistetilasto -tiedostoa lukiessa tapahtui virhe.");
        }
        
        return kaikkiPisteet;
    }

    
    /**
     * Metodi tallettaa listassa olevat pisteet tekstitiedostoon pistetilasto.txt.
     * Tiedostoon talletetaan vain 10 parasta pistetilannetta.
     * 
     * @param pistetilasto      Tiedosto, johon pisteet talletetaan.
     * @param kaikkiPisteet     Lista, johon kaikki pisteet on talletettu.     * 
     */
    private void tallenna(File pistetilasto, ArrayList<Integer> kaikkiPisteet) {
        try (FileWriter kirjoittaja = new FileWriter(pistetilasto)) {

            kirjoittaja.write("Pistetilasto\n");

            for (int i = 0; i < kaikkiPisteet.size(); i++) {
                if (i > 10) {
                    return;
                }
                kirjoittaja.append(kaikkiPisteet.get(i) + "\n");
            }

            kirjoittaja.close();
            
        } catch (IOException ex) {
            System.out.println("Tiedostoon kirjoittaessa tapahtui virhe.");
        }
    }
}

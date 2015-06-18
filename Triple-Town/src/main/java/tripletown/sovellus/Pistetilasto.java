package tripletown.sovellus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Luokka käsittelee tekstitiedostoa pistetilasto.txt, johon pisteet
 * talletetaan.
 */
public class Pistetilasto {

    private List<Integer> kaikkiPisteet;
    private final File pistetilasto;

    public Pistetilasto() {
        this.kaikkiPisteet = new ArrayList<>();
        this.pistetilasto = new File("src/tiedostot/pistetilasto.txt");
    }

    /**
     * Metodi kutsuu lueTiedosto-metodia, jonka jälkeen listaan talletetut
     * pisteet järjestetään. Tämän jälkeen metodi kutsuu tallenna -metodia.
     *
     * @param pisteet Pistetilanne nykyisen pelin päättyessä
     */
    public void tallennaPisteet(int pisteet) {

        kaikkiPisteet = lueTiedosto();
        kaikkiPisteet.add(pisteet);
        jarjestaPisteLista();
        tallenna();
    }

    /**
     * Metodi lukee tekstitiedostoa pistetilasto.txt. Tiedostossa olevat pisteet
     * talletetaan listaan.
     *
     * @return Palauttaa listan, johon pisteet on talletettu.
     */
    public List<Integer> lueTiedosto() {
        try {
            Scanner tiedostonlukija = new Scanner(pistetilasto);
            lisaaPisteetListaan(tiedostonlukija);

        } catch (FileNotFoundException ex) {
            System.out.println("Pistetilasto -tiedostoa lukiessa tapahtui virhe.");
        }
        jarjestaPisteLista();
        return kaikkiPisteet;
    }

    /**
     * Metodi lisää tekstitiedostossa olevat pisteet listaan.
     * @param lukija    Scanner-olio, joka lukee tekstitiedostoa.
     */
    private void lisaaPisteetListaan(Scanner lukija) {
        while (lukija.hasNextLine()) {
            String pisteet = lukija.nextLine();
            kaikkiPisteet.add(Integer.parseInt(pisteet));
        }
    }

    /**
     * Metodi järjestää pistelistan suurimmasta pienimpään.
     * Metodi huolehtii myös siitä, että pistelista on korkeintaan 10 alkion pituinen.
     */
    public void jarjestaPisteLista() {
        Collections.sort(kaikkiPisteet);
        Collections.reverse(kaikkiPisteet);
        
        if (kaikkiPisteet.size() >= 10) {
            kaikkiPisteet = kaikkiPisteet.subList(0, 10);
        }
    }

    /**
     * Metodi tallettaa listassa olevat pisteet tekstitiedostoon pistetilasto.txt.
     *
     * @param pistetilasto Tiedosto, johon pisteet talletetaan.
     * @param kaikkiPisteet Lista, johon kaikki pisteet on talletettu. *
     */
    private void tallenna() {
        try (FileWriter kirjoittaja = new FileWriter(pistetilasto)) {

            kirjoittaja.write("");

            for (Integer pisteet : kaikkiPisteet) {
                kirjoittaja.append(pisteet + "\n");
            }

            kirjoittaja.close();

        } catch (IOException ex) {
            System.out.println("Tiedostoon kirjoittaessa tapahtui virhe.");
        }
    }
}

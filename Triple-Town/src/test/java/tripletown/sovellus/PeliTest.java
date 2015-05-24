package tripletown.sovellus;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tripletown.pala.Kartano;
import tripletown.pala.Linna;
import tripletown.pala.Pala;
import tripletown.pala.Pensas;
import tripletown.pala.Puu;
import tripletown.pala.Ruoho;
import tripletown.pala.Talo;

public class PeliTest {

    Peli peli;
    ArrayList<Pala> palat;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new Peli();
        palat = new ArrayList<>();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void arvoPalaPalauttaaLuvunValilta1Ja4() {
        for (int i = 0; i < 100; i++) {
            int luku = peli.arvoPala();
            assertTrue(luku < 5 && luku > 0);
        }
    }


    @Test
    public void asetaPalaPalauttaaPalanJosRuutuOnTyhja() {
        Pala asetettu = peli.asetaPala(1, 1, 2);
        assertNotNull(asetettu);
    }

    @Test
    public void asetaPalaPalauttaaNullJosRuudussaOnPala() {
        peli.asetaPala(1, 1, 2);
        Pala asetettu = peli.asetaPala(1, 1, 2);

        assertNull(asetettu);

    }

    @Test
    public void pistetilanneOnAlussaNolla() {
        assertEquals(0, peli.pistetilanne());
    }

    @Test
    public void asetetutPalatKasvattavatPistetilannettaOikein() {
        peli.asetaPala(1, 1, 1);
        peli.asetaPala(2, 2, 4);
        assertEquals(25, peli.pistetilanne());
    }

    @Test
    public void asettamattomatPalatEivatKasvataPistetilannetta() {
        peli.asetaPala(1, 1, 1);
        peli.asetaPala(1, 1, 1);
        assertEquals(5, peli.pistetilanne());
    }

    @Test
    public void tarkistaRuutuLisaaVierekkaisenPalanListaan() {
        Pala pala = peli.asetaPala(1, 1, 1);
        Pala toinenPala = peli.asetaPala(1, 0, 1);
        palat.add(pala);

        peli.tarkistaRuutu(palat, 0, 1, pala.getClass());
        assertEquals(toinenPala, palat.get(1));
    }

    @Test
    public void tarkistaRuutuEiLisaaEriTyyppistaPalaaListaan() {

        Pala pala = peli.asetaPala(1, 1, 1);
        peli.asetaPala(2, 1, 0);
        palat.add(pala);

        peli.tarkistaRuutu(palat, 1, 0, pala.getClass());
        assertEquals(1, palat.size());
    }

    @Test
    public void tarkistaRuutuEiTeeMitaanJosViitataanLaudanUlkopuolelle() {
        peli.tarkistaRuutu(palat, -1, 7, null);
    }

    @Test
    public void poistaPalatLaudaltaPoistaaPelilaudaltaListassaOlevatAlkiot() {

        palat.add(peli.asetaPala(1, 1, 1));
        palat.add(peli.asetaPala(1, 0, 1));
        palat.add(peli.asetaPala(1, 1, 0));

        peli.poistaPalatLaudalta(palat);
        assertEquals(null, peli.getRuutu(1, 1));
        assertEquals(null, peli.getRuutu(0, 1));
        assertEquals(null, peli.getRuutu(1, 0));
    }
    
    @Test
    public void kolmelleVierekkaiselleLinnalleEiTehdaMitaan() {
        palat.add(peli.asetaPala(6, 1, 1));
        palat.add(peli.asetaPala(6, 0, 1));
        palat.add(peli.asetaPala(6, 1, 0));

        peli.yhdistaPalat(palat);
        
        assertTrue(peli.getRuutu(1, 1) instanceof Linna);
        assertTrue(peli.getRuutu(0, 1) instanceof Linna);
        assertTrue(peli.getRuutu(1, 0) instanceof Linna);
    }
}

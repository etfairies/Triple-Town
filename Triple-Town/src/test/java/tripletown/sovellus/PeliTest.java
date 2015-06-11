package tripletown.sovellus;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tripletown.pala.Karhu;
import tripletown.pala.Pala;

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
        peli = new Peli(6, 6);
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
    public void peliLautaTaynnaPalauttaaTrueJosPelilautaOnTaynna() {
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                peli.asetaPala(1, x, y);
            }
        }
        
        assertTrue(peli.pelilautaTaynna());
    }
    
    @Test
    public void peliLautaTaynnaPalauttaaFalseJosPelilautaEiOleTaynna() {
        peli.asetaPala(1, 3, 4);
        peli.asetaPala(1, 2, 2);
        
        assertFalse(peli.pelilautaTaynna());
    }
    
    @Test
    public void liikutaKarhuaLiikuttaaKarhua() {
   
        peli.liikutaKarhua();
        assertTrue(peli.getRuutu(3, 3) == null);
    }
    
    @Test
    public void karhuEiLiikuJosSeOnAnsassa() {

        peli.asetaPala(1, 3, 4);
        peli.asetaPala(1, 3, 2);
        peli.asetaPala(1, 2, 3);
        peli.asetaPala(1, 4, 3);
        
        peli.liikutaKarhua();
        assertTrue(peli.getRuutu(3, 3) instanceof Karhu);
    }
}

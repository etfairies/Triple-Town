package tripletown.sovellus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tripletown.pala.Pala;
import tripletown.pala.Pensas;
import tripletown.pala.Ruoho;

public class PeliTest {

    Peli peli;

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luoPalaPalauttaaOlion() {
        Pala pala = peli.luoPala(0, 1, 2);
        assertNotNull(pala);
    }

    @Test
    public void luoPalaPalauttaaRuohonJosPalanumeroOnYksi() {
        Pala pala = peli.luoPala(1, 1, 2);
        assertTrue(pala instanceof Ruoho);
    }
    
    @Test
    public void luoPalaPalauttaaPensaanJosPalanumeroOnKaksi() {
        Pala pala = peli.luoPala(2, 1, 2);
        assertTrue(pala instanceof Pensas);
    }

    @Test
    public void arvoPalaPalauttaaLuvunValilta0Ja5() {
        for (int i = 0; i < 100; i++) {
            int luku = peli.arvoPala();
            assertTrue("true", luku < 6 && luku > -1);
        }
    }

}

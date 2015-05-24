package tripletown.sovellus;

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

public class LuoPalaTest {

    Peli peli;

    public LuoPalaTest() {
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
        Pala pala = peli.luoPala(1, 1, 2);
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
    public void luoPalaPalauttaaPuunJosPalanumeroOnKolme() {
        Pala pala = peli.luoPala(3, 1, 2);
        assertTrue(pala instanceof Puu);
    }

    @Test
    public void luoPalaPalauttaaTalonJosPalanumeroOnNelja() {
        Pala pala = peli.luoPala(4, 1, 2);
        assertTrue(pala instanceof Talo);
    }

    @Test
    public void luoPalaPalauttaaKartanonJosPalanumeroOnViisi() {
        Pala pala = peli.luoPala(5, 1, 2);
        assertTrue(pala instanceof Kartano);
    }

    @Test
    public void luoPalaPalauttaaLinnanJosPalanumeroOnKuusi() {
        Pala pala = peli.luoPala(6, 1, 2);
        assertTrue(pala instanceof Linna);
    }

    @Test
    public void luoPalaPalauttaaRuohonJosPalanumeroOnAlleYksi() {
        Pala pala = peli.luoPala(0, 1, 2);
        assertTrue(pala instanceof Ruoho);
    }
    
    @Test
    public void luoPalaPalauttaaLinnanJosPalanumeroOnSuurempiKuinKuusi() {
        Pala pala = peli.luoPala(7, 1, 2);
        assertTrue(pala instanceof Linna);
    }
}

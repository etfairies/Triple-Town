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
        peli = new Peli(6, 6);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void asetaPalaPalauttaaOlionJosRuutuOnTyhja() {
        Pala pala = peli.asetaPala(1, 1, 2);
        assertNotNull(pala);
    }

    @Test
    public void asetaPalaPalauttaaRuohonJosPalanumeroOnYksi() {
        Pala pala = peli.asetaPala(1, 1, 2);
        assertTrue(pala instanceof Ruoho);
    }

    @Test
    public void asetaPalaPalauttaaPensaanJosPalanumeroOnKaksi() {
        Pala pala = peli.asetaPala(2, 1, 2);
        assertTrue(pala instanceof Pensas);
    }

    @Test
    public void asetaPalaPalauttaaPuunJosPalanumeroOnKolme() {
        Pala pala = peli.asetaPala(3, 1, 2);
        assertTrue(pala instanceof Puu);
    }

    @Test
    public void asetaPalaPalauttaaTalonJosPalanumeroOnNelja() {
        Pala pala = peli.asetaPala(4, 1, 2);
        assertTrue(pala instanceof Talo);
    }

    @Test
    public void asetaPalaPalauttaaKartanonJosPalanumeroOnViisi() {
        Pala pala = peli.asetaPala(5, 1, 2);
        assertTrue(pala instanceof Kartano);
    }

    @Test
    public void asetaPalaPalauttaaLinnanJosPalanumeroOnKuusi() {
        Pala pala = peli.asetaPala(6, 1, 2);
        assertTrue(pala instanceof Linna);
    }

    @Test
    public void asetaPalaPalauttaaRuohonJosPalanumeroOnAlleYksi() {
        Pala pala = peli.asetaPala(0, 1, 2);
        assertTrue(pala instanceof Ruoho);
    }
    
    @Test
    public void asetaPalaPalauttaaLinnanJosPalanumeroOnSuurempiKuinKuusi() {
        Pala pala = peli.asetaPala(7, 1, 2);
        assertTrue(pala instanceof Linna);
    }
}

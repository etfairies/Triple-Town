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

public class YhdistaPalatTest {

    Peli peli;

    public YhdistaPalatTest() {
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
    public void kolmeRuohoaYhdistyyPensaaksi() {
        Pala pala = peli.asetaPala(1, 1, 1);
        peli.asetaPala(1, 1, 2);
        peli.asetaPala(1, 2, 1);
        peli.vierekkaistenPalojenHaku(pala);

        Pala uusiPala = peli.getRuutu(1, 1);
        assertTrue(uusiPala instanceof Pensas);
    }

    @Test
    public void kolmePensastaYhdistyyPuuksi() {
        Pala pala = peli.asetaPala(2, 1, 1);
        peli.asetaPala(2, 1, 2);
        peli.asetaPala(2, 2, 1);
        peli.vierekkaistenPalojenHaku(pala);

        Pala uusiPala = peli.getRuutu(1, 1);
        assertTrue(uusiPala instanceof Puu);
    }

    @Test
    public void kolmePuutaYhdistyyPuuksi() {
        Pala pala = peli.asetaPala(3, 1, 1);
        peli.asetaPala(3, 1, 2);
        peli.asetaPala(3, 2, 1);
        peli.vierekkaistenPalojenHaku(pala);

        Pala uusiPala = peli.getRuutu(1, 1);
        assertTrue(uusiPala instanceof Talo);
    }

    @Test
    public void kolmeTaloaYhdistyyKartanoksi() {
        Pala pala = peli.asetaPala(4, 1, 1);
        peli.asetaPala(4, 1, 2);
        peli.asetaPala(4, 2, 1);
        peli.vierekkaistenPalojenHaku(pala);

        Pala uusiPala = peli.getRuutu(1, 1);
        assertTrue(uusiPala instanceof Kartano);
    }

    @Test
    public void kolmeKartanoaYhdistyyLinnaksi() {
        Pala pala = peli.asetaPala(5, 1, 1);
        peli.asetaPala(5, 1, 2);
        peli.asetaPala(5, 2, 1);
        peli.vierekkaistenPalojenHaku(pala);

        Pala uusiPala = peli.getRuutu(1, 1);
        assertTrue(uusiPala instanceof Linna);
    }

    @Test
    public void kolmeLinnaaEiYhdisty() {
        Pala pala = peli.asetaPala(6, 1, 1);
        peli.asetaPala(6, 0, 1);
        peli.asetaPala(6, 1, 0);

        peli.vierekkaistenPalojenHaku(pala);
        
        assertTrue(peli.getRuutu(1, 1) instanceof Linna);
        assertTrue(peli.getRuutu(0, 1) instanceof Linna);
        assertTrue(peli.getRuutu(1, 0) instanceof Linna);
    }
    
    @Test
    public void kaksiSamanlaistaPalaaEiYhdistyKorkeammanTasonPalaksi() {
        Pala pala = peli.asetaPala(1, 1, 1);
        peli.asetaPala(1, 0, 1);

        peli.vierekkaistenPalojenHaku(pala);
        Pala uusiPala = peli.getRuutu(1, 1);

        assertTrue(uusiPala instanceof Ruoho);
    }

    @Test
    public void kaksiSamaaJaYksiErilainenPalaEiYhdisty() {
        Pala pala = peli.asetaPala(1, 1, 1);
        peli.asetaPala(1, 1, 0);
        peli.asetaPala(2, 0, 1);

        peli.vierekkaistenPalojenHaku(pala);
        Pala uusiPala = peli.getRuutu(1, 1);

        assertTrue(uusiPala instanceof Ruoho);
    }

    @Test
    public void palojenYhdistaminenPoistaaPalatlaudalta() {
        Pala pala = peli.asetaPala(1, 1, 1);
        peli.asetaPala(1, 1, 2);
        peli.asetaPala(1, 2, 1);
        peli.vierekkaistenPalojenHaku(pala);
        
        assertNotEquals(null, peli.getRuutu(1, 1));
        assertEquals(null, peli.getRuutu(1, 2));
        assertEquals(null, peli.getRuutu(2, 1));
    }
    
    @Test
    public void kolmeRivissaOlevaaPalaaYhdistyy() {
        Pala pala = peli.asetaPala(1, 1, 1);
        peli.asetaPala(1, 2, 1);
        peli.asetaPala(1, 3, 1);
        
        peli.vierekkaistenPalojenHaku(pala);
        assertTrue(peli.getRuutu(1, 1) instanceof Pensas);
    }
  

}

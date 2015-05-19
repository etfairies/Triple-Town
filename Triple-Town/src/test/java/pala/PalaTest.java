package pala;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PalaTest {

    Pala pala;

    public PalaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pala = new Ruoho(1, 2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palaAsettaaKoordinaatitOikein() {
        assertEquals(1, pala.getX());
        assertEquals(2, pala.getY());
    }

    @Test
    public void ruohoPalauttaaOikeanMerkkijonoesityksen() {
        assertEquals("R", pala.toString());
    }
}

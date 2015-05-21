package tripletown.pala;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuohoTest {

    Pala ruoho;

    public RuohoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruoho = new Ruoho();
    }

    @After
    public void tearDown() {
    }


    @Test
    public void ruohoPalauttaaOikeanMerkkijonoesityksen() {
        assertEquals("R", ruoho.toString());
    }
    
    @Test
    public void ruohoPalauttaaOikeanPistemaaran() {
        assertEquals(5, ruoho.getPisteet());
    }
}

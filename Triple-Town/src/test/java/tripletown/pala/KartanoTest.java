
package tripletown.pala;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KartanoTest {
    Pala pala;
    
    public KartanoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pala = new Kartano(1,2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void palaPalauttaaOikeanMerkkijonoesityksen() {
        assertEquals("5", pala.toString());
    }
    
    @Test
    public void palaPalauttaaOikeanPistemaaran() {
        assertEquals(5000, pala.getPisteet());
    }
    
    @Test
    public void palaPalauttaaOikeatKoordinaatit() {
        assertEquals(1, pala.getX());
        assertEquals(2, pala.getY());
    }
}
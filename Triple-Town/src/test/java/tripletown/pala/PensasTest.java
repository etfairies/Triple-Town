
package tripletown.pala;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PensasTest {
    Pala pala;
    
    public PensasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pala = new Pensas(1, 2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void palaPalauttaaOikeanMerkkijonoesityksen() {
        assertEquals("2", pala.toString());
    }
    
    @Test
    public void palaPalauttaaOikeanPistemaaran() {
        assertEquals(20, pala.getPisteet());
    }
    
    @Test
    public void palaPalauttaaOikeatKoordinaatit() {
        assertEquals(1, pala.getX());
        assertEquals(2, pala.getY());
    }
}

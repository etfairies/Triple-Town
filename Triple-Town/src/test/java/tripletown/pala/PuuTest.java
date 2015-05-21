
package tripletown.pala;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PuuTest {
    
    Pala puu;
    
    public PuuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        puu = new Puu();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void palaPalauttaaOikeanMerkkijonoesityksen() {
        assertEquals("U", puu.toString());
    }
    
    @Test
    public void palaPalauttaaOikeanPistemaaran() {
        assertEquals(100, puu.getPisteet());
    }
}

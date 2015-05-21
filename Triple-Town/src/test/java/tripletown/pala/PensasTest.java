
package tripletown.pala;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PensasTest {
    Pala pensas;
    
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
        pensas = new Pensas();
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void ruohoPalauttaaOikeanMerkkijonoesityksen() {
        assertEquals("P", pensas.toString());
    }
    
    @Test
    public void ruohoPalauttaaOikeanPistemaaran() {
        assertEquals(20, pensas.getPisteet());
    }
}

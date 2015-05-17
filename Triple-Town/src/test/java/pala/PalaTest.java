
package pala;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PalaTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void peliAsettaaPalanKoordinaatitOikein() {
         Pala pala = new Ruoho();
         pala.asetaKoordinaatit(3, 1);
         
         assertEquals(3, pala.getX());
         assertEquals(1, pala.getY());
     }
}

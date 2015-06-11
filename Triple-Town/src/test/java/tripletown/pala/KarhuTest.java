
package tripletown.pala;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KarhuTest {
    Karhu karhu;
    public KarhuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        karhu = new Karhu(1,1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void palaPalauttaaOikeanPistemaaran() {
        assertEquals(0, karhu.getPisteet());
    }
    
    @Test
    public void palaPalauttaaOikeanPalanumeron() {
        assertEquals(0, karhu.getId());
    }
    
    @Test
    public void palaPalauttaaOikeatKoordinaatit() {
        assertEquals(1, karhu.getX());
        assertEquals(1, karhu.getY());
    }
    
    @Test
    public void liikuLiikuttaaKarhuaOikein() {
        karhu.liiku(2, 2);
        assertEquals(2, karhu.getX());
        assertEquals(2, karhu.getY());
    }
}

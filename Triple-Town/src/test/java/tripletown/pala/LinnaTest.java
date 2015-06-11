/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripletown.pala;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lilkettu
 */
public class LinnaTest {
    Pala pala;
    public LinnaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pala = new Linna(1, 2);
    }
    
    @After
    public void tearDown() {
    }

   @Test
    public void palaPalauttaaOikeanPalanumeron() {
        assertEquals(6, pala.getId());
    }
    
    @Test
    public void palaPalauttaaOikeanPistemaaran() {
        assertEquals(20000, pala.getPisteet());
    }
    
    @Test
    public void palaPalauttaaOikeatKoordinaatit() {
        assertEquals(1, pala.getX());
        assertEquals(2, pala.getY());
    }
}

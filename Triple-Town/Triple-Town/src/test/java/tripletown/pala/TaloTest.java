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
public class TaloTest {
    Pala pala;
    public TaloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pala = new Talo(1, 2);
    }
    
    @After
    public void tearDown() {
    }

   @Test
    public void palaPalauttaaOikeanMerkkijonoesityksen() {
        assertEquals("4", pala.toString());
    }
    
    @Test
    public void palaPalauttaaOikeanPistemaaran() {
        assertEquals(1500, pala.getPisteet());
    }
    
    @Test
    public void palaPalauttaaOikeatKoordinaatit() {
        assertEquals(1, pala.getX());
        assertEquals(2, pala.getY());
    }
}

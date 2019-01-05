/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
public class CaraOuCoroaTest {
    
    
    public CaraOuCoroaTest() {
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

    /**
     * Test of lançarMoeda method, of class CaraOuCoroa.
     */
    @Test
    public void testLançarMoeda() {
        System.out.println("lancarMoeda");
        CaraOuCoroa instance = new CaraOuCoroa();
       
        
        for (int i = 0; i < 100;i++) {
            System.out.println(instance.lancarMoeda());
        }
        
       
        
    }
    
    
    
}

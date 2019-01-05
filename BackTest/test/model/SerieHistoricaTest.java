/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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
public class SerieHistoricaTest {
    
    public SerieHistoricaTest() {
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
     * Test of getSerie method, of class SerieHistorica.
     */
    @Test
    public void testGetSerie() {
        System.out.println("getSerie");
        SerieHistorica instance = new SerieHistorica(1000);
        
        ArrayList result = instance.getSerie();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}

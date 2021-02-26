/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dev
 */
public class ProcessadorConversaTest {
    
    public ProcessadorConversaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of corrigirConversas method, of class ProcessadorConversa.
     */
    @Test
    public void testCorrigirConversas() {
        System.out.println("corrigirConversas");
        String conversa = "";
        ProcessadorConversa instance = new ProcessadorConversa();
        String expResult = "";
        String result = instance.corrigirConversas(conversa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

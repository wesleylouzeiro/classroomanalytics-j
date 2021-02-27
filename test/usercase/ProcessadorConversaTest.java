/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercase;

import util.Conversa;
import util.Conversas;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dev
 */
public class ProcessadorConversaTest {

    final ProcessadorConversa processadorDeConversas = new ProcessadorConversa();
    final Conversas conversas = new Conversas();

    public ProcessadorConversaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of corrigirConversas method, of class ProcessadorConversa.
     */
    @Test
    public void testExtrairConversas() {
        System.out.println("* testExtrairConversas: extrairConversas");
        Conversa conversaIncompleta = conversas.comMenssagemImcompletaNoFim();
        String conversa = conversaIncompleta.toString();
        List<String> result = processadorDeConversas.extrairConversas(conversa);
        assertEquals(conversaIncompleta.size(), result.size());
        for (int index = 0; index < result.size(); index++) {
            assertEquals(conversaIncompleta.getListaEsperada().get(index), result.get(index));
        }
    }

    /**
     * Test of corrigirConversas method, of class ProcessadorConversa.
     */
    @Test
    public void testMultiplosExtrairConversas() {
        System.out.println("* testExtrairConversas: testMultiplosExtrairConversas");
        conversas.getTodasConversas().forEach((conversaIncompleta) -> {
            String conversa = conversaIncompleta.toString();
            List<String> result = processadorDeConversas.extrairConversas(conversa);
            assertEquals(conversaIncompleta.size(), result.size());
            for (int index = 0; index < result.size(); index++) {
                assertEquals(conversaIncompleta.getListaEsperada().get(index), result.get(index));
            }
        });
    }

    /**
     * Test of esUmaMenssagemDeConversa method, of class ProcessadorConversa.
     */
    @Test
    public void testEsUmaMenssagemDeConversa() {
        System.out.println("* testExtrairConversas: esUmaMenssagemDeConversa");
        String menssagem = conversas.MENSSAGEM_COMPLETA;
        boolean result = processadorDeConversas.esUmaMenssagemDeConversa(menssagem);
        assertTrue(result);
    }

}

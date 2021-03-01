/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import service.ProcessadorConversa;
import service.UltilitarioMenssagem;
import util.ConversaT;
import util.Conversas;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import model.Pessoa;
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
    final Conversas BaseConversas = new Conversas();
    UltilitarioMenssagem UltilMsg = new UltilitarioMenssagem();

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
        ConversaT conversaIncompleta = BaseConversas.comMenssagemImcompletaNoFim();
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
        BaseConversas.getTodasConversas().forEach((conversaIncompleta) -> {
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
        String menssagem = BaseConversas.MENSSAGEM_COMPLETA;
        boolean result = UltilMsg.esUmaMenssagemDeConversa(menssagem);
        assertTrue(result);
    }

    /**
     * Test of estruturaConversas method, of class ProcessadorConversa.
     */
    @Test
    public void testEstruturaConversas() {
        System.out.println("* testExtrairConversas: estruturaConversas");
        List<String> listaDeConversas = BaseConversas.comMenssagemCompleta().getLista();
        ProcessadorConversa instance = new ProcessadorConversa();
        HashMap<String, Pessoa> expResult = BaseConversas.estruturaDeDadosDaConversaComMenssagemCompleta();
        HashMap<String, Pessoa> result = instance.estruturaConversas(listaDeConversas);
        assertEquals(expResult, result);
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult.get(BaseConversas.CONTATO_JOAO_SILVA), result.get(BaseConversas.CONTATO_JOAO_SILVA));
        assertEquals(expResult.get(BaseConversas.CONTATO_JOAO_SILVA).getConversas().size(), result.get(BaseConversas.CONTATO_JOAO_SILVA).getConversas().size());
        assertEquals(expResult.get(BaseConversas.CONTATO_JOAO_SILVA).getConversas().get(0).getData(), 
                result.get(BaseConversas.CONTATO_JOAO_SILVA).getConversas().get(0).getData());
        assertEquals(expResult.get(BaseConversas.CONTATO_JOAO_SILVA).getConversas().get(0).getListaMenssagens().size(), 
                result.get(BaseConversas.CONTATO_JOAO_SILVA).getConversas().get(0).getListaMenssagens().size());
        assertEquals(expResult.get(BaseConversas.CONTATO_JOAO_SILVA).getConversas().get(0).getListaMenssagens().get(0), 
                result.get(BaseConversas.CONTATO_JOAO_SILVA).getConversas().get(0).getListaMenssagens().get(0));
        assertEquals(expResult.get(BaseConversas.CONTATO_JOAO_SILVA).getConversas().get(0).getListaMenssagens().get(0).getMenssagens(), 
                result.get(BaseConversas.CONTATO_JOAO_SILVA).getConversas().get(0).getListaMenssagens().get(0).getMenssagens());        
    }

}

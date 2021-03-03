/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import service.UltilitarioMenssagem;
import java.time.LocalDate;
import model.Menssagem;
import model.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Conversas;

/**
 *
 * @author Dev
 */
public class UltilitarioMenssagemTest {
    Conversas BaseConversas = new Conversas();
    UltilitarioMenssagem instance = new UltilitarioMenssagem();
    
    public UltilitarioMenssagemTest() {
    }

    /**
     * Test of esUmaMenssagemDeConversa method, of class UltilitarioMenssagem.
     */
    @Test
    public void testEsUmaMenssagemDeConversa() {
        System.out.println("* testEsUmaMenssagemDeConversa: esUmaMenssagemDeConversa");
        assertTrue(instance.esUmaMenssagemDeConversa(BaseConversas.MENSSAGEM_COMPLETA));
        assertFalse(instance.esUmaMenssagemDeConversa(BaseConversas.ICORRETA_MENSSAGEM_SEM_DATA));
        assertFalse(instance.esUmaMenssagemDeConversa(BaseConversas.ICORRETA_MENSSAGEM_SEM_HORA));
        assertFalse(instance.esUmaMenssagemDeConversa(BaseConversas.ICORRETA_MENSSAGEM_SEM_CONTATO));
    }

    /**
     * Test of extrairContato method, of class UltilitarioMenssagem.
     */
    @Test
    public void testExtrairContato() {
        System.out.println("* testEsUmaMenssagemDeConversa: extrairContato");
        String contato = BaseConversas.CONTATO_JOAO_SILVA;
        Pessoa expResult = new Pessoa(contato,contato);
        Pessoa result = instance.extrairContato(BaseConversas.MENSSAGEM_COMPLETA);
        assertEquals(expResult, result);
    }

    /**
     * Test of extrairComponenteMenssagem method, of class UltilitarioMenssagem.
     */
    @Test
    public void testExtrairComponenteMenssagem() {
        System.out.println("* testEsUmaMenssagemDeConversa: extrairComponenteMenssagem");
        String menssagem = BaseConversas.MENSSAGEM_COMPLETA;
        String[] expResult = {BaseConversas.DATA_11_02_21,
            BaseConversas.HORAS_16_30,
            BaseConversas.CONTATO_JOAO_SILVA,
            BaseConversas.TEXTO_MENSSAGEM};
        String[] result = instance.extrairComponenteMenssagem(menssagem);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of extrairMenssagem method, of class UltilitarioMenssagem.
     */
    @Test
    public void testExtrairMenssagem() {
        System.out.println("* testEsUmaMenssagemDeConversa: extrairMenssagem");
        String menssagem = BaseConversas.MENSSAGEM_COMPLETA;
        Menssagem expResult = new Menssagem(BaseConversas.DATE_11_02_21,BaseConversas.TIME_16_30,BaseConversas.TEXTO_MENSSAGEM);
        Menssagem result = instance.extrairMenssagem(menssagem);
        assertEquals(expResult, result);
    }

    /**
     * Test of extrairNomeContato method, of class UltilitarioMenssagem.
     */
    @Test
    public void testExtrairNomeContato() {
        System.out.println("* testEsUmaMenssagemDeConversa: extrairNomeContato");
        String menssagem = BaseConversas.MENSSAGEM_COMPLETA;
        String expResult = BaseConversas.CONTATO_JOAO_SILVA;
        String result = instance.extrairNomeContato(menssagem);
        assertEquals(expResult, result);
    }

    /**
     * Test of menssagemEstarEntreDatas method, of class UltilitarioMenssagem.
     */
    @Test
    public void testMenssagemEstarEntreDatas() {
        System.out.println("* testEsUmaMenssagemDeConversa: menssagemEstarEntreDatas");
        String menssagem = BaseConversas.MENSSAGEM_COMPLETA;
        LocalDate data1 = BaseConversas.DATE_11_02_21;
        LocalDate data2 = BaseConversas.DATE_12_02_21;
        boolean result = instance.menssagemEstarEntreDatas(menssagem, data1, data2);
        assertTrue(result);
        result = instance.menssagemEstarEntreDatas(menssagem, data1, data1);
        assertTrue(result);
        result = instance.menssagemEstarEntreDatas(menssagem, data2, data2);
        assertFalse(result);   
    }
    
}

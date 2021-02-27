/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercase;

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
    
    public UltilitarioMenssagemTest() {
    }

    /**
     * Test of esUmaMenssagemDeConversa method, of class UltilitarioMenssagem.
     */
    @Test
    public void testEsUmaMenssagemDeConversa() {
        System.out.println("* testEsUmaMenssagemDeConversa: esUmaMenssagemDeConversa");
        UltilitarioMenssagem instance = new UltilitarioMenssagem();
        assertTrue(instance.esUmaMenssagemDeConversa(BaseConversas.MENSSAGEM_COMPLETA));
    }

    /**
     * Test of extrairContato method, of class UltilitarioMenssagem.
     */
    @Test
    public void testExtrairContato() {
        System.out.println("* testEsUmaMenssagemDeConversa: extrairContato");
        String contato = BaseConversas.CONTATO_JOAO_SILVA;
        UltilitarioMenssagem instance = new UltilitarioMenssagem();
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
        UltilitarioMenssagem instance = new UltilitarioMenssagem();
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
        UltilitarioMenssagem instance = new UltilitarioMenssagem();        
        Menssagem expResult = new Menssagem(BaseConversas.DATE_11_02_21,BaseConversas.TIME_16_30,BaseConversas.TEXTO_MENSSAGEM);
        Menssagem result = instance.extrairMenssagem(menssagem);
        assertEquals(expResult, result);
    }
    
}

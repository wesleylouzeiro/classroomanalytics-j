/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercase;

import model.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Conversas;

/**
 *
 * @author Dev
 */
public class UltilitarioMenssagemTest {
    Conversas conversasExemplos = new Conversas();
    
    public UltilitarioMenssagemTest() {
    }

    /**
     * Test of esUmaMenssagemDeConversa method, of class UltilitarioMenssagem.
     */
    @Test
    public void testEsUmaMenssagemDeConversa() {
        System.out.println("* testEsUmaMenssagemDeConversa: esUmaMenssagemDeConversa");
        UltilitarioMenssagem instance = new UltilitarioMenssagem();
        assertTrue(instance.esUmaMenssagemDeConversa(conversasExemplos.MENSSAGEM_COMPLETA));
    }

    /**
     * Test of extrairContato method, of class UltilitarioMenssagem.
     */
    @Test
    public void testExtrairContato() {
        System.out.println("* testEsUmaMenssagemDeConversa: extrairContato");
        String contato = conversasExemplos.CONTATO_JOAO_SILVA;
        UltilitarioMenssagem instance = new UltilitarioMenssagem();
        Pessoa expResult = new Pessoa(contato,contato);
        Pessoa result = instance.extrairContato(conversasExemplos.MENSSAGEM_COMPLETA);
        assertEquals(expResult, result);
    }

    /**
     * Test of extrairComponenteMenssagem method, of class UltilitarioMenssagem.
     */
    @Test
    public void testExtrairComponenteMenssagem() {
        System.out.println("* testEsUmaMenssagemDeConversa: extrairComponenteMenssagem");
        String menssagem = conversasExemplos.MENSSAGEM_COMPLETA;
        UltilitarioMenssagem instance = new UltilitarioMenssagem();
        String[] expResult = {conversasExemplos.DATA_11_02_21,
            conversasExemplos.HORAS_16_30,
            conversasExemplos.CONTATO_JOAO_SILVA,
            conversasExemplos.TEXTO_MENSSAGEM};
        String[] result = instance.extrairComponenteMenssagem(menssagem);
        assertArrayEquals(expResult, result);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Conversas;

/**
 *
 * @author Dev
 */
public class PessoaTest {
    
    final Conversas BaseConversas = new Conversas();
    
    public PessoaTest() {
    }

    

    /**
     * Test of getResumoConversas method, of class Pessoa.
     */
    @Test
    public void testGetResumoConversas() {
        System.out.println("* testGetResumoConversas: getResumoConversas");        
        Pessoa instance = BaseConversas.estruturaDeDadosDaConversaComMenssagemCompleta()
                .get(BaseConversas.CONTATO_JOAO_SILVA);
        Conversa conv = instance.getConversas().get(0);
        instance.setConversa(conv);
        Conversa expResult = new Conversa(BaseConversas.DATE_11_02_21);
        Menssagem msg = conv.getListaMenssagens().get(0);
        for(int index=0; index<6; index++){
            expResult.setMenssagens(msg);
        }
        Conversa result = instance.getResumoConversas();
        assertEquals(expResult.getListaMenssagens().size(), result.getListaMenssagens().size());
    }

    
}

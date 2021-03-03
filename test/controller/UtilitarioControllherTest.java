/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Conversas;

/**
 *
 * @author Dev
 */
public class UtilitarioControllherTest {
    
    Conversas BaseConversas = new Conversas();
    
    public UtilitarioControllherTest() {
    }

    /**
     * Test of converteListaContatosEmMapaEstaistico method, of class UtilitarioControllher.
     */
    @Test
    public void testConverteListaContatosEmMapaEstaistico() {
        System.out.println("* testConverteListaContatosEmMapaEstaistico: converteListaContatosEmMapaEstaistico");
        List<Pessoa> listaContatos = new ArrayList<>(BaseConversas.estruturaDeDadosDaConversaComMenssagemCompleta().values());
        UtilitarioControllher instance = new UtilitarioControllher();
        Object[][] expResult = BaseConversas.MATRIZ_DADOS_CONVERSA;
        Object[][] result = instance.converteListaContatosEmMapaEstaistico(listaContatos);
        assertArrayEquals(expResult, result);
        // "Contados", "Interação", "Texto", "Imagens", "Documentos", "Audios", "Vídeos", "Outros"
    }

    /**
     * Test of converteListaStringEmArray method, of class UtilitarioControllher.
     */
    @Test
    public void testConverteListaStringEmArray() {
        System.out.println("* testConverteListaContatosEmMapaEstaistico: converteListaStringEmArray");
        List<String> listaDatas = new ArrayList<>();
        listaDatas.add(BaseConversas.DATA_11_02_21);
        listaDatas.add(BaseConversas.DATA_11_02_21);
        listaDatas.add(BaseConversas.DATA_12_02_21);
        UtilitarioControllher instance = new UtilitarioControllher();
        String[] expResult = {BaseConversas.DATA_11_02_21,BaseConversas.DATA_11_02_21,BaseConversas.DATA_12_02_21};
        String[] result = instance.converteListaStringEmArray(listaDatas);
        assertEquals(expResult.length, result.length);
        assertArrayEquals(expResult, result);
    }
    
}

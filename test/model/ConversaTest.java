/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import service.UltilitarioMenssagem;
import util.Conversas;

/**
 *
 * @author Dev
 */
public class ConversaTest {
    
    Conversas BaseConversas = new Conversas();
    UltilitarioMenssagem UltilMsg = new UltilitarioMenssagem();
    
    public ConversaTest() {
    }

    /**
     * Test of geraEstatisticas method, of class Conversa.
     */
    @Test
    public void testGeraEstatisticas() {
        System.out.println("* ConversaTest: geraEstatisticas");
        Conversa instance = new Conversa(BaseConversas.DATE_11_02_21);
        instance.setMenssagens(UltilMsg.extrairMenssagem(BaseConversas.MENSSAGEM_MIDIA));
        instance.setMenssagens(UltilMsg.extrairMenssagem(BaseConversas.MENSSAGEM_MIDIA));
        instance.geraEstatisticas();
        instance.geraEstatisticas();
        assertEquals(2,instance.getQuantidadeMidia());
    }

    
}

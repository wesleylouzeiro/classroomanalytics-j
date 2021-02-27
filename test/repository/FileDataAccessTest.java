/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.io.File;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import util.Conversas;

/**
 *
 * @author Dev
 */
public class FileDataAccessTest {

    Conversas conversas = new Conversas();

    public FileDataAccessTest() {
    }

    

    /**
     * Test of limparTexto method, of class FileDataAccess.
     */
    @Test
    public void testLimparTexto() {
        System.out.println("* FileDataAccessTest: limparTexto");
        List<String> listaMenssagens = conversas.comMenssagemSuja().getLista();
        for (int index=0;index<listaMenssagens.size();index++ ) {
            String textoSujo = listaMenssagens.get(index);
            FileDataAccess instance = new FileDataAccess();
            String expResult = conversas.comMenssagemSuja().getListaEsperada().get(index);
            String result = instance.limparTexto(textoSujo);
            //System.out.println("result: "+result);
            assertEquals(expResult, result);
        }

    }

}

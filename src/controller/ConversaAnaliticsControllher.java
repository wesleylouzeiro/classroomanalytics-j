/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import repository.FileDataAccess;
import usercase.ProcessadorConversa;

/**
 *
 * @author Dev
 */
public class ConversaAnaliticsControllher {
    
    
    public String processarTexto(File file) throws IOException{
        ProcessadorConversa processador = new ProcessadorConversa();  
        FileDataAccess fileDA = new FileDataAccess();
        String conversa = fileDA.extrairTexto(file);
        conversa = fileDA.limparTexto(conversa);
//        System.out.println("conversa: "+conversa);
//        System.out.println("processador.extrairConversas(conversa).size(): "+processador.extrairConversas(conversa).size());
        String resultado = processador.extrairConversas(conversa).stream().reduce("", (textoConversa,menssagem)->textoConversa+"\n"+menssagem);
        return resultado;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import usercase.ProcessadorConversa;

/**
 *
 * @author Dev
 */
public class ConversaAnalitics {
    
    
    public String processarTexto(File file) throws IOException{
        ProcessadorConversa processador = new ProcessadorConversa();        
        return processador.extrairTexto(file);
    }
    
}

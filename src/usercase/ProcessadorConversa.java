/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Dev
 */
public class ProcessadorConversa {
    
    public String extrairTexto(File arquivo) throws FileNotFoundException, IOException{
        StringBuilder texto = new StringBuilder();
        BufferedReader buffRead = new BufferedReader(new FileReader(arquivo));
        String linha = "";
        while (true) {
            if (linha == null) {
                break;
            }            
            texto.append(linha);                
            texto.append("\r\n");         
            System.out.println("-> "+linha);
            linha = buffRead.readLine();
        }        
        buffRead.close();
        return "";
    }
    
    
    
}

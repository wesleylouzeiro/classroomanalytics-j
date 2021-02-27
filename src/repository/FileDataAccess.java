/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Dev
 */
public class FileDataAccess {
    
    public String extrairTexto(File arquivo) throws FileNotFoundException, IOException{
        StringBuilder texto = new StringBuilder();
        BufferedReader buffRead = new BufferedReader(new FileReader(arquivo));
        String linha = "";
        while (true) {
            if (linha == null) {
                break;
            }            
            texto.append(linha);                
            texto.append("\n");         
            linha = buffRead.readLine();
        }        
        buffRead.close();
        return texto.toString();
    }
    
    public String limparTexto(String textoSujo){
        String textoLimpo = textoSujo.trim();
        textoLimpo = textoLimpo.replaceAll("\t", "");
        textoLimpo = textoLimpo.replaceAll("\n*\n", "\n");        
        return textoLimpo;
    }
      
}

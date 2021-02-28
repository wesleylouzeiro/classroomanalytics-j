/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import model.Pessoa;
import repository.FileDataAccess;
import service.ProcessadorConversa;

/**
 *
 * @author Dev
 */
public class ConversaAnaliticsControllher {
    
    
    public String processarArquivoDeTexto(File file) throws IOException{
        ProcessadorConversa processador = new ProcessadorConversa();  
        FileDataAccess fileDA = new FileDataAccess();
        String conversa = fileDA.extrairTexto(file);
        conversa = fileDA.limparTexto(conversa);
        String resultado = processador.extrairConversas(conversa).stream()
                .reduce("", (textoConversa,menssagem)->textoConversa+(textoConversa.isBlank()?"":"\n")+menssagem);
        return resultado;
    }
    
    public Map<String,Pessoa> gerarListaContatos(String conversa){
        ProcessadorConversa processador = new ProcessadorConversa();  
        List<String> listaMenssagem = processador.extrairConversas(conversa);
        Map<String,Pessoa> mapaContato = processador.estruturaConversas(listaMenssagem);
        
        return mapaContato;
    }
    
}

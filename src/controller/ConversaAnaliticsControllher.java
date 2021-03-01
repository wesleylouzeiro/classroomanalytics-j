/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    
    public List<Pessoa> gerarListaContatos(String conversa){
        ProcessadorConversa processador = new ProcessadorConversa();  
        List<String> listaMenssagem = processador.extrairConversas(conversa);
        Map<String,Pessoa> mapaContato = processador.estruturaConversas(listaMenssagem);       
        List<Pessoa> listaContatos = new ArrayList<>(mapaContato.values());
        return listaContatos;
    }
    
    /*
     "Contados", "Interação", "Texto", "Imagens", "Documentos", "Audios", "Vídeos", "Outros"
    */
    public Object [][] gerarMapaEstaisticoDeContatos(String conversa){
        List<Pessoa> listaContatos = this.gerarListaContatos(conversa);
        ArrayList<String[]> listaDeDados = new ArrayList<>();        
        Object [][] matrizDados = new Object [listaContatos.size()][8];                        
        for(int index=0; index<listaContatos.size();index++){
            Pessoa contato = listaContatos.get(index);
            matrizDados[index][0] = contato.getContato();
                matrizDados[index][1] = contato.getResumoConversas().getQuantidadeInteracao();
                matrizDados[index][2] = contato.getResumoConversas().getQuantidadeTexto();
                matrizDados[index][3] = contato.getResumoConversas().getQuantidadeImagens();
                matrizDados[index][4] = contato.getResumoConversas().getQuantidadeDocumentos();
                matrizDados[index][5] = contato.getResumoConversas().getQuantidadeAudios();
                matrizDados[index][6] = contato.getResumoConversas().getQuantidadeVideos();
                matrizDados[index][7] = contato.getResumoConversas().getQuantidadeOutros();
        }
        
        return matrizDados;
    }
    
}

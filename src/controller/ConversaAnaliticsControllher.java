/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    private UtilitarioControllher UtilControlhe = new UtilitarioControllher();
    private ProcessadorConversa processador = new ProcessadorConversa();

    public String processarArquivoDeTexto(File file) throws IOException {
        FileDataAccess fileDA = new FileDataAccess();
        String conversa = fileDA.extrairTexto(file);
        conversa = fileDA.limparTexto(conversa);
        String resultado = processador.extrairConversas(conversa).stream()
                .reduce("", (textoConversa, menssagem) -> textoConversa + (textoConversa.isBlank() ? "" : "\n") + menssagem);
        return resultado;
    }

    public List<Pessoa> gerarListaContatos(String conversa, String dataInicio, String dataFim) {
        List<String> listaMenssagem = processador.extrairConversas(conversa);
        
        if (!dataInicio.isBlank() && !dataFim.isBlank()) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataInicio = dataInicio.isBlank()?dataFim:dataInicio;
            dataFim = dataFim.isBlank()?dataInicio:dataFim;
            LocalDate dateInicio = LocalDate.parse(dataInicio, formato);
            LocalDate dateFim = LocalDate.parse(dataFim, formato);            
            listaMenssagem = processador.filtraConversa(listaMenssagem, dateInicio, dateFim);
        }
        
        Map<String, Pessoa> mapaContato = processador.estruturaConversas(listaMenssagem);
        List<Pessoa> listaContatos = new ArrayList<>(mapaContato.values());
        return listaContatos;
    }

    
    
    
    public Object[][] gerarMapaEstatisticoDeContatos(String conversa, String dataInicio, String dataFim) {
        List<Pessoa> listaContatos = this.gerarListaContatos(conversa,dataInicio, dataFim);        
        Object[][] matrizDados = UtilControlhe.converteListaContatosEmMapaEstaistico(listaContatos);
        return matrizDados;
    }
    
    public String[] recuperarTodasAsDatasDaConversa(String conversa){
        List<String> listaMenssagem = processador.extrairConversas(conversa);
        String[] datas =  UtilControlhe.converteListaStringEmArray(processador.recuperaDataConversa(listaMenssagem)); 
        return datas;
    }

}

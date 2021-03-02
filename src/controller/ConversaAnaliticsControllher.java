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

    public String processarArquivoDeTexto(File file) throws IOException {
        ProcessadorConversa processador = new ProcessadorConversa();
        FileDataAccess fileDA = new FileDataAccess();
        String conversa = fileDA.extrairTexto(file);
        conversa = fileDA.limparTexto(conversa);
        String resultado = processador.extrairConversas(conversa).stream()
                .reduce("", (textoConversa, menssagem) -> textoConversa + (textoConversa.isBlank() ? "" : "\n") + menssagem);
        return resultado;
    }

    public List<Pessoa> gerarListaContatos(String conversa, String dataFiltro) {
        ProcessadorConversa processador = new ProcessadorConversa();
        List<String> listaMenssagem = processador.extrairConversas(conversa);
        if (!dataFiltro.isBlank()) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataFiltro, formato);
            listaMenssagem = processador.filtraConversa(listaMenssagem, data);
        }
        Map<String, Pessoa> mapaContato = processador.estruturaConversas(listaMenssagem);
        List<Pessoa> listaContatos = new ArrayList<>(mapaContato.values());
        return listaContatos;
    }

    /*
     "Contados", "Interação", "Texto", "Imagens", "Documentos", "Audios", "Vídeos", "Outros"
     */
    public Object[][] gerarMapaEstatisticoDeContatos(String conversa, String dataFiltro) {
        List<Pessoa> listaContatos = this.gerarListaContatos(conversa,dataFiltro);
        UtilitarioControllher UtilControlhe = new UtilitarioControllher();
        Object[][] matrizDados = UtilControlhe.converteListaContatosEmMapaEstaistico(listaContatos);
        return matrizDados;
    }

}

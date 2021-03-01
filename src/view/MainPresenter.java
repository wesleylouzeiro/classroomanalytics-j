/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConversaAnaliticsControllher;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import model.Pessoa;

/**
 *
 * @author Dev
 */
public class MainPresenter {
    
    private String textoDeArquivoAtual = "";    
    private final IDashboard dashboard;
    private final ConversaAnaliticsControllher conversaAnaliticsControl = new ConversaAnaliticsControllher();
    
    public MainPresenter(IDashboard dashboard){
        this.dashboard = dashboard;
    }
    
    public void processarDadosDoArquivo(File arquivo) throws FileNotFoundException, IOException{
        textoDeArquivoAtual = conversaAnaliticsControl.processarArquivoDeTexto(arquivo);
        
        this.dashboard.atualizarCampoEditor(textoDeArquivoAtual);
    }
    
    public boolean esUmArquivoValido(File arquivoSelecionado){
        return arquivoSelecionado!=null && arquivoSelecionado.isFile() && !arquivoSelecionado.getName().equals("");
    }
    
    public void atualizarTabelaDeContato(String data){
        Object [][] matrizDados = conversaAnaliticsControl.gerarMapaEstatisticoDeContatos(textoDeArquivoAtual);        
        String[] nomeColunas = new String [] {
                "Contados", "Interação", "Texto", "Mídia"};
        
        this.dashboard.atualizarTabelaEstatisticaContatos(matrizDados,nomeColunas);
    }
    
}

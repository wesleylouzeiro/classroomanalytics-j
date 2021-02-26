/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConversaAnalitics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Dev
 */
public class MainPresenter {
    
    private final IDashboard dashboard;
    private final ConversaAnalitics conversaAnaliticsControl = new ConversaAnalitics();
    
    public MainPresenter(IDashboard dashboard){
        this.dashboard = dashboard;
    }
    
    public void processarDadosDoArquivo(File arquivo) throws FileNotFoundException, IOException{
        String texto = conversaAnaliticsControl.processarTexto(arquivo);
        System.out.println("texto "+texto);
        
        this.dashboard.atualizarCampoEditor(texto);
    }
    
    public boolean esUmArquivoValido(File arquivoSelecionado){
        return arquivoSelecionado!=null && arquivoSelecionado.isFile() && !arquivoSelecionado.getName().equals("");
    }
    
}

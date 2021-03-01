/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.List;
import model.Pessoa;

/**
 *
 * @author Dev
 */
public class UtilitarioControllher {
    
    public Object [][] converteListaContatosEmMapaEstaistico(List<Pessoa> listaContatos){    
        Object [][] matrizDados = new Object [listaContatos.size()][8];                        
        for(int index=0; index<listaContatos.size();index++){
            Pessoa contato = listaContatos.get(index);
            matrizDados[index][0] = contato.getContato();
                matrizDados[index][1] = contato.getResumoConversas().getQuantidadeInteracao()+"";
                matrizDados[index][2] = contato.getResumoConversas().getQuantidadeTexto()+"";
                matrizDados[index][3] = contato.getResumoConversas().getQuantidadeImagens()+"";
                matrizDados[index][4] = contato.getResumoConversas().getQuantidadeDocumentos()+"";
                matrizDados[index][5] = contato.getResumoConversas().getQuantidadeAudios()+"";
                matrizDados[index][6] = contato.getResumoConversas().getQuantidadeVideos()+"";
                matrizDados[index][7] = contato.getResumoConversas().getQuantidadeOutros()+"";
        }        
        return matrizDados;
    }
    
}
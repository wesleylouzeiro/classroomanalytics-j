/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dev
 */
public class Conversa {
    private final LocalDate data;
    
    private final List<Menssagem> listaMenssagens = new LinkedList<>();
    
    private int quantidadeInteracao;
    private int quantidadeTexto;
    private int quantidadeMidia;

    public Conversa(LocalDate data) {
        this.data = data;
    }
    
    public void geraEstatisticas(){
        this.quantidadeInteracao = this.listaMenssagens.size();
        this.quantidadeMidia=0;
        this.quantidadeTexto=0;
        this.listaMenssagens.forEach((menssagem)->{
            String textoMenssagem = menssagem.getMenssagens();
            this.quantidadeTexto += textoMenssagem.length();
            this.quantidadeMidia += (textoMenssagem+" ").split("<Arquivo\\sde\\smídia\\soculto>").length-1;
        });
    }

    
    /**
     * @return the data
     */
    public LocalDate getData() {
        return data;
    }
    
    public void setMenssagens(Menssagem menssagem) {
        listaMenssagens.add(menssagem);
        this.geraEstatisticas();
    }

    /**
     * @return the listaMenssagens
     */
    public List<Menssagem> getListaMenssagens() {
        return listaMenssagens;
    }
    
    public void unirConversa(Conversa conversa) {
        this.listaMenssagens.addAll(conversa.listaMenssagens);
        this.geraEstatisticas();
    }

    /**
     * @return the quantidadeInteracao
     */
    public int getQuantidadeInteracao() {
        return quantidadeInteracao;
    }

    /**
     * @return the quantidadeTexto
     */
    public int getQuantidadeTexto() {
        return quantidadeTexto;
    }


    /**
     * @return the quantidadeMidia
     */
    public int getQuantidadeMidia() {
        return quantidadeMidia;
    }

    
     
    
}

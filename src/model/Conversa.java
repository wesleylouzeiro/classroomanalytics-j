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
    private int quantidadeImagens;
    private int quantidadeDocumentos;
    private int quantidadeAudios;
    private int quantidadeVideos;
    private int quantidadeOutros;

    public Conversa(LocalDate data) {
        this.data = data;
    }

    /**
     * @return the data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * @return the listaMenssagens
     */
    public List<Menssagem> getListaMenssagens() {
        return listaMenssagens;
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
     * @return the quantidadeImagens
     */
    public int getQuantidadeImagens() {
        return quantidadeImagens;
    }

    /**
     * @return the quantidadeDocumentos
     */
    public int getQuantidadeDocumentos() {
        return quantidadeDocumentos;
    }

    /**
     * @return the quantidadeAudios
     */
    public int getQuantidadeAudios() {
        return quantidadeAudios;
    }

    /**
     * @return the quantidadeVideos
     */
    public int getQuantidadeVideos() {
        return quantidadeVideos;
    }

    /**
     * @return the quantidadeOutros
     */
    public int getQuantidadeOutros() {
        return quantidadeOutros;
    }
     
    
}
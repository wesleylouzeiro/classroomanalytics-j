/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dev
 */
public class Pessoa {
    private final String nome;
    private final String contato;
    private Tipo tipo;
    private final List<Conversa> conversas = new ArrayList<>();
    
    public enum Tipo{ALUNO,PROFESSOR,COORDENADOR,OUTROS};
    
    public Pessoa(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public Pessoa(String nome, String contato, Tipo tipo) {
        this.nome = nome;
        this.contato = contato;
        this.tipo = tipo;
    }
    
    public void setConversa(Conversa conversa){
        this.conversas.add(conversa);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}

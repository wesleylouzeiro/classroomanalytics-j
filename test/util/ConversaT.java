/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Dev
 */
public class ConversaT {

    private final String[] listaConversa;
    private final String[] listaConversaEsperada;
    

    public ConversaT(String[] listaConversa) {
        this.listaConversa = listaConversa;
        this.listaConversaEsperada = listaConversa;
    }
    
    public ConversaT(String[] listaConversa, String[] listaConversaEsperada) {
        this.listaConversa = listaConversa;
        this.listaConversaEsperada = listaConversaEsperada;
    }
    
    public int size(){
        return this.listaConversaEsperada.length;
    }
    
    public List<String> getLista(){
        return Arrays.asList(this.listaConversa);
    }
    
    public List<String> getListaEsperada(){
        return Arrays.asList(this.listaConversaEsperada);
    }

    @Override
    public String toString() {
        return Arrays.asList(listaConversa).stream().reduce("", (conversa,menssagem)->conversa+"\n"+menssagem);
    }
    
    

}

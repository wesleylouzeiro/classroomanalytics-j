/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Dev
 */
public class Conversas {
    
    public final String CONTATO_JOAO_SILVA="João Silva";
    public final String DATA_11_02_21="11/02/2021";
    public final String HORAS_16_30="16:30";
    public final String TEXTO_MENSSAGEM="Essa é uma menssagem completa.";
    
    public final String MENSSAGEM_COMPLETA=DATA_11_02_21+" "+HORAS_16_30+" - "+CONTATO_JOAO_SILVA+": "+TEXTO_MENSSAGEM;
    public final String MENSSAGEM_IMCOMPLETA="11/02/2021 16:31 - João Silva: Essa messagem esta imcompleta pois...";
    public final String COMPLEMENTO_MENSSAGEM="... aqui está o complemento da menssagem restante.";
    
      
    
        
    public Conversa comMenssagemCompleta(){
        String[] conversaComMenssagensCompletas = {MENSSAGEM_COMPLETA,MENSSAGEM_COMPLETA,MENSSAGEM_COMPLETA};
        return new Conversa(conversaComMenssagensCompletas);
    }
    
    public Conversa comMenssagemImcompletaNoInicio(){
        String[] conversaComMenssagensImcompletasBruta = {COMPLEMENTO_MENSSAGEM,MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA};
        String[] conversaComMenssagensImcompletasEsperada = {COMPLEMENTO_MENSSAGEM,MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA};
        return new Conversa(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }
    
    public Conversa comMenssagemImcompletaNoMeio(){
        String[] conversaComMenssagensImcompletasBruta = {MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA,COMPLEMENTO_MENSSAGEM,MENSSAGEM_COMPLETA};
        String[] conversaComMenssagensImcompletasEsperada = {MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA+COMPLEMENTO_MENSSAGEM,MENSSAGEM_COMPLETA};
        return new Conversa(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }
    
    public Conversa comMenssagemImcompletaNoFim(){
        String[] conversaComMenssagensImcompletasBruta = {MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA,COMPLEMENTO_MENSSAGEM};
        String[] conversaComMenssagensImcompletasEsperada = {MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA+COMPLEMENTO_MENSSAGEM};
        return new Conversa(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }   
    
    public Conversa comMenssagemImcompletaMultipos(){
        String[] conversaComMenssagensImcompletasBruta = {MENSSAGEM_COMPLETA,
            MENSSAGEM_IMCOMPLETA,COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM,
            MENSSAGEM_IMCOMPLETA,COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM};
        String[] conversaComMenssagensImcompletasEsperada = {MENSSAGEM_COMPLETA,
            MENSSAGEM_IMCOMPLETA+COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM,
            MENSSAGEM_IMCOMPLETA+COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM};
        return new Conversa(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }  
    
    
    public Conversa comComplementosDeMenssagens(){
        String[] conversaComMenssagensImcompletasBruta = {COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM};
        String[] conversaComMenssagensImcompletasEsperada = {COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM};
        return new Conversa(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }
    
    
    
    public List<Conversa> getTodasConversas(){
        ArrayList<Conversa> todasConversas = new ArrayList<>();
        todasConversas.add(this.comMenssagemCompleta());
        todasConversas.add(this.comMenssagemImcompletaNoInicio());
        todasConversas.add(this.comMenssagemImcompletaNoMeio());
        todasConversas.add(this.comMenssagemImcompletaNoFim());
        todasConversas.add(this.comMenssagemImcompletaMultipos());
        todasConversas.add(this.comComplementosDeMenssagens());
        return todasConversas;
    }
    
    public Conversa comMenssagemSuja(){
        String[] conversaComMenssagensImcompletasBruta = {
            "   "+MENSSAGEM_COMPLETA,
            MENSSAGEM_IMCOMPLETA+"\n\n\n\n",
            "\t"+COMPLEMENTO_MENSSAGEM};//,MENSSAGEM_COMPLETA};
        String[] conversaComMenssagensImcompletasEsperada = {MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA,COMPLEMENTO_MENSSAGEM};//,MENSSAGEM_COMPLETA};
        return new Conversa(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }
    
    
    
       
        
}

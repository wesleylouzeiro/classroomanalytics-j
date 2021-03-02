/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import model.Conversa;
import model.Menssagem;
import model.Pessoa;

/**
 *
 * @author Dev
 */
public class Conversas {
    
    public final String CONTATO_JOAO_SILVA="João Silva";
    public final String CONTATO_MARIA_SOUSA="Maria Sousa";
    public final String DATA_11_02_21="11/02/2021";
    public final LocalDate DATE_11_02_21=LocalDate.of(2021, 02, 11);
    public final String HORAS_16_30="16:30";
    public final LocalTime TIME_16_30=LocalTime.of(16, 30, 00);
    public final String TEXTO_MENSSAGEM="Essa é uma menssagem completa.";
    public final String MIDIA_MENSSAGEM="<Arquivo de mídia oculto>";
    public final String DATA_12_02_21="12/02/2021";
    public final LocalDate DATE_12_02_21=LocalDate.of(2021, 02, 12);
    
    public final String MENSSAGEM_COMPLETA=DATA_11_02_21+" "+HORAS_16_30+" - "+CONTATO_JOAO_SILVA+": "+TEXTO_MENSSAGEM;
    public final String MENSSAGEM_COMPLETA_MARIA=DATA_11_02_21+" "+HORAS_16_30+" - "+CONTATO_MARIA_SOUSA+": "+TEXTO_MENSSAGEM;
    public final String MENSSAGEM_IMCOMPLETA="11/02/2021 16:31 - João Silva: Essa messagem esta imcompleta pois...";
    public final String COMPLEMENTO_MENSSAGEM="... aqui está o complemento da menssagem restante.";
    public final String MENSSAGEM_MIDIA=DATA_11_02_21+" "+HORAS_16_30+" - "+CONTATO_JOAO_SILVA+": "+MIDIA_MENSSAGEM;
    public final String MENSSAGEM_OUTRA_DATA = DATA_12_02_21+" "+HORAS_16_30+" - "+CONTATO_JOAO_SILVA+": "+TEXTO_MENSSAGEM;
    
    
    public final String ICORRETA_MENSSAGEM_SEM_DATA=HORAS_16_30+" - "+CONTATO_JOAO_SILVA+": "+TEXTO_MENSSAGEM;
    public final String ICORRETA_MENSSAGEM_SEM_HORA=DATA_11_02_21+" - "+CONTATO_JOAO_SILVA+": "+TEXTO_MENSSAGEM;
    public final String ICORRETA_MENSSAGEM_SEM_CONTATO=DATA_11_02_21+" "+HORAS_16_30+" - "+TEXTO_MENSSAGEM;
    
    // "Contados", "Interação", "Texto", "Midia"
    public final Object[][] MATRIZ_DADOS_CONVERSA= {{CONTATO_JOAO_SILVA,"3",3*TEXTO_MENSSAGEM.length()+"","0"}};
    
    
      
    public HashMap<String, Pessoa> estruturaDeDadosDaConversaComMenssagemCompleta(){
        String[] textoMenssagens = {TEXTO_MENSSAGEM,TEXTO_MENSSAGEM,TEXTO_MENSSAGEM};
        HashMap<String, Pessoa>  mapaContato = this.geraEstruturaDeDadosPessoaConversa(CONTATO_JOAO_SILVA, DATE_11_02_21, textoMenssagens);
        return mapaContato;
    }
    
    public HashMap<String, Pessoa> estruturaDeDadosDaConversaComMenssagemCompletaEMutiplosContatos(){
        String[] textoMenssagens = {TEXTO_MENSSAGEM,TEXTO_MENSSAGEM,TEXTO_MENSSAGEM};
        HashMap<String, Pessoa>  mapaContato = this.geraEstruturaDeDadosPessoaConversa(CONTATO_JOAO_SILVA, DATE_11_02_21, textoMenssagens);
        HashMap<String, Pessoa>  mapaContatoMaria = this.geraEstruturaDeDadosPessoaConversa(CONTATO_MARIA_SOUSA, DATE_11_02_21, textoMenssagens);
        mapaContato.putAll(mapaContatoMaria);
        return mapaContato;
    }
    
    
    
    public HashMap<String, Pessoa> geraEstruturaDeDadosPessoaConversa(String contato, LocalDate dataConversa, String[] textoMenssagens){
        Pessoa pessoa = new Pessoa(contato,contato);
        Conversa conversa = new Conversa(dataConversa);        
        for(String textoMenssagem:textoMenssagens){
            conversa.setMenssagens(new Menssagem(dataConversa, TIME_16_30, textoMenssagem));
        }        
        pessoa.setConversa(conversa);
        HashMap<String, Pessoa>  mapaContato = new HashMap<>();
        mapaContato.put(pessoa.getContato(), pessoa);
        return mapaContato;
    }
    
    public ConversaT comMenssagemCompletaJoaoMaria(){
        String[] conversaComMenssagensCompletas = {MENSSAGEM_COMPLETA,MENSSAGEM_COMPLETA,MENSSAGEM_COMPLETA,
            MENSSAGEM_COMPLETA_MARIA,MENSSAGEM_COMPLETA_MARIA,MENSSAGEM_COMPLETA_MARIA};
        return new ConversaT(conversaComMenssagensCompletas);
    }
    
    public ConversaT comMenssagemCompleta(){
        String[] conversaComMenssagensCompletas = {MENSSAGEM_COMPLETA,MENSSAGEM_COMPLETA,MENSSAGEM_COMPLETA};
        return new ConversaT(conversaComMenssagensCompletas);
    }
    
    public ConversaT comMenssagemImcompletaNoInicio(){
        String[] conversaComMenssagensImcompletasBruta = {COMPLEMENTO_MENSSAGEM,MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA};
        String[] conversaComMenssagensImcompletasEsperada = {COMPLEMENTO_MENSSAGEM,MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA};
        return new ConversaT(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }
    
    public ConversaT comMenssagemImcompletaNoMeio(){
        String[] conversaComMenssagensImcompletasBruta = {MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA,COMPLEMENTO_MENSSAGEM,MENSSAGEM_COMPLETA};
        String[] conversaComMenssagensImcompletasEsperada = {MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA+COMPLEMENTO_MENSSAGEM,MENSSAGEM_COMPLETA};
        return new ConversaT(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }
    
    public ConversaT comMenssagemImcompletaNoFim(){
        String[] conversaComMenssagensImcompletasBruta = {MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA,COMPLEMENTO_MENSSAGEM};
        String[] conversaComMenssagensImcompletasEsperada = {MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA+COMPLEMENTO_MENSSAGEM};
        return new ConversaT(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }   
    
    public ConversaT comMenssagemImcompletaMultipos(){
        String[] conversaComMenssagensImcompletasBruta = {MENSSAGEM_COMPLETA,
            MENSSAGEM_IMCOMPLETA,COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM,
            MENSSAGEM_IMCOMPLETA,COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM};
        String[] conversaComMenssagensImcompletasEsperada = {MENSSAGEM_COMPLETA,
            MENSSAGEM_IMCOMPLETA+COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM,
            MENSSAGEM_IMCOMPLETA+COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM};
        return new ConversaT(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }  
    
    public ConversaT comMenssagemCompletaDataDiferente(){
        String[] conversaComMenssagensImcompletasBruta = {MENSSAGEM_COMPLETA,MENSSAGEM_COMPLETA,MENSSAGEM_COMPLETA,MENSSAGEM_OUTRA_DATA,MENSSAGEM_OUTRA_DATA};
        String[] conversaComMenssagensImcompletasEsperada = {MENSSAGEM_COMPLETA,MENSSAGEM_COMPLETA,MENSSAGEM_COMPLETA};
        return new ConversaT(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }
    
    
    public ConversaT comComplementosDeMenssagens(){
        String[] conversaComMenssagensImcompletasBruta = {COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM,COMPLEMENTO_MENSSAGEM};
        String[] conversaComMenssagensImcompletasEsperada = {COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM+COMPLEMENTO_MENSSAGEM};
        return new ConversaT(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }
    
    
    
    public List<ConversaT> getTodasConversas(){
        ArrayList<ConversaT> todasConversas = new ArrayList<>();
        todasConversas.add(this.comMenssagemCompleta());
        todasConversas.add(this.comMenssagemImcompletaNoInicio());
        todasConversas.add(this.comMenssagemImcompletaNoMeio());
        todasConversas.add(this.comMenssagemImcompletaNoFim());
        todasConversas.add(this.comMenssagemImcompletaMultipos());
        todasConversas.add(this.comComplementosDeMenssagens());
        return todasConversas;
    }
    
    public ConversaT comMenssagemSuja(){
        String[] conversaComMenssagensImcompletasBruta = {
            "   "+MENSSAGEM_COMPLETA,
            MENSSAGEM_IMCOMPLETA+"\n\n\n\n",
            "\t"+COMPLEMENTO_MENSSAGEM};//,MENSSAGEM_COMPLETA};
        String[] conversaComMenssagensImcompletasEsperada = {MENSSAGEM_COMPLETA,MENSSAGEM_IMCOMPLETA,COMPLEMENTO_MENSSAGEM};//,MENSSAGEM_COMPLETA};
        return new ConversaT(conversaComMenssagensImcompletasBruta,conversaComMenssagensImcompletasEsperada);  
    }
    
    
    
       
        
}

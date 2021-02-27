/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


/**
 *
 * @author Dev
 */
public class ProcessadorConversa {
    
    public List<String> extrairConversas(String conversa){      
        final String quebraLinhaRegex = "\n";
        String[] menssagensConversas = conversa.split(quebraLinhaRegex); 
        ArrayList<String> menssagemCorrigida = new ArrayList<>();
        String menssagemPendente= "";
        for (String menssagensConversa : menssagensConversas) {
            if (esUmaMenssagemDeConversa(menssagensConversa)) {
                menssagemCorrigida.add(menssagemPendente);
                menssagemPendente = menssagensConversa;
            } else {
                menssagemPendente += menssagensConversa; 
            }
        }   
        menssagemCorrigida.add(menssagemPendente);        
        if(menssagemCorrigida.get(0).isBlank()){
            menssagemCorrigida.remove(0);
        }
        return menssagemCorrigida;
    }
    
    public boolean esUmaMenssagemDeConversa(String menssagem){
        final String dataTimeRegex = "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}\\s[0-9]{2}:[0-9]{2}\\s-\\s.*"; 
        return Pattern.matches(dataTimeRegex, menssagem);
    }
    
    
    
    
    
}

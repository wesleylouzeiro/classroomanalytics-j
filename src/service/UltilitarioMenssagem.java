/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;
import model.Menssagem;
import model.Pessoa;

/**
 *
 * @author Dev
 */
public class UltilitarioMenssagem {
    
    public final int DATA=0; 
    public final int HORA=1;
    public final int CONTATO=2;
    public final int MENSSAGEM=3;

    //11/02/2021 16:30 - João Silva: Essa...    
    private final String dataTimeRegex = "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}\\s[0-9]{2}:[0-9]{2}\\s";
    private final String contatoRegex = "-\\s.*:\\s";
    

    public boolean esUmaMenssagemDeConversa(String menssagem) {
        return Pattern.matches(dataTimeRegex +contatoRegex+".*", menssagem);
    }
    
    public String extrairNomeContato(String menssagem){
        return extrairComponenteMenssagem(menssagem)[CONTATO];
    }    

    public Pessoa extrairContato(String menssagem) {
        String contato = extrairNomeContato(menssagem);
        return new Pessoa(contato, contato);
    }
    
    public Menssagem extrairMenssagem(String menssagem){        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate data = LocalDate.parse(extrairComponenteMenssagem(menssagem)[DATA], formato);
        LocalTime hora = LocalTime.parse(extrairComponenteMenssagem(menssagem)[HORA]+":00");
        String texto = extrairComponenteMenssagem(menssagem)[MENSSAGEM];
        return new Menssagem(data,hora,texto);
    }
    

    public String[] extrairComponenteMenssagem(String menssagem) {
        String[] menssagemComponente = {"", "", "", ""};
        if (esUmaMenssagemDeConversa(menssagem)) {
            menssagemComponente = menssagem.split(" ", 4);
            String[] contatoMenssagem = menssagemComponente[3].split(":", 2);
            menssagemComponente[CONTATO] = contatoMenssagem[0];
            menssagemComponente[MENSSAGEM] = contatoMenssagem[1].trim();
        }        
        return menssagemComponente;
    }
    
    public boolean menssagemEstarEntreDatas(String menssagem, LocalDate dataInicio, LocalDate dataFim){
        LocalDate data;
        if(esUmaMenssagemDeConversa(menssagem) ){
            data =  extrairMenssagem(menssagem).getData();
            return  (data.equals(dataInicio) || data.equals(dataFim)) || (data.isAfter(dataInicio)
                && data.isBefore(dataFim));  
        }        
        return false;      
    }    
        

}

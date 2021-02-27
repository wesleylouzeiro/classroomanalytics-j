/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import model.Menssagem;
import model.Pessoa;

/**
 *
 * @author Dev
 */
public class UltilitarioMenssagem {
    
    private final int DATA=0; 
    private final int HORA=1;
    private final int CONTATO=2;
    private final int MENSSAGEM=3;

    //11/02/2021 16:30 - João Silva: Essa...    
    private final String dataTimeRegex = "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}\\s[0-9]{2}:[0-9]{2}\\s-\\s";

    public boolean esUmaMenssagemDeConversa(String menssagem) {
        return Pattern.matches(dataTimeRegex + ".*", menssagem);
    }
    

    public Pessoa extrairContato(String menssagem) {
        String contato = extrairComponenteMenssagem(menssagem)[CONTATO];
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
    
    

}

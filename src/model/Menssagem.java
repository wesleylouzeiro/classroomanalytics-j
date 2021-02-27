/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.Objects;

/**
 *
 * @author Dev
 */
public class Menssagem {
    private final LocalDate data;
    private final LocalTime time;
    private final String menssagens;
    
    
    public Menssagem(LocalDate data, LocalTime time, String menssagens) {
        this.data = data;
        this.time = time;
        this.menssagens = menssagens;
    }

    /**
     * @return the data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * @return the menssagens
     */
    public String getMenssagens() {
        return menssagens;
    }

    /**
     * @return the time
     */
    public LocalTime getTime() {
        return time;
    }
    
    @Override
    public boolean equals(Object obj) {        
        if(obj!=null && obj instanceof Menssagem){
            Menssagem menssagem = (Menssagem) obj;
            return (menssagem.data.equals(this.data) && menssagem.time.equals(this.time) && menssagem.menssagens.equals(this.menssagens));
        }        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.data);
        hash = 19 * hash + Objects.hashCode(this.time);
        hash = 19 * hash + Objects.hashCode(this.menssagens);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder menssagem = new StringBuilder();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        menssagem.append(formato.format(data)).append("")
                .append(this.time.truncatedTo(MINUTES))
                .append(" - : ")
                .append(this.menssagens);                
        return menssagem.toString();
    }
    
    

   
    
}

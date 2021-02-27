/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
}

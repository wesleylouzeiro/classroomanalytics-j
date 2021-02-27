/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Dev
 */
public class Menssagem {
    private final LocalDateTime data;
    private final String menssagens;
    
    
    public Menssagem(LocalDateTime data, String menssagens) {
        this.data = data;
        this.menssagens = menssagens;
    }

    /**
     * @return the data
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * @return the menssagens
     */
    public String getMenssagens() {
        return menssagens;
    }
}

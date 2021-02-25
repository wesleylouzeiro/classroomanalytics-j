/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import javax.swing.filechooser.FileFilter;


/**
 *
 * @author corei
 */
public class SetFileFilter extends FileFilter {
    
    private final String descricao;
    
    private final String extencao;
    
    public SetFileFilter(){
        this.descricao = "Somente arquivo *.txt";
        this.extencao = ".txt";
    }
    
    public SetFileFilter(String descricao, String extencao){
        this.descricao = descricao;
        this.extencao = extencao;
    }
   
    @Override
    public boolean accept(File pathname) {
        return pathname!=null 
                && (pathname.getName().toLowerCase().endsWith(this.extencao)
                || pathname.isDirectory());
    }
    
    @Override
    public String getDescription(){
        return this.descricao;
    }
    
}

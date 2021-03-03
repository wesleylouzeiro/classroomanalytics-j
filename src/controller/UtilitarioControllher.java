/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Pessoa;

/**
 *
 * @author Dev
 */
public class UtilitarioControllher {

    public Object[][] converteListaContatosEmMapaEstaistico(List<Pessoa> listaContatos) {
        Object[][] matrizDados = new Object[listaContatos.size()][4];
        for (int index = 0; index < listaContatos.size(); index++) {
            Pessoa contato = listaContatos.get(index);
            matrizDados[index][0] = contato.getContato();
            matrizDados[index][1] = contato.getResumoConversas().getQuantidadeInteracao() + "";
            matrizDados[index][2] = contato.getResumoConversas().getQuantidadeTexto() + "";
            matrizDados[index][3] = contato.getResumoConversas().getQuantidadeMidia() + "";
        }
        return matrizDados;
    }

    public String[] converteListaStringEmArray(List<String> listaContatos) {
        String[] arrayString = new String[listaContatos.size()];
        for (int index = 0; index < listaContatos.size(); index++) {
            arrayString[index] = listaContatos.get(index);
        }
        return arrayString;
    }

}

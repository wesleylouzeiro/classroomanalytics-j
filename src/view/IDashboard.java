/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Dev
 */
public interface IDashboard {
    public void atualizarCampoEditor(String texto);
    public void atualizarTabelaEstatisticaContatos(Object [][] matrizDeEstatisticaContatos, String[] nomeColunas);
    public void atualizarBotaoFiltro(String[] datas, boolean enable);
}

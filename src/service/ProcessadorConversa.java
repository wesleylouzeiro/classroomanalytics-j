/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import model.Conversa;
import model.Menssagem;
import model.Pessoa;

/**
 *
 * @author Dev
 */
public class ProcessadorConversa {

    UltilitarioMenssagem UltilMsg = new UltilitarioMenssagem();

    public List<String> extrairConversas(String conversa) {
        final String quebraLinhaRegex = "\n";
        String[] menssagensConversas = conversa.split(quebraLinhaRegex);
        ArrayList<String> menssagemCorrigida = new ArrayList<>();
        String menssagemPendente = "";
        for (String menssagensConversa : menssagensConversas) {
            if (UltilMsg.esUmaMenssagemDeConversa(menssagensConversa)) {
                menssagemCorrigida.add(menssagemPendente);
                menssagemPendente = menssagensConversa;
            } else {
                menssagemPendente += menssagensConversa;
            }
        }
        menssagemCorrigida.add(menssagemPendente);
        if (menssagemCorrigida.get(0).isBlank()) {
            menssagemCorrigida.remove(0);
        }
        return menssagemCorrigida;
    }

    public List<String> filtraConversa(List<String> listaConversa, LocalDate data) {
        List<String> listaFiltrada = new ArrayList<>();
        listaConversa.forEach((menssagem) -> {
            if (UltilMsg.esUmaMenssagemDeConversa(menssagem) && UltilMsg.extrairMenssagem(menssagem).getData().equals(data)) {
                listaFiltrada.add(menssagem);
            }
        });
        return listaFiltrada;
    }

    public List<String> recuperaDataConversa(List<String> listaConversa) {
        List<String> listaFiltrada = new ArrayList<>();
        listaConversa.forEach((menssagem) -> {
            if (UltilMsg.esUmaMenssagemDeConversa(menssagem)) {
                String dataMenssagem = UltilMsg.extrairComponenteMenssagem(menssagem)[UltilMsg.DATA];
                if (!listaFiltrada.contains(dataMenssagem)) {
                    listaFiltrada.add(dataMenssagem);
                }
            }
        });
        return listaFiltrada;
    }

    public HashMap<String, Pessoa> estruturaConversas(List<String> listaDeConversas) {
        final HashMap<String, Pessoa> MapaDePessoas = new HashMap<>();
        listaDeConversas.forEach((String menssagem) -> {
            if (UltilMsg.esUmaMenssagemDeConversa(menssagem)) {
                Pessoa pessoa = new Pessoa("", "");
                String contato = UltilMsg.extrairNomeContato(menssagem);
                if (MapaDePessoas.containsKey(contato)) {
                    pessoa = MapaDePessoas.get(contato);
                } else {
                    pessoa = UltilMsg.extrairContato(menssagem);
                    MapaDePessoas.put(contato, pessoa);
                }
                Menssagem atualMenssagem = UltilMsg.extrairMenssagem(menssagem);
                Conversa atualConversa = pessoa.getConversasData(atualMenssagem.getData());
                if (atualConversa == null) {
                    atualConversa = new Conversa(atualMenssagem.getData());
                    atualConversa.setMenssagens(atualMenssagem);
                    pessoa.setConversa(atualConversa);
                } else {
                    pessoa.getConversas().get(pessoa.getConversas().indexOf(atualConversa)).setMenssagens(atualMenssagem);
                }
            }
        });
        return MapaDePessoas;
    }

}

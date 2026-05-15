package com.finquest.api.service;

import com.finquest.api.model.Jogador;
import com.finquest.api.model.Transacao;
import com.finquest.api.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao registrar(Jogador jogador, double valor, String tipo, String descricao){
        Transacao transacao = new Transacao();
        transacao.setJogador(jogador);
        transacao.setValor(valor);
        transacao.setTipo(tipo);
        transacao.setDescricao(descricao);
        transacao.setData(new Date());
        return transacaoRepository.save(transacao);

    }

    public List<Transacao> listarPorJogador(Jogador jogador){
        return transacaoRepository.findByJogador(jogador);

    }
}

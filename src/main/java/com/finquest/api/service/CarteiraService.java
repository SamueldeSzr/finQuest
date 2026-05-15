package com.finquest.api.service;

import com.finquest.api.model.Carteira;
import com.finquest.api.model.Jogador;
import com.finquest.api.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService {
    @Autowired
    private CarteiraRepository carteiraRepository;

    public Carteira criarCarteira(Jogador jogador){
        Carteira carteira = new Carteira();
        carteira.setJogador(jogador);
        return carteiraRepository.save(carteira);

    }

    public Carteira buscarPorJogador(Jogador jogador) {
        return carteiraRepository.findByJogador(jogador)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada"));
    }

    public Carteira adicionarCredito(Jogador jogador, double valor){
        Carteira carteira = buscarPorJogador(jogador);
        carteira.setCreditosGanhos(carteira.getCreditosGanhos()+valor);
        carteira.setCreditosTotais(carteira.getCreditosTotais()+valor);
        return carteiraRepository.save(carteira);
    }

    public Carteira debitarCredito(Jogador jogador, double valor){
        Carteira carteira = buscarPorJogador(jogador);
        if(carteira.getCreditosTotais()<valor){
            throw new RuntimeException("saldo induficiente");
        } else{
        carteira.setCreditosGastos(carteira.getCreditosGastos()+ valor);
        carteira.setCreditosTotais(carteira.getCreditosTotais()- valor);
        return carteiraRepository.save(carteira);
        }
    }
}

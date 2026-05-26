package com.finquest.api.service;

import com.finquest.api.model.Questao;
import com.finquest.api.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    @Autowired
    private JogadorService jogadorService;

    public Questao cadastrar(Questao questao) {
        return questaoRepository.save(questao);
    }

    public List<Questao> listarTodas() {
        return questaoRepository.findAll();
    }

    public List<Questao> listarPorLicao(Long licaoId) {
        return questaoRepository.findByLicaoId(licaoId);
    }

    public Optional<Questao> buscarPorId(Long id) {
        return questaoRepository.findById(id);
    }

    public boolean verificarResposta(Long questaoId, Long jogadorId, String respostaInformada) {
        Questao questao = questaoRepository.findById(questaoId)
                .orElseThrow(() -> new RuntimeException("Questão não encontrada"));

        boolean correta = questao.getRespostaCorreta().equalsIgnoreCase(respostaInformada);

        if (correta) {
            jogadorService.darXp(jogadorId, questao.getXpRecompensa());
        }

        return correta;
    }

    public void deletar(Long id) {
        questaoRepository.deleteById(id);
    }
}
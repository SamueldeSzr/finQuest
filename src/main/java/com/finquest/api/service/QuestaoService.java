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

    public boolean verificarResposta(Long id, String respostaInformada) {
        Questao questao = questaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Questão não encontrada"));
        return questao.getRespostaCorreta().equalsIgnoreCase(respostaInformada);
    }

    public void deletar(Long id) {
        questaoRepository.deleteById(id);
    }
}

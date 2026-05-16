package com.finquest.api.service;

import com.finquest.api.model.Objetivo;
import com.finquest.api.repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetivoService {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    public Objetivo cadastrar(Objetivo objetivo) {
        return objetivoRepository.save(objetivo);
    }

    public List<Objetivo> listarTodos() {
        return objetivoRepository.findAll();
    }

    public List<Objetivo> listarPorJogador(Long jogadorId) {
        return objetivoRepository.findByJogadorId(jogadorId);
    }

    public List<Objetivo> listarPorJogadorEStatus(Long jogadorId, boolean concluido) {
        return objetivoRepository.findByJogadorIdAndConcluido(jogadorId, concluido);
    }

    public Optional<Objetivo> buscarPorId(Long id) {
        return objetivoRepository.findById(id);
    }

    public Objetivo atualizarValorAtual(Long id, Double novoValor) {
        Objetivo objetivo = objetivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objetivo não encontrado"));
        objetivo.setValorAtual(novoValor);
        if (novoValor >= objetivo.getValorMeta()) {
            objetivo.concluir();
        }
        return objetivoRepository.save(objetivo);
    }

    public void deletar(Long id) {
        objetivoRepository.deleteById(id);
    }
}

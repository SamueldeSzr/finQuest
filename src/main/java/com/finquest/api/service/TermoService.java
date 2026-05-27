package com.finquest.api.service;

import com.finquest.api.model.Termo;
import com.finquest.api.repository.TermoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TermoService {

    @Autowired
    private TermoRepository termoRepository;

    public Termo cadastrar(Termo termo) {
        return termoRepository.save(termo);
    }

    public List<Termo> listarPorLicao(Long licaoId) {
        return termoRepository.findByLicaoIdOrderByOrdem(licaoId);
    }

    public Optional<Termo> buscarPorId(Long id) {
        return termoRepository.findById(id);
    }

    public void deletar(Long id) {
        termoRepository.deleteById(id);
    }
}

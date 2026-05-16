package com.finquest.api.service;

import com.finquest.api.model.Conquista;
import com.finquest.api.repository.ConquistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConquistaService {

    @Autowired
    private ConquistaRepository conquistaRepository;

    public Conquista conceder(Conquista conquista) {
        return conquistaRepository.save(conquista);
    }

    public List<Conquista> listarTodas() {
        return conquistaRepository.findAll();
    }

    public List<Conquista> listarPorJogador(Long jogadorId) {
        return conquistaRepository.findByJogadorId(jogadorId);
    }

    public Optional<Conquista> buscarPorId(Long id) {
        return conquistaRepository.findById(id);
    }

    public void deletar(Long id) {
        conquistaRepository.deleteById(id);
    }
}

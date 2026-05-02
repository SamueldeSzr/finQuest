package com.finquest.api.service;

import com.finquest.api.model.Licao;
import com.finquest.api.repository.LicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicaoService {

    @Autowired
    private LicaoRepository licaoRepository;

    public Licao cadastrar(Licao licao) {
        return licaoRepository.save(licao);
    }

    public List<Licao> listarTodos() {
        return licaoRepository.findAll();
    }

    public Optional<Licao> buscarPorId(Long id) {
        return licaoRepository.findById(id);
    }

    public void deletar(Long id) {
        licaoRepository.deleteById(id);
    }


}
package com.finquest.api.service;

import com.finquest.api.model.Nivel;
import com.finquest.api.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelService {

    @Autowired
    private NivelRepository nivelRepository;

    public Nivel cadastrar(Nivel nivel) {
        return nivelRepository.save(nivel);
    }

    public List<Nivel> listarTodos() {
        return nivelRepository.findAll();
    }

    public Optional<Nivel> buscarPorId(Long id) {
        return nivelRepository.findById(id);
    }

    public void deletar(Long id) {
        nivelRepository.deleteById(id);
    }
}
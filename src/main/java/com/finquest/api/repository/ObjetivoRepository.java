package com.finquest.api.repository;

import com.finquest.api.model.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Long> {
    List<Objetivo> findByJogadorId(Long jogadorId);
    List<Objetivo> findByJogadorIdAndConcluido(Long jogadorId, boolean concluido);
}

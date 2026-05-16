package com.finquest.api.repository;

import com.finquest.api.model.Conquista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConquistaRepository extends JpaRepository<Conquista, Long> {
    List<Conquista> findByJogadorId(Long jogadorId);
}

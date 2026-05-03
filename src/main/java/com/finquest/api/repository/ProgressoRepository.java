package com.finquest.api.repository;

import com.finquest.api.model.Progresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressoRepository extends JpaRepository<Progresso, Long> {
    List<Progresso> findByJogadorId(Long jogadorId);
    Optional<Progresso> findByJogadorIdAndLicaoId(Long jogadorId, Long licaoId);
    boolean existsByJogadorIdAndLicaoIdAndConcluidaTrue(Long jogadorId, Long licaoId);
}
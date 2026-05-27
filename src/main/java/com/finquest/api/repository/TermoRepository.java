package com.finquest.api.repository;

import com.finquest.api.model.Termo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TermoRepository extends JpaRepository<Termo, Long> {
    List<Termo> findByLicaoIdOrderByOrdem(Long licaoId);
}

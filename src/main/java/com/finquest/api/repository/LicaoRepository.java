package com.finquest.api.repository;

import com.finquest.api.model.Licao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicaoRepository extends JpaRepository<Licao, Long> {
    List<Licao> findByNivelId(Long nivelId); // usado no Service
}
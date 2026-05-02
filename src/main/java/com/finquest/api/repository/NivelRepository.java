package com.finquest.api.repository;

import com.finquest.api.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {
    // vazio
}
package com.finquest.api.repository;

import com.finquest.api.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador,Long> {
    Optional<Jogador> findByEmail(String email);
}

package com.finquest.api.repository;

import com.finquest.api.model.Carteira;
import com.finquest.api.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira,Long> {
    Optional<Carteira> findByJogador(Jogador jogador);

}

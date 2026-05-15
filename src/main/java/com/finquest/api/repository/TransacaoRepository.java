package com.finquest.api.repository;

import com.finquest.api.model.Jogador;
import com.finquest.api.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
    List<Transacao> findByJogador(Jogador jogador);


}

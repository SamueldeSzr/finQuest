package com.finquest.api.service;

import com.finquest.api.model.Progresso;
import com.finquest.api.repository.ProgressoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProgressoService {

    @Autowired
    private ProgressoRepository progressoRepository;

    // Registrar ou atualizar progresso de uma lição para um jogador
    public Progresso salvar(Progresso progresso) {
        return progressoRepository.save(progresso);
    }

    // Marcar uma lição como concluída para um jogador
    public Progresso concluirLicao(Long jogadorId, Long licaoId, Integer pontuacao) {
        Optional<Progresso> existente = progressoRepository.findByJogadorIdAndLicaoId(jogadorId, licaoId);
        Progresso progresso;
        if (existente.isPresent()) {
            progresso = existente.get();
        } else {
            progresso = new Progresso();
            progresso.setJogadorId(jogadorId);
            progresso.setLicaoId(licaoId);
        }
        progresso.setConcluida(true);
        progresso.setPontuacao(pontuacao);
        progresso.setDataConclusao(java.time.LocalDateTime.now());
        return progressoRepository.save(progresso);
    }

    // Verificar se uma lição já foi concluída pelo jogador
    public boolean isLicaoConcluida(Long jogadorId, Long licaoId) {
        return progressoRepository.existsByJogadorIdAndLicaoIdAndConcluidaTrue(jogadorId, licaoId);
    }

    // Listar todas as lições concluídas por um jogador (retorna apenas os registros de progresso)
    public List<Progresso> listarProgressoPorJogador(Long jogadorId) {
        return progressoRepository.findByJogadorId(jogadorId);
    }

    // Buscar progresso específico de uma lição
    public Optional<Progresso> buscarPorJogadorELicao(Long jogadorId, Long licaoId) {
        return progressoRepository.findByJogadorIdAndLicaoId(jogadorId, licaoId);
    }

    // Deletar um registro de progresso (caso necessário)
    public void deletar(Long id) {
        progressoRepository.deleteById(id);
    }
}
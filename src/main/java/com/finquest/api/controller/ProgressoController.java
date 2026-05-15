package com.finquest.api.controller;

import com.finquest.api.model.Progresso;
import com.finquest.api.service.ProgressoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/progresso")
public class ProgressoController {

    @Autowired
    private ProgressoService progressoService;

    // Endpoint para marcar lição como concluída
    @PostMapping("/concluir")
    public ResponseEntity<Progresso> concluirLicao(@RequestBody Map<String, Object> payload) {
        // Espera JSON com { "jogadorId": 1, "licaoId": 5, "pontuacao": 100 }
        Long jogadorId = Long.valueOf(payload.get("jogadorId").toString());
        Long licaoId = Long.valueOf(payload.get("licaoId").toString());
        Integer pontuacao = payload.containsKey("pontuacao") ? (Integer) payload.get("pontuacao") : null;
        Progresso progresso = progressoService.concluirLicao(jogadorId, licaoId, pontuacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(progresso);
    }

    // Verificar se uma lição foi concluída
    @GetMapping("/verificar")
    public ResponseEntity<Boolean> verificarConclusao(@RequestParam Long jogadorId, @RequestParam Long licaoId) {
        boolean concluida = progressoService.isLicaoConcluida(jogadorId, licaoId);
        return ResponseEntity.ok(concluida);
    }

    // Listar todo o progresso de um jogador
    @GetMapping("/jogador/{jogadorId}")
    public ResponseEntity<List<Progresso>> listarProgressoPorJogador(@PathVariable Long jogadorId) {
        List<Progresso> progressos = progressoService.listarProgressoPorJogador(jogadorId);
        return ResponseEntity.ok(progressos);
    }

    // Buscar progresso específico de uma lição para um jogador
    @GetMapping("/jogador/{jogadorId}/licao/{licaoId}")
    public ResponseEntity<Progresso> buscarProgresso(@PathVariable Long jogadorId, @PathVariable Long licaoId) {
        return progressoService.buscarPorJogadorELicao(jogadorId, licaoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // (Opcional) Deletar um registro de progresso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        progressoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
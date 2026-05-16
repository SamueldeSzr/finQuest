package com.finquest.api.controller;

import com.finquest.api.model.Objetivo;
import com.finquest.api.service.ObjetivoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    @Autowired
    private ObjetivoService objetivoService;

    @PostMapping
    public ResponseEntity<Objetivo> cadastrar(@RequestBody @Valid Objetivo objetivo) {
        Objetivo novo = objetivoService.cadastrar(objetivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Objetivo>> listarTodos() {
        return ResponseEntity.ok(objetivoService.listarTodos());
    }

    @GetMapping("/jogador/{jogadorId}")
    public ResponseEntity<List<Objetivo>> listarPorJogador(@PathVariable Long jogadorId) {
        return ResponseEntity.ok(objetivoService.listarPorJogador(jogadorId));
    }

    @GetMapping("/jogador/{jogadorId}/status")
    public ResponseEntity<List<Objetivo>> listarPorStatus(
            @PathVariable Long jogadorId,
            @RequestParam boolean concluido) {
        return ResponseEntity.ok(objetivoService.listarPorJogadorEStatus(jogadorId, concluido));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Objetivo> buscarPorId(@PathVariable Long id) {
        return objetivoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/valor")
    public ResponseEntity<Objetivo> atualizarValor(
            @PathVariable Long id,
            @RequestBody Map<String, Double> payload) {
        Double novoValor = payload.get("valorAtual");
        Objetivo atualizado = objetivoService.atualizarValorAtual(id, novoValor);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        objetivoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

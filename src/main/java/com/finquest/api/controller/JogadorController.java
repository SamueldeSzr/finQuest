package com.finquest.api.controller;

import com.finquest.api.dto.JogadorResponse;
import com.finquest.api.model.Jogador;
import com.finquest.api.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping("/cadastrar")
    public ResponseEntity<JogadorResponse> cadastrar(@RequestBody @Valid Jogador jogador) {
        Jogador novo = jogadorService.cadastrar(jogador);
        JogadorResponse response = new JogadorResponse(
                novo.getId(), novo.getNomePlayer(), novo.getEmail(),
                novo.getNivelAtual(), novo.getXpPlayer(), novo.getVidasJogador()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<JogadorResponse>> listarTodos() {
        List<Jogador> jogadores = jogadorService.listarTodos();
        List<JogadorResponse> response = jogadores.stream()
                .map(j -> new JogadorResponse(j.getId(), j.getNomePlayer(), j.getEmail(),
                        j.getNivelAtual(), j.getXpPlayer(), j.getVidasJogador()))
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorResponse> buscarPorId(@PathVariable Long id) {
        return jogadorService.buscarPorId(id)
                .map(j -> new JogadorResponse(j.getId(), j.getNomePlayer(), j.getEmail(),
                        j.getNivelAtual(), j.getXpPlayer(), j.getVidasJogador()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        jogadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
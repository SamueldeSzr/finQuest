package com.finquest.api.controller;

import com.finquest.api.model.Conquista;
import com.finquest.api.service.ConquistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conquistas")
public class ConquistaController {

    @Autowired
    private ConquistaService conquistaService;

    @PostMapping
    public ResponseEntity<Conquista> conceder(@RequestBody @Valid Conquista conquista) {
        Conquista nova = conquistaService.conceder(conquista);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Conquista>> listarTodas() {
        return ResponseEntity.ok(conquistaService.listarTodas());
    }

    @GetMapping("/jogador/{jogadorId}")
    public ResponseEntity<List<Conquista>> listarPorJogador(@PathVariable Long jogadorId) {
        return ResponseEntity.ok(conquistaService.listarPorJogador(jogadorId));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Conquista> buscarPorId(@PathVariable Long id) {
        return conquistaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        conquistaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

package com.finquest.api.controller;

import com.finquest.api.model.Termo;
import com.finquest.api.service.TermoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/termos")
public class TermoController {

    @Autowired
    private TermoService termoService;

    @PostMapping
    public ResponseEntity<Termo> cadastrar(@RequestBody @Valid Termo termo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(termoService.cadastrar(termo));
    }

    @GetMapping("/licao/{licaoId}")
    public ResponseEntity<List<Termo>> listarPorLicao(@PathVariable Long licaoId) {
        return ResponseEntity.ok(termoService.listarPorLicao(licaoId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Termo> buscarPorId(@PathVariable Long id) {
        return termoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        termoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

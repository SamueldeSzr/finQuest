package com.finquest.api.controller;

import com.finquest.api.model.Licao;
import com.finquest.api.service.LicaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licoes")
public class LicaoController {

    @Autowired
    private LicaoService licaoService;

    @PostMapping
    public ResponseEntity<Licao> cadastrar(@RequestBody @Valid Licao licao) {
        Licao novo = licaoService.cadastrar(licao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping
    public ResponseEntity<List<Licao>> listarTodos() {
        List<Licao> licoes = licaoService.listarTodos();
        return ResponseEntity.ok(licoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Licao> buscarPorId(@PathVariable Long id) {
        return licaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        licaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}

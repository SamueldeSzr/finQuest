package com.finquest.api.controller;

import com.finquest.api.model.Nivel;
import com.finquest.api.service.NivelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveis")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @PostMapping
    public ResponseEntity<Nivel> cadastrar(@RequestBody @Valid Nivel nivel) {
        Nivel novo = nivelService.cadastrar(nivel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Nivel>> listarTodos() {
        List<Nivel> niveis = nivelService.listarTodos();
        return ResponseEntity.ok(niveis);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Nivel> buscarPorId(@PathVariable Long id) {
        return nivelService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        nivelService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
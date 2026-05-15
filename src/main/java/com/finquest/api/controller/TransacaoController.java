package com.finquest.api.controller;

import com.finquest.api.model.Transacao;
import com.finquest.api.service.JogadorService;
import com.finquest.api.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;
    @Autowired
    private JogadorService jogadorService;

    @PostMapping("/registrar/{jogadorId}")
    public ResponseEntity<Transacao> registar(
            @PathVariable Long jogadorId,
            @RequestParam double valor,
            @RequestParam String tipo,
            @RequestParam String descricao
    ){
        return jogadorService.buscarPorId(jogadorId)
                .map(jogador -> ResponseEntity.ok(transacaoService.registrar(jogador, valor, tipo, descricao)))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/{jogadorId}")
    public ResponseEntity<List<Transacao>> listar(@PathVariable Long jogadorId){
        return jogadorService.buscarPorId(jogadorId)
                .map(jogador -> ResponseEntity.ok(transacaoService.listarPorJogador(jogador)))
                .orElse(ResponseEntity.notFound().build());
    }
}

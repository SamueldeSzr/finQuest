package com.finquest.api.controller;

import com.finquest.api.model.Carteira;
import com.finquest.api.service.CarteiraService;
import com.finquest.api.service.JogadorService;
import com.finquest.api.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {
    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private JogadorService jogadorService;
    @Autowired
    private CarteiraService carteiraService;

    @PostMapping("/criar/{jogadorId}")
    public ResponseEntity<Carteira> criar(@PathVariable long jogadorId){
        return jogadorService.buscarPorId(jogadorId)
                .map(jogador -> ResponseEntity.ok(carteiraService.criarCarteira(jogador)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{jogadorId}")
    public ResponseEntity<Carteira> buscar(@PathVariable long jogadorId){
        return jogadorService.buscarPorId(jogadorId)
                .map(jogador -> ResponseEntity.ok(carteiraService.buscarPorJogador(jogador)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/adicionar/{jogadorId}")
    public ResponseEntity<Carteira> adicionar(@PathVariable long jogadorId, @RequestParam double valor){
        return jogadorService.buscarPorId(jogadorId)
                .map(jogador -> ResponseEntity.ok(carteiraService.adicionarCredito(jogador, valor)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/debitar/{jogadorId}")
    public ResponseEntity<Carteira>  debitar(@PathVariable long jogadorId, @RequestParam double valor){
        return jogadorService.buscarPorId(jogadorId)
                .map(jogador -> ResponseEntity.ok(carteiraService.debitarCredito(jogador, valor)))
                .orElse(ResponseEntity.notFound().build());
    }

}

package com.finquest.api.controller;

import com.finquest.api.model.Questao;
import com.finquest.api.service.QuestaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @PostMapping
    public ResponseEntity<Questao> cadastrar(@RequestBody @Valid Questao questao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questaoService.cadastrar(questao));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Questao>> listarTodas() {
        return ResponseEntity.ok(questaoService.listarTodas());
    }

    @GetMapping("/licao/{licaoId}")
    public ResponseEntity<List<Questao>> listarPorLicao(@PathVariable Long licaoId) {
        return ResponseEntity.ok(questaoService.listarPorLicao(licaoId));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Questao> buscarPorId(@PathVariable Long id) {
        return questaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/responder")
    public ResponseEntity<Map<String, Object>> responder(
            @PathVariable Long id,
            @RequestBody Map<String, Object> payload) {

        Long jogadorId = Long.valueOf(payload.get("jogadorId").toString());
        String resposta = payload.get("resposta").toString();

        boolean correta = questaoService.verificarResposta(id, jogadorId, resposta);

        return ResponseEntity.ok(Map.of(
                "correta", correta,
                "mensagem", correta ? "Resposta correta! XP adicionado." : "Resposta errada. Tente novamente."
        ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        questaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
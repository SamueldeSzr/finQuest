package com.finquest.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "progressos")
public class Progresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O ID do jogador é obrigatório")
    private Long jogadorId;

    @NotNull(message = "O ID da lição é obrigatório")
    private Long licaoId;

    private boolean concluida = false;

    private Integer pontuacao; // opcional: nota/score do jogador na lição

    private LocalDateTime dataConclusao;

    // Método auxiliar para marcar como concluída agora
    public void marcarConcluida() {
        this.concluida = true;
        this.dataConclusao = LocalDateTime.now();
    }
}

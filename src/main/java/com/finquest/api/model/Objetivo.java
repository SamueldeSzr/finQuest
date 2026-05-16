package com.finquest.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "objetivos")
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @NotNull(message = "O ID do jogador é obrigatório")
    private Long jogadorId;

    @NotNull(message = "O valor meta é obrigatório")
    private Double valorMeta;

    private Double valorAtual = 0.0;

    private boolean concluido = false;

    private LocalDate prazo;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private LocalDateTime dataConclusao;

    public void concluir() {
        this.concluido = true;
        this.dataConclusao = LocalDateTime.now();
    }
}

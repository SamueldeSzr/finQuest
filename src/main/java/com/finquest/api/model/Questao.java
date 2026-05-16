package com.finquest.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "questoes")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O enunciado é obrigatório")
    @Column(columnDefinition = "TEXT")
    private String enunciado;

    @NotBlank(message = "A alternativa A é obrigatória")
    private String alternativaA;

    @NotBlank(message = "A alternativa B é obrigatória")
    private String alternativaB;

    private String alternativaC;

    private String alternativaD;

    @NotBlank(message = "A resposta correta é obrigatória")
    private String respostaCorreta; // "A", "B", "C" ou "D"

    @NotNull(message = "O ID da lição é obrigatório")
    private Long licaoId;

    private Integer xpRecompensa = 10;
}

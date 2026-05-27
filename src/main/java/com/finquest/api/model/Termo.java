package com.finquest.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "termos")
public class Termo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do termo é obrigatório")
    private String nome;

    @NotBlank(message = "A definição é obrigatória")
    @Column(columnDefinition = "TEXT")
    private String definicao;

    @Column(columnDefinition = "TEXT")
    private String exemplo;

    @NotNull(message = "O ID da lição é obrigatório")
    private Long licaoId;

    private Integer ordem = 0;
}

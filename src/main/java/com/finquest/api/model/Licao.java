package com.finquest.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "licoes")
public class Licao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String conteudo;

    @NotNull(message = "A ordem no nível é obrigatória")
    private Integer ordemNoNivel;

    @NotNull(message = "O ID do nível é obrigatório")
    private Long nivelId;
}
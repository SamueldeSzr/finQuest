package com.finquest.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "conquistas")
public class Conquista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String icone;

    private Integer xpRecompensa = 0;

    @NotNull(message = "O ID do jogador é obrigatório")
    private Long jogadorId;

    private LocalDateTime dataObtida = LocalDateTime.now();
}

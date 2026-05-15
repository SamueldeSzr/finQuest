package com.finquest.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "transacoes")
public class Transacao {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double valor;

    @NotBlank
    private String tipo;

    @NotBlank
    private String descricao;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "jogador_id")
    private Jogador jogador;
}

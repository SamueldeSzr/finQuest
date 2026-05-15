package com.finquest.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="carteiras")
public class Carteira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double creditosGanhos = 0.0;
    private double creditosGastos = 0.0;
    private double creditosTotais = 0.0;

    @OneToOne
    @JoinColumn(name = "jogador_id")
    private Jogador jogador;
}

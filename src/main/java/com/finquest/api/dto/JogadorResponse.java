package com.finquest.api.dto;

public record JogadorResponse(
        Long id,
        String nomePlayer,
        String email,
        int nivelAtual,
        int xpPlayer,
        int vidasJogador
) {}
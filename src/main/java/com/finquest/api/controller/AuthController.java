package com.finquest.api.controller;

import com.finquest.api.dto.LoginRequest;
import com.finquest.api.model.Jogador;
import com.finquest.api.security.JwtUtil;
import com.finquest.api.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JogadorService jogadorService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha())
            );

            String token = jwtUtil.gerarToken(request.getEmail());

            Optional<Jogador> jogadorOpt = jogadorService.buscarPorEmail(request.getEmail());
            if (jogadorOpt.isPresent()) {
                Jogador j = jogadorOpt.get();
                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("id", j.getId());
                response.put("nomePlayer", j.getNomePlayer());
                response.put("email", j.getEmail());
                response.put("nivelAtual", j.getNivelAtual());
                response.put("xpPlayer", j.getXpPlayer());
                response.put("vidasJogador", j.getVidasJogador());
                return ResponseEntity.ok(response);
            }

            // Fallback: só o token (não deve acontecer se o utilizador existe)
            Map<String, String> fallback = new HashMap<>();
            fallback.put("token", token);
            return ResponseEntity.ok(fallback);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }
}

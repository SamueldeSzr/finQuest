package com.finquest.api.service;

import com.finquest.api.model.Jogador;
import com.finquest.api.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Jogador cadastrar(Jogador jogador){
        String senhaCriptografada = passwordEncoder.encode(jogador.getSenha());
        jogador.setSenha(senhaCriptografada);
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarTodos(){
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> buscarPorId(Long id){
        return jogadorRepository.findById(id);
    }

    public Optional<Jogador> buscarPorEmail(String email){
        return jogadorRepository.findByEmail(email);
    }

    public void deletar(Long id){
        jogadorRepository.deleteById(id);
    }


}

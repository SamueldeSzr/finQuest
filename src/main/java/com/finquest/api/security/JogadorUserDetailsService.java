package com.finquest.api.security;

import com.finquest.api.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JogadorUserDetailsService implements UserDetailsService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return jogadorRepository.findByEmail(email)
                .map(JogadorUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Jogador não encontrado: " + email));
    }
}
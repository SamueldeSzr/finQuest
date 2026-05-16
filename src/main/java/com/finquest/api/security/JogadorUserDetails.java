package com.finquest.api.security;

import com.finquest.api.model.Jogador;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class JogadorUserDetails implements UserDetails {

    private final Jogador jogador;

    public JogadorUserDetails(Jogador jogador) {
        this.jogador = jogador;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // Adicione roles se necessário
    }

    @Override
    public String getPassword() {
        return jogador.getSenha();
    }

    @Override
    public String getUsername() {
        return jogador.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
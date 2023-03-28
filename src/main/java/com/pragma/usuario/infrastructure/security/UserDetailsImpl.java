package com.pragma.usuario.infrastructure.security;

import com.pragma.usuario.domain.model.UserModel;
import com.pragma.usuario.infrastructure.out.jpa.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final UserModel userModel;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userModel.getRol().getNombreRol()));
    }

    @Override
    public String getPassword() {
        return userModel.getClave();
    }

    @Override
    public String getUsername() {
        return userModel.getCorreo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre(){
        return userModel.getNombre();
    }
    public Long getid(){
        return userModel.getId();
    }

}

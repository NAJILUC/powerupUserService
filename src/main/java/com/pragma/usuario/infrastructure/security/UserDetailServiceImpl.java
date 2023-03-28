package com.pragma.usuario.infrastructure.security;

import com.pragma.usuario.domain.model.UserModel;
import com.pragma.usuario.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.usuario.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.usuario.infrastructure.out.jpa.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {


    private IUserRepository userRepository;
    private IUserEntityMapper userEntityMapper;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository
                .findOneByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("No existe usuario con el correo" + correo));
        UserModel userModel = userEntityMapper.toUserModel(userEntity);
        return new UserDetailsImpl(userModel);
    }
}

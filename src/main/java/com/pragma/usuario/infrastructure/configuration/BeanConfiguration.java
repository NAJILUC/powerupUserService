package com.pragma.usuario.infrastructure.configuration;

import com.pragma.usuario.domain.api.IRolServicePort;
import com.pragma.usuario.domain.api.IUserServicePort;
import com.pragma.usuario.domain.spi.IRolPersistencePort;
import com.pragma.usuario.domain.spi.IUserPersistencePort;
import com.pragma.usuario.domain.spi.feignClient.IUserFeignClientPort;
import com.pragma.usuario.domain.spi.token.IToken;
import com.pragma.usuario.domain.usecase.RolUseCase;
import com.pragma.usuario.domain.usecase.UserUseCase;
import com.pragma.usuario.infrastructure.out.jpa.adapter.RolJpaAdapter;
import com.pragma.usuario.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.pragma.usuario.infrastructure.out.jpa.feignclients.UserFeignClient;
import com.pragma.usuario.infrastructure.out.jpa.feignclients.adapter.UserFeignAdapter;
import com.pragma.usuario.infrastructure.out.jpa.mapper.IRolEntityMapper;
import com.pragma.usuario.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.usuario.infrastructure.out.jpa.repository.IRolRepository;
import com.pragma.usuario.infrastructure.out.jpa.repository.IUserRepository;
import com.pragma.usuario.infrastructure.out.jpa.token.TokenAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRolRepository rolRepository;
    private final IRolEntityMapper rolEntityMapper;
    private final UserFeignClient userFeignClient;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(),token());
    }


    @Bean
    public IRolPersistencePort rolPersistencePort() {
        return new RolJpaAdapter(rolRepository, rolEntityMapper);
    }

    @Bean
    public IRolServicePort rolServicePort() {
        return new RolUseCase(rolPersistencePort());
    }


    @Bean
    public IUserFeignClientPort userFeignClientPort() {
        return new UserFeignAdapter(userFeignClient);
    }

    @Bean
    public IToken token(){return new TokenAdapter();
    }
}
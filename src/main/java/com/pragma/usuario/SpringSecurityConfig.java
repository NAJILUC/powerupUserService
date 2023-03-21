package com.pragma.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = passwordEncoder;
        UserDetails user = User.builder().passwordEncoder(encoder::encode)
                .username("administrador").password("12345").roles("ADMINISTRADOR")
                .username("propietario").password("12345").roles("PROPIETARIO")
                .username("empleado").password("12345").roles("EMPLEADO")
                .username("cliente").password("12345").roles("CLIENTE")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
/*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder)throws Exception{

        PasswordEncoder encoder = passwordEncoder;
        User.UserBuilder users = User .builder().passwordEncoder(encoder::encode);

        builder.inMemoryAuthentication()
                .withUser(users.username("administrador").password("12345").roles("ADMINISTRADOR"))
                .withUser(users.username("propietario").password("12345").roles("PROPIETARIO"))
                .withUser(users.username("empleado").password("12345").roles("EMPLEADO"))
                .withUser(users.username("cliente").password("12345").roles("CLIENTE"));
    }*/

}

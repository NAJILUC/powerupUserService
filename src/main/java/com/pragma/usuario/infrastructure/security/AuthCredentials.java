package com.pragma.usuario.infrastructure.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class AuthCredentials {
    private String correo;
    private String clave;
}

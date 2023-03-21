package com.pragma.usuario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private Long id;
    private String nombre;
    private String apellido;
    private Long documento;
    private String celular;
    private String correo;
    private String clave;
    private RolModel rol;


}

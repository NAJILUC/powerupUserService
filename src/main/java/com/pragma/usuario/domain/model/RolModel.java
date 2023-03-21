package com.pragma.usuario.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolModel {


    private Long id;

    private String nombreRol;

    private String descripcionRol;
}

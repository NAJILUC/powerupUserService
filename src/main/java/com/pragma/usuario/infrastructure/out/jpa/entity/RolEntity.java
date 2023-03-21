package com.pragma.usuario.infrastructure.out.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rolTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RolEntity {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(length = 50)
    private String nombreRol;

    @Column(length = 50)
    private String descripcionRol;

}

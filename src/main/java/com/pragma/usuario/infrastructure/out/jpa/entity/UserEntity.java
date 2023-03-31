package com.pragma.usuario.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "userTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 45)
    private String apellido;

    @Min(value = 1)
    @Column(length = 45)
    private Long documento;

    @Column(length = 15)
    private String celular;

    @Column(length = 45)
    private String correo;

    @Column(length = 100)
    private String clave;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity rol;
}

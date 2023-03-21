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

    @NotBlank(message = "El nombre es obligatorio")
    @Column(length = 50)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(length = 45)
    private String apellido;

    @NotNull(message = "El documento de identida es obligatorio")
    @Min(value = 1)
    @Column(length = 45)
    private Long documento;

    @NotBlank(message = "El celular es obligatorio")
    @Pattern(regexp = "^\\+?\\d{10,12}$", message = "Ingrese un numero celular valido")
    @Column(length = 15)
    private String celular;

    @Email(message = "Ingrese un correo valido")
    @NotBlank(message = "El correo es obligatorio")
    @Column(length = 45)
    private String correo;

    @NotBlank(message = "La clave es obligatoria")
    @Column(length = 100)
    private String clave;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity rol;
}

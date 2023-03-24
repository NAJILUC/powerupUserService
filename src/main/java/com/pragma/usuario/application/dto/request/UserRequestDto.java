package com.pragma.usuario.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserRequestDto {

    @NotEmpty(message = "El nombre es obligatorio")
    private String nombre;
    @NotEmpty(message = "El apellido es obligatorio")
    private String apellido;
    @NotNull(message = "El documento es obligatorio")
    private Long documento;
    @NotEmpty(message = "El celular es obligatorio")
    @Pattern(regexp = "^\\+?\\d{10,12}$", message = "Ingrese un numero celular valido")
    private String celular;
    @NotEmpty(message = "El correo es obligatorio")
    @Email(message = "Ingrese un correo valido")
    private String correo;
    @NotEmpty(message = "La clave es obligatoria")
    private String clave;
    private Long rol;
}

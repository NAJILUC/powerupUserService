package com.pragma.usuario.application.handler;

import com.pragma.usuario.application.dto.request.UserRequestDto;
import com.pragma.usuario.application.dto.request.UserRequestDtoD;
import com.pragma.usuario.application.dto.response.UserResponseDto;

import java.util.List;

public interface IUserHandler {

    void saveUser(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUsers();

    void deleteUser(UserRequestDtoD userRequestDtoD);

    UserResponseDto getUserById(Long id);

    Boolean userOwnerExist(Long id);

    UserResponseDto getUserByEmail(String correo);

}
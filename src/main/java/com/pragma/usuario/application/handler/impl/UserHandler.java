package com.pragma.usuario.application.handler.impl;

import com.pragma.usuario.application.dto.request.UserRequestDto;
import com.pragma.usuario.application.dto.request.UserRequestDtoD;
import com.pragma.usuario.application.dto.response.UserResponseDto;
import com.pragma.usuario.application.handler.IUserHandler;
import com.pragma.usuario.application.mapper.IUserRequestMapper;
import com.pragma.usuario.application.mapper.IUserResponseMapper;
import com.pragma.usuario.domain.api.IUserServicePort;
import com.pragma.usuario.domain.model.UserModel;
import com.pragma.usuario.domain.spi.token.IToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;
    private final IToken iToken;



    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        UserModel userModel = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveUser(userModel);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userResponseMapper.toResponseList(userServicePort.getAllUsers());
    }

    @Override
    public void deleteUser(UserRequestDtoD userRequestDto) {
        UserModel userModel = userRequestMapper.toUser(userRequestDto);
        userServicePort.deleteUser(userModel);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return userResponseMapper.toResponseUser(userServicePort.getUserById(id));
    }

    @Override
    public Boolean userOwnerExist(Long id) {
        return userServicePort.userOwnerExist(id);
    }

    @Override
    public UserResponseDto getUserByEmail(String correo) {
        return userResponseMapper.toResponseUser(userServicePort.getUserByEmail(correo));
    }
}
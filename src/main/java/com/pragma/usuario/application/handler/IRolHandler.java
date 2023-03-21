package com.pragma.usuario.application.handler;

import com.pragma.usuario.application.dto.request.RolRequestDto;
import com.pragma.usuario.application.dto.response.RolResponseDto;

import java.util.List;

public interface IRolHandler {

    void saveRol(RolRequestDto rolRequestDto);

    List<RolResponseDto> getAllRoles();

    RolResponseDto getRolById(Long id);

}
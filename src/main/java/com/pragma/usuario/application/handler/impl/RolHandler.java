package com.pragma.usuario.application.handler.impl;

import com.pragma.usuario.application.dto.request.RolRequestDto;
import com.pragma.usuario.application.dto.response.RolResponseDto;
import com.pragma.usuario.application.handler.IRolHandler;
import com.pragma.usuario.application.mapper.IRolRequestMapper;
import com.pragma.usuario.application.mapper.IRolResponseMapper;
import com.pragma.usuario.domain.api.IRolServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RolHandler implements IRolHandler {

    private final IRolServicePort rolServicePort;
    private final IRolRequestMapper rolRequestMapper;
    private final IRolResponseMapper rolResponseMapper;


    @Override
    public void saveRol(RolRequestDto rolRequestDto) {
        rolServicePort.saveRol(rolRequestMapper.toRol(rolRequestDto));
    }

    @Override
    public List<RolResponseDto> getAllRoles() {
        return rolResponseMapper.toResponseList(rolServicePort.getAllRoles());
    }

    @Override
    public RolResponseDto getRolById(Long id) {
        return rolResponseMapper.toResponseRol(rolServicePort.getRolById(id));
    }
}
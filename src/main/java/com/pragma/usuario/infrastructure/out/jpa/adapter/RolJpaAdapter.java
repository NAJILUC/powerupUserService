package com.pragma.usuario.infrastructure.out.jpa.adapter;

import com.pragma.usuario.domain.model.RolModel;
import com.pragma.usuario.domain.spi.IRolPersistencePort;
import com.pragma.usuario.infrastructure.exception.NoDataFoundException;
import com.pragma.usuario.infrastructure.out.jpa.entity.RolEntity;
import com.pragma.usuario.infrastructure.out.jpa.mapper.IRolEntityMapper;
import com.pragma.usuario.infrastructure.out.jpa.repository.IRolRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RolJpaAdapter implements IRolPersistencePort {

    private final IRolRepository rolRepository;
    private final IRolEntityMapper rolEntityMapper;




    @Override
    public RolModel saveRol(RolModel rolModel) {
        RolEntity rolEntity = rolRepository.save(rolEntityMapper.toEntity(rolModel));
        return rolEntityMapper.toRolModel(rolEntityMapper.toEntity(rolModel));
    }

    @Override
    public List<RolModel> getAllRoles() {

        List<RolEntity> entityList = rolRepository.findAll();
        if(entityList.isEmpty())throw new NoDataFoundException();
        return rolEntityMapper.toRolModelList(entityList);
    }

    @Override
    public RolModel getRolById(Long id) {
        Optional<RolEntity> optionalRolEntity = rolRepository.findById(id);
        RolEntity rolEntity = optionalRolEntity.orElse(null);
        return rolEntityMapper.toRolModel(rolEntity);
    }
}
package com.pragma.usuario.domain.spi;

import com.pragma.usuario.domain.model.RolModel;

import java.util.List;

public interface IRolPersistencePort {

    RolModel saveRol(RolModel rolModel);

    List<RolModel> getAllRoles();

    RolModel getRolById(Long id);
}
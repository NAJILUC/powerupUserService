package com.pragma.usuario.domain.api;

import com.pragma.usuario.domain.model.RolModel;

import java.util.List;

public interface IRolServicePort {

    void saveRol(RolModel rolModel);

    List<RolModel> getAllRoles();

    RolModel getRolById(Long id);

}
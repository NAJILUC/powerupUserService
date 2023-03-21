package com.pragma.usuario.domain.usecase;

import com.pragma.usuario.domain.api.IRolServicePort;
import com.pragma.usuario.domain.model.RolModel;
import com.pragma.usuario.domain.spi.IRolPersistencePort;

import java.util.List;

public class RolUseCase implements IRolServicePort {

    private final IRolPersistencePort rolPersistencePort;

    public RolUseCase(IRolPersistencePort rolPersistencePort) {this.rolPersistencePort = rolPersistencePort;}


    @Override
    public void saveRol(RolModel rolModel) {
    rolPersistencePort.saveRol(rolModel);
    }

    @Override
    public List<RolModel> getAllRoles() {return rolPersistencePort.getAllRoles();}

    @Override
    public RolModel getRolById(Long id) {
        return rolPersistencePort.getRolById(id);
    }

}
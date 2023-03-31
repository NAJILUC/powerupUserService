package com.pragma.usuario.domain.usecase;

import com.pragma.usuario.domain.api.IUserServicePort;
import com.pragma.usuario.domain.model.RolModel;
import com.pragma.usuario.domain.model.UserModel;
import com.pragma.usuario.domain.spi.IUserPersistencePort;
import com.pragma.usuario.domain.spi.token.IToken;

import java.util.List;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IToken iToken;

    public UserUseCase(IUserPersistencePort userPersistencePort, IToken iToken) {
        this.userPersistencePort = userPersistencePort;
        this.iToken = iToken;
    }


    @Override
    public void saveUser(UserModel userModel) {

        if(iToken.getBearerToken()==null){
            userModel.setRol(new RolModel(4L, "Cliente","Rol del Cliente"));
            userPersistencePort.saveUser(userModel);
            return;
        }
        UserModel user = getUserById(iToken.getUserAuthenticatedId(iToken.getBearerToken()));
        userModel.getRol().setId(user.getRol().getId()+1);
        userPersistencePort.saveUser(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }

    @Override
    public void deleteUser(UserModel userModel) {
        List<UserModel> aux = getAllUsers();
        for (UserModel tmp : aux) {
            if(userModel.getId()== tmp.getId()) {
                userModel = tmp;
                userPersistencePort.deleteUser(userModel);
            }
        }
    }

    @Override
    public UserModel getUserById(Long id) {
        List<UserModel> users = getAllUsers();
        for (UserModel user:users) {
            if(user.getId()==id) return user;
        }
        return new UserModel(0L,"","",0L,"","","",new RolModel(0L,"",""));
    }

    @Override
    public Boolean userOwnerExist(Long id) {
        List<UserModel> users = getAllUsers();
        for (UserModel user: users) {
            if(user.getId()==id&&user.getRol().getNombreRol().equals("Propietario")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserModel getUserByEmail(String correo) {
        List<UserModel> users = getAllUsers();
        for (UserModel user:users) {
            if(user.getCorreo().equals(correo)) return user;
        }
        return new UserModel(0L,"","",0L,"","","",new RolModel(0L,"",""));
    }
}
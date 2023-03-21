package com.pragma.usuario.domain.spi;

import com.pragma.usuario.domain.model.UserModel;

import java.util.List;

public interface IUserPersistencePort {
    UserModel saveUser(UserModel userModel);

    List<UserModel> getAllUsers();

    UserModel deleteUser(UserModel userModel);

}
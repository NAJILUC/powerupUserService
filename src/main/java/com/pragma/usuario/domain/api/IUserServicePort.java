package com.pragma.usuario.domain.api;

import com.pragma.usuario.domain.model.UserModel;

import java.util.List;

public interface IUserServicePort {

    void saveUser(UserModel userModel);

    List<UserModel> getAllUsers();

    void deleteUser(UserModel userModel);

    UserModel getUserById(Long id);

    Boolean userOwnerExist(Long id);

    UserModel getUserByEmail(String correo);
}
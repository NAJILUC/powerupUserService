package com.pragma.usuario.infrastructure.out.jpa.adapter;

import com.pragma.usuario.domain.model.UserModel;
import com.pragma.usuario.domain.spi.IUserPersistencePort;
import com.pragma.usuario.infrastructure.exception.NoDataFoundException;
import com.pragma.usuario.infrastructure.out.jpa.entity.UserEntity;
import com.pragma.usuario.infrastructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.usuario.infrastructure.out.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;


    @Override
    public UserModel saveUser(UserModel userModel) {
        userModel.setClave(BCrypt.hashpw(userModel.getClave(),BCrypt.gensalt()));
        UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(userModel));
        return userEntityMapper.toUserModel(userEntity);
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserEntity> entityList = userRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return userEntityMapper.toUserModelList(entityList);
    }

    @Override
    public UserModel deleteUser(UserModel userModel) {
       UserEntity userEntity = userEntityMapper.toEntity(userModel);
        userRepository.delete(userEntity);
        return userEntityMapper.toUserModel(userEntity);
    }

}
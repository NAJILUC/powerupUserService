package com.pragma.usuario.domain.usecase;

import com.pragma.usuario.domain.model.RolModel;
import com.pragma.usuario.domain.model.UserModel;
import com.pragma.usuario.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserUseCaseTest {

    @InjectMocks
    UserUseCase userUseCase;

    @Mock
    IUserPersistencePort userPersistencePort;

    @Test
    void mustSaveUser() {
        //Given
        //Como usuario administrador debo guardar un usuario propietario
        UserModel expectedUser = new UserModel(1L,"Julian","Navarro",1193224460L,
                "3185746453","najiluc@gmail.com","1234",new RolModel(2L,"Propietario","Rol del Propietario"));

        RolModel rolModel = new RolModel(1L,"Propietario","Rol del Propietario");

        UserModel userModel = new UserModel(1L,"Julian","Navarro",1193224460L,
                "3185746453","najiluc@gmail.com","1234",rolModel);

        //When
        //Le envio los valores correctamente
        userUseCase.saveUser(userModel);

        //Then
        //El sistema guarda el usuario
        Mockito.verify(userPersistencePort).saveUser(Mockito.any(UserModel.class));

    }

    @Test
    void mustGetAllUsers() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void userOwnerExist() {
    }
}
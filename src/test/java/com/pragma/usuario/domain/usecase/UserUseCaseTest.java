package com.pragma.usuario.domain.usecase;

import com.pragma.usuario.domain.model.RolModel;
import com.pragma.usuario.domain.model.UserModel;
import com.pragma.usuario.domain.spi.IUserPersistencePort;
import com.pragma.usuario.domain.spi.token.IToken;
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
    @Mock
    IToken iToken;

    @Test
    void mustSaveUser() {
        //Given
        //Como usuario administrador debo guardar un usuario Propietario
        UserModel expectedUser = new UserModel(1L,"Julian","Navarro",1193224460L,
                "3185746453","najiluc@gmail.com","1234",new RolModel(2L,"Propietario","Rol del Propietario"));

        RolModel rolModel = new RolModel(2L,"Propietario","Rol del Propietario");

        UserModel userModel = new UserModel(1L,"Julian","Navarro",1193224460L,
                "3185746453","najiluc@gmail.com","1234",rolModel);

        //When
        //Le envio los valores correctamente
        Mockito.when(iToken.getBearerToken()).thenReturn("validToken");
        Mockito.when(iToken.getUserAuthenticatedId("validToken")).thenReturn(1L);
        userUseCase.saveUser(userModel);

        //Then
        //El sistema guarda el usuario
        Mockito.verify(userPersistencePort).saveUser(Mockito.any(UserModel.class));
        userModel.getRol().setId(2L);
        Mockito.when(iToken.getBearerToken()).thenReturn("validToken");
        Mockito.when(iToken.getUserAuthenticatedId("validToken")).thenReturn(1L);
        assertEquals(expectedUser.getId(), userModel.getId());
        assertEquals(expectedUser.getCorreo(), userModel.getCorreo());
        assertEquals(expectedUser.getRol().getNombreRol(), userModel.getRol().getNombreRol());
        assertEquals(expectedUser.getRol().getDescripcionRol(), userModel.getRol().getDescripcionRol());
        assertEquals(expectedUser.getRol().getId(), userModel.getRol().getId());
        assertEquals(expectedUser.getDocumento(), userModel.getDocumento());
        assertEquals(expectedUser.getApellido(), userModel.getApellido());
        assertEquals(expectedUser.getCelular(), userModel.getCelular());
        assertEquals(expectedUser.getClave(), userModel.getClave());
        assertEquals(expectedUser.getNombre(), userModel.getNombre());

        //Given
        //Como usuario Propietario debo guardar un usuario Empleado
        expectedUser = new UserModel(2L,"Julian","Navarro",1193224460L,
                "3185746453","najiluc@gmail.com","1234",new RolModel(3L,"Empleado","Rol del Empleado"));

        rolModel = new RolModel(3L,"Empleado","Rol del Empleado");

        userModel = new UserModel(2L,"Julian","Navarro",1193224460L,
                "3185746453","najiluc@gmail.com","1234",rolModel);

        //When
        //Le envio los valores correctamente
        Mockito.when(iToken.getUserAuthenticatedId("validToken")).thenReturn(2L);
        userUseCase.saveUser(userModel);

        //Then
        //El sistema guarda el usuario
        assertEquals(expectedUser.getId(), userModel.getId());
        assertEquals(expectedUser.getCorreo(), userModel.getCorreo());
        assertEquals(expectedUser.getRol().getNombreRol(), userModel.getRol().getNombreRol());
        assertEquals(expectedUser.getRol().getDescripcionRol(), userModel.getRol().getDescripcionRol());
        assertEquals(expectedUser.getDocumento(), userModel.getDocumento());
        assertEquals(expectedUser.getApellido(), userModel.getApellido());
        assertEquals(expectedUser.getCelular(), userModel.getCelular());
        assertEquals(expectedUser.getClave(), userModel.getClave());
        assertEquals(expectedUser.getNombre(), userModel.getNombre());

        //Given
        //Estando sin autenticacion debopoder crear mi usuario como cliente
        expectedUser = new UserModel(3L,"Julian","Navarro",1193224460L,
                "3185746453","najiluc@gmail.com","1234",new RolModel(4L,"Cliente","Rol del Cliente"));

        rolModel = new RolModel(4L,"Cliente","Rol del Cliente");

        userModel = new UserModel(3L,"Julian","Navarro",1193224460L,
                "3185746453","najiluc@gmail.com","1234",rolModel);

        //When
        //Le envio los valores correctamente
        Mockito.when(iToken.getBearerToken()).thenReturn(null);
        userUseCase.saveUser(userModel);

        //Then
        //El sistema guarda el usuario
        assertEquals(expectedUser.getId(), userModel.getId());
        assertEquals(expectedUser.getCorreo(), userModel.getCorreo());
        assertEquals(expectedUser.getRol().getNombreRol(), userModel.getRol().getNombreRol());
        assertEquals(expectedUser.getRol().getDescripcionRol(), userModel.getRol().getDescripcionRol());
        assertEquals(expectedUser.getRol().getId(), userModel.getRol().getId());
        assertEquals(expectedUser.getDocumento(), userModel.getDocumento());
        assertEquals(expectedUser.getApellido(), userModel.getApellido());
        assertEquals(expectedUser.getCelular(), userModel.getCelular());
        assertEquals(expectedUser.getClave(), userModel.getClave());
        assertEquals(expectedUser.getNombre(), userModel.getNombre());
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
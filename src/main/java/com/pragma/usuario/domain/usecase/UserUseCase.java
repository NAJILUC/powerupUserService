package com.pragma.usuario.domain.usecase;

import com.pragma.usuario.domain.api.IUserServicePort;
import com.pragma.usuario.domain.exception.DomainException;
import com.pragma.usuario.domain.model.RolModel;
import com.pragma.usuario.domain.model.UserModel;
import com.pragma.usuario.domain.spi.IUserPersistencePort;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }


    @Override
    public void saveUser(UserModel userModel) {
    if(userModel.getNombre().isEmpty())throw new DomainException("El nombre es obligatorio");
    if(userModel.getApellido().isEmpty())throw new DomainException("El apellido es obligatorio");
    if(userModel.getDocumento().toString().isEmpty()||userModel.getDocumento().toString().length()<1)
        throw new DomainException("Ingrese un documento valido");
    if(userModel.getCelular().isEmpty()||userModel.getCelular().length()<10||userModel.getCelular().length()>13)
        throw new DomainException("Ingrese un celular valido");
    if(!userModel.getCorreo().contains("@")||userModel.getCorreo().isEmpty())
        throw new DomainException("Ingrese un correo valido");
    if(userModel.getClave().isEmpty())throw new DomainException("La clave es obligatoria");
        userModel.setClave(BCrypt.hashpw(userModel.getClave(),BCrypt.gensalt()));
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
        //System.out.println(id);
        List<UserModel> users = getAllUsers();
        for (UserModel user:users) {
            if(user.getId()==id && user.getRol().getId()==2) return user;
        }
     //   System.out.println("Nofunc");
        return new UserModel(0L,"","",0L,"","","",new RolModel(0L,"",""));
    }

    @Override
    public Boolean userOwnerExist(Long id) {
        List<UserModel> users = getAllUsers();
        for (UserModel user: users) {
            if(user.getId()==id&&user.getRol().getNombreRol().equals("Propietario")) {
      //          System.out.println("Si");
                return true;
            }
        }
       // System.out.println("No");
        return false;
    }
}
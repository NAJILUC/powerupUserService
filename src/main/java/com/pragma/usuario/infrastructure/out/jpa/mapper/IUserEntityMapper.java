package com.pragma.usuario.infrastructure.out.jpa.mapper;

import com.pragma.usuario.domain.model.UserModel;
import com.pragma.usuario.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserEntityMapper {

    @Mapping(target = "rol.id",source = "rol.id")
    UserEntity toEntity(UserModel user);
    @Mapping(target = "rol.id",source = "rol.id")
    UserModel toUserModel(UserEntity userEntity);
    List<UserModel> toUserModelList(List<UserEntity> userEntityList);
}
package com.pragma.usuario.application.mapper;

import com.pragma.usuario.application.dto.request.UserRequestDto;
import com.pragma.usuario.application.dto.request.UserRequestDtoD;
import com.pragma.usuario.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    @Mapping(target = "rol.id", source = "rol")
    UserModel toUser(UserRequestDto userRequestDto);


    UserModel toUser(UserRequestDtoD userRequestDtoD);
}

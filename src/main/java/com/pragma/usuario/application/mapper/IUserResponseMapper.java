package com.pragma.usuario.application.mapper;

import com.pragma.usuario.application.dto.response.UserResponseDto;
import com.pragma.usuario.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {

    UserResponseDto toResponseUser(UserModel userModel);

    UserModel toUser(UserResponseDto userResponseDto);

   List<UserResponseDto> toResponseList(List<UserModel> userModelList);
}

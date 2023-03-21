package com.pragma.usuario.application.mapper;

import com.pragma.usuario.application.dto.request.RolRequestDto;
import com.pragma.usuario.domain.model.RolModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolRequestMapper {

    RolModel toRol(RolRequestDto rolRequestDto);

    RolRequestDto toRequest(RolModel rolModel);
}

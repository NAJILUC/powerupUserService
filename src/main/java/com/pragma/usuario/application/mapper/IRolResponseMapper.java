package com.pragma.usuario.application.mapper;

import com.pragma.usuario.application.dto.response.RolResponseDto;
import com.pragma.usuario.domain.model.RolModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolResponseMapper {

    RolResponseDto toResponseRol(RolModel rolModel);

   List<RolResponseDto> toResponseList(List<RolModel> rolModelList);
}

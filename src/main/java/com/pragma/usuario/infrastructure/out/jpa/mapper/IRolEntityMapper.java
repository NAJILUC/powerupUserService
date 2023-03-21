package com.pragma.usuario.infrastructure.out.jpa.mapper;

import com.pragma.usuario.domain.model.RolModel;
import com.pragma.usuario.infrastructure.out.jpa.entity.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IRolEntityMapper {

    RolEntity toEntity(RolModel rol);
    RolModel toRolModel(RolEntity rolEntity);
    List<RolModel> toRolModelList(List<RolEntity> rolEntityList);
}
package com.pragma.usuario.infrastructure.out.jpa.feignclients.adapter;

import com.pragma.usuario.domain.spi.feignClient.IUserFeignClientPort;
import com.pragma.usuario.infrastructure.out.jpa.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFeignAdapter implements IUserFeignClientPort {

    private final UserFeignClient userFeignClient;

    @Override
    public void saveRestaurante_Empleado(Long idPropietario, Long idEmpleado) {
         userFeignClient.saveRestaurante_Empleado(idPropietario,idEmpleado);
    }
}

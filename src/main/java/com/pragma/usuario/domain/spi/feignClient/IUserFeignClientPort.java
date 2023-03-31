package com.pragma.usuario.domain.spi.feignClient;

public interface IUserFeignClientPort {

    void saveRestaurante_Empleado(Long idPropietario,Long idEmpleado);
}

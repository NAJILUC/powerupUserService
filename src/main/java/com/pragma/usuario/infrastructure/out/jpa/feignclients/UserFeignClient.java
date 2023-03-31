package com.pragma.usuario.infrastructure.out.jpa.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "plazoleta-service", url = "localhost:8089")
public interface UserFeignClient {

    @PostMapping("/api/v1/restaurante/restemp/{idPropietario}/{idEmpleado}")
    void saveRestaurante_Empleado(@PathVariable("idPropietario") Long idPropietario, @PathVariable("idEmpleado") Long idEmpleado);
}
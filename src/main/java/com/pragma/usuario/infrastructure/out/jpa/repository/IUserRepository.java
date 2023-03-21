package com.pragma.usuario.infrastructure.out.jpa.repository;

import com.pragma.usuario.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
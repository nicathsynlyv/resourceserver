package com.example.resourceserver.repositories;

import com.example.resourceserver.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole, Integer> {
//    Optional<UserEntity> findByUsername(String username);
}

package com.example.resourceserver.repositories;

import com.example.resourceserver.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
//    Optional<UserEntity> findByUsername(String username);
}

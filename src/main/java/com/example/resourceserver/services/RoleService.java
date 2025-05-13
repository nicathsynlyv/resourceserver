package com.example.resourceserver.services;


import com.example.resourceserver.dtos.RolePrivilegeDto;
import com.example.resourceserver.dtos.UserRoleDto;
import com.example.resourceserver.entities.Privilege;
import com.example.resourceserver.entities.UserRole;
import com.example.resourceserver.repositories.RoleRepository;
import com.example.resourceserver.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    private final RoleRepository repository;
    private final UserRepository userRepository;
    public RoleService(RoleRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public UserRoleDto createRole(UserRoleDto dto){
        UserRole role = new UserRole();
        role.setName(dto.getName());
        repository.save(role);
        return dto;
    }

    public RolePrivilegeDto createRole(RolePrivilegeDto dto){
        UserRole ur = repository.findById(dto.getRoleId()).get();
        List<Privilege> privileges = new ArrayList<>();
        dto.getPrivilegeId().forEach(id->{
            Privilege p = new Privilege();
            p.setId(id);
            privileges.add(p);
        });


        ur.setPrivileges(privileges);
        repository.save(ur);
        return dto;
    }
}

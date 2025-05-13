package com.example.resourceserver.services;


import com.example.resourceserver.dtos.PrivilegeDto;
import com.example.resourceserver.entities.Privilege;
import com.example.resourceserver.repositories.PrivilegeRepository;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeService {
    private final PrivilegeRepository repository;

    public PrivilegeService(PrivilegeRepository repository) {
        this.repository = repository;
    }

    public PrivilegeDto createPrivilege(PrivilegeDto dto){
        Privilege privilege = new Privilege();
        privilege.setName(dto.getName());
        repository.save(privilege);
        return  dto;
    }
}

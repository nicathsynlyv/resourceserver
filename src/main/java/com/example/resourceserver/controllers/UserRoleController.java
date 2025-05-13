package com.example.resourceserver.controllers;

import com.example.resourceserver.dtos.RolePrivilegeDto;
import com.example.resourceserver.dtos.UserRoleDto;
import com.example.resourceserver.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRoleController {

    private final RoleService service;

    public UserRoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping("/roles")
    public ResponseEntity<?> createRole(@RequestBody UserRoleDto dto){
        return ResponseEntity.ok(service.createRole(dto));
    }
    @PostMapping("/role-privileges")
    public ResponseEntity<?> createRolePrivilege(@RequestBody RolePrivilegeDto dto){
        return ResponseEntity.ok(service.createRole(dto));
    }
}

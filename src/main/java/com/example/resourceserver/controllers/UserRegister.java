package com.example.resourceserver.controllers;

import com.example.resourceserver.dtos.UserDto;
import com.example.resourceserver.dtos.UserRolesDto;
import com.example.resourceserver.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRegister {
    private final UserService userService;

    public UserRegister(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/register")
    public ResponseEntity<?> createUser(@RequestBody UserDto dto){
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @PostMapping("/user-roles")
    public ResponseEntity<?> createUserRoles(@RequestBody UserRolesDto dto){
        return ResponseEntity.ok(userService.createUserRoles(dto));
    }
}

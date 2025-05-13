package com.example.resourceserver.controllers;

import com.example.resourceserver.dtos.PrivilegeDto;
import com.example.resourceserver.services.PrivilegeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PrivilegeController {
   private final PrivilegeService service;

    public PrivilegeController(PrivilegeService service) {
        this.service = service;
    }

    @PostMapping("/privileges")
    public ResponseEntity<?> createPrivilege(@RequestBody PrivilegeDto dto){
        return ResponseEntity.ok(service.createPrivilege(dto));
    }
}

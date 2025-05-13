package com.example.resourceserver.dtos;

import lombok.Data;

import java.util.List;

@Data
public class RolePrivilegeDto {
    private Integer roleId;
    private List<Integer> privilegeId;
}

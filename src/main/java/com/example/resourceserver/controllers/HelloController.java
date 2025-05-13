package com.example.resourceserver.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    //    @Secured("ROLE_MANAGER")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello1")
    public String hello1() {
        return "Hello1!";
    }

    @PostMapping("hello")
    public String postString(String echo){
        return "posting "+echo;
    }

    @PutMapping("hello")
    public String putString(String echo){
        return "putting "+echo;
    }

    @DeleteMapping("hello/{id}")
    public String deleteString(@PathVariable("id") String id){
        return "deleting "+id;
    }
}


package com.trent.personalfinancemanagerapi.controller;

import com.trent.personalfinancemanagerapi.dto.UserRequestDto;
import com.trent.personalfinancemanagerapi.dto.UserResponseDto;
import com.trent.personalfinancemanagerapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto user){
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable long id){
        return service.getUserById(id);
    }

}

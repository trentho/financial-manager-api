package com.trent.personalfinancemanagerapi.service;

import com.trent.personalfinancemanagerapi.dto.UserRequestDto;
import com.trent.personalfinancemanagerapi.dto.UserResponseDto;
import com.trent.personalfinancemanagerapi.entity.UserEntity;
import com.trent.personalfinancemanagerapi.mapper.UserMapper;
import com.trent.personalfinancemanagerapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public UserResponseDto createUser(UserRequestDto user){
        if (repository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Map dto to entity
        UserEntity entity = UserMapper.toEntity(user);
        entity.setCreatedAt(LocalDateTime.now());

        UserEntity saved = repository.save(entity);

        return UserMapper.toResponse(saved);
    }

    public UserResponseDto getUserById(long id){
        UserEntity user =  repository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        return UserMapper.toResponse(user);
    }
}

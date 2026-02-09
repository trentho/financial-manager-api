package com.trent.personalfinancemanagerapi.mapper;

import com.trent.personalfinancemanagerapi.dto.UserRequestDto;
import com.trent.personalfinancemanagerapi.dto.UserResponseDto;
import com.trent.personalfinancemanagerapi.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(UserRequestDto dto) {
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    public static UserResponseDto toResponse(UserEntity entity) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}

package com.trent.personalfinancemanagerapi.mapper;

import com.trent.personalfinancemanagerapi.dto.AccountRequestDto;
import com.trent.personalfinancemanagerapi.dto.AccountResponseDto;
import com.trent.personalfinancemanagerapi.entity.AccountEntity;
import com.trent.personalfinancemanagerapi.entity.UserEntity;

public class AccountMapper {

    public static AccountEntity toEntity(AccountRequestDto dto, UserEntity user) {
        AccountEntity entity = new AccountEntity();
        entity.setName(dto.getName());
        entity.setBalance(dto.getBalance());
        entity.setType(dto.getType());
        entity.setUser(user);
        return entity;
    }

    public static AccountResponseDto toResponse(AccountEntity entity) {
        AccountResponseDto dto = new AccountResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setBalance(entity.getBalance());
        dto.setType(entity.getType());
        dto.setUserId(entity.getUser().getId());
        return dto;
    }
}

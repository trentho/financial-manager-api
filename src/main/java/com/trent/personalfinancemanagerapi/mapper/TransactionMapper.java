package com.trent.personalfinancemanagerapi.mapper;

import com.trent.personalfinancemanagerapi.dto.TransactionRequestDto;
import com.trent.personalfinancemanagerapi.dto.TransactionResponseDto;
import com.trent.personalfinancemanagerapi.entity.AccountEntity;
import com.trent.personalfinancemanagerapi.entity.TransactionEntity;

public class TransactionMapper {

    public static TransactionEntity toEntity(TransactionRequestDto dto, AccountEntity account) {
        TransactionEntity entity = new TransactionEntity();
        entity.setAmount(dto.getAmount());
        entity.setDescription(dto.getDescription());
        entity.setAccount(account);
        return entity;
    }

    public static TransactionResponseDto toResponse(TransactionEntity entity) {
        TransactionResponseDto dto = new TransactionResponseDto();
        dto.setId(entity.getId());
        dto.setAmount(entity.getAmount());
        dto.setDescription(entity.getDescription());
        dto.setTimestamp(entity.getTimestamp());
        dto.setAccountId(entity.getAccount().getId());
        return dto;
    }
}

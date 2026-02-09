package com.trent.personalfinancemanagerapi.service;

import com.trent.personalfinancemanagerapi.dto.AccountRequestDto;
import com.trent.personalfinancemanagerapi.dto.AccountResponseDto;
import com.trent.personalfinancemanagerapi.entity.AccountEntity;
import com.trent.personalfinancemanagerapi.entity.UserEntity;
import com.trent.personalfinancemanagerapi.mapper.AccountMapper;
import com.trent.personalfinancemanagerapi.repository.AccountRepository;
import com.trent.personalfinancemanagerapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;
    private final UserRepository userRepository;

    AccountService(AccountRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public AccountResponseDto createAccount(AccountRequestDto account, long userId) {

        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        AccountEntity entity = AccountMapper.toEntity(account,userEntity);

        AccountEntity saved = repository.save(entity);
        return AccountMapper.toResponse(saved);
    }

    public List<AccountResponseDto> getAccountsByUserId(long userId) {
        List<AccountEntity> accounts = repository.findByUserId(userId);

        List<AccountResponseDto> result = new ArrayList<>();
        for (AccountEntity entity : accounts) {
            result.add(AccountMapper.toResponse(entity));
        }
        return result;
    }
}

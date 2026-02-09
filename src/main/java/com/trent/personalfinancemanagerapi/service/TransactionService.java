package com.trent.personalfinancemanagerapi.service;

import com.trent.personalfinancemanagerapi.dto.AccountResponseDto;
import com.trent.personalfinancemanagerapi.dto.TransactionRequestDto;
import com.trent.personalfinancemanagerapi.dto.TransactionResponseDto;
import com.trent.personalfinancemanagerapi.entity.AccountEntity;
import com.trent.personalfinancemanagerapi.entity.TransactionEntity;
import com.trent.personalfinancemanagerapi.mapper.AccountMapper;
import com.trent.personalfinancemanagerapi.mapper.TransactionMapper;
import com.trent.personalfinancemanagerapi.repository.AccountRepository;
import com.trent.personalfinancemanagerapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;
    private final AccountRepository accountRepository;

    TransactionService(TransactionRepository repository, AccountRepository accountRepository){
        this.repository = repository;
        this.accountRepository = accountRepository;
    }

    public TransactionResponseDto createTransaction(TransactionRequestDto transaction, long accountId) {
        AccountEntity accountEntity = accountRepository.findById(accountId).orElseThrow();

        TransactionEntity transactionEntity = TransactionMapper.toEntity(transaction, accountEntity);

        if (transactionEntity.getTimestamp() == null) {
            transactionEntity.setTimestamp(LocalDateTime.now());
        }

        TransactionEntity saved = repository.save(transactionEntity);

        return TransactionMapper.toResponse(saved);
    }

    public List<TransactionResponseDto> getTransactionsByAccountId(long accountId) {
        List<TransactionEntity> transactions = repository.findByAccountId(accountId);

        List<TransactionResponseDto> result = new ArrayList<>();
        for (TransactionEntity entity : transactions) {
            result.add(TransactionMapper.toResponse(entity));
        }
        return result;
    }
}

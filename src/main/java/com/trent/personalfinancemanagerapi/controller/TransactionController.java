package com.trent.personalfinancemanagerapi.controller;

import com.trent.personalfinancemanagerapi.dto.TransactionRequestDto;
import com.trent.personalfinancemanagerapi.dto.TransactionResponseDto;
import com.trent.personalfinancemanagerapi.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/{accountId}/transactions")
public class TransactionController {

    private final TransactionService service;

    TransactionController(TransactionService service){
        this.service = service;
    }


    @PostMapping
    public TransactionResponseDto createTransaction(@RequestBody TransactionRequestDto transaction, @PathVariable long accountId){
        return service.createTransaction(transaction,accountId);
    }

    @GetMapping
    public List<TransactionResponseDto> getTransactionsByAccountId(@PathVariable long accountId){
        return service.getTransactionsByAccountId(accountId);
    }
}

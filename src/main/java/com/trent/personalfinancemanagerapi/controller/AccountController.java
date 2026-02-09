package com.trent.personalfinancemanagerapi.controller;

import com.trent.personalfinancemanagerapi.dto.AccountRequestDto;
import com.trent.personalfinancemanagerapi.dto.AccountResponseDto;
import com.trent.personalfinancemanagerapi.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/accounts")
public class AccountController {
    private final AccountService service;

    AccountController(AccountService service){
        this.service = service;
    }

    @PostMapping
    public AccountResponseDto createAccount(@RequestBody AccountRequestDto account, @PathVariable long userId){
        return service.createAccount(account,userId);
    }

    @GetMapping
    public List<AccountResponseDto> getAccountsByUserId(@PathVariable long userId){
        return service.getAccountsByUserId(userId);
    }
}

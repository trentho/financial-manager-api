package com.trent.personalfinancemanagerapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionResponseDto {
    public long id;
    public BigDecimal amount;
    public String description;
    public LocalDateTime timestamp;
    public long accountId;
}

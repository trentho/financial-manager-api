package com.trent.personalfinancemanagerapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionRequestDto {
    public BigDecimal amount;
    public String description;
}

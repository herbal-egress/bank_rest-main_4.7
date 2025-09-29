package com.example.bankcards.service;

import com.example.bankcards.dto.transaction.TransactionRequest;
import com.example.bankcards.dto.transaction.TransactionResponse;

public interface TransactionService {
    TransactionResponse transfer(TransactionRequest request);
}
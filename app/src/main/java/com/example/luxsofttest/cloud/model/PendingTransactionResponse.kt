package com.example.luxsofttest.cloud.model

data class PendingTransactionResponse(
    val id: String,
    val merchand: String,
    val category: TransactionCategory,
    val amount: String,
    val currency: String,
    val timestamp: String
)
package com.example.luxsofttest.cloud.model

data class ExecutedTransactionResult(
    override val merchand: String,
    override val amount: Int,
    override val currency: String,
    override val category: TransactionCategory,
    override val status: TransactionStatus = TransactionStatus.EXECUTED
) : Transaction
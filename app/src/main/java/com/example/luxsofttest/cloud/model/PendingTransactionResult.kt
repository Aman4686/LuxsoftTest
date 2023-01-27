package com.example.luxsofttest.cloud.model

data class PendingTransactionResult(
    override val merchand: String,
    override val amount: Int,
    override val category: TransactionCategory,
    override val status: TransactionStatus = TransactionStatus.PENDING
) : TransactionResult
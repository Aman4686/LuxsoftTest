package com.example.luxsofttest.ui.screens.transaction.detail.state

import com.example.luxsofttest.cloud.model.Transaction
import com.example.luxsofttest.cloud.model.TransactionResult

sealed class TransactionDetailsViewState

data class DisplayTransactionDetailsViewState(
    var transaction: Transaction
) : TransactionDetailsViewState()

object LoadingTransactionDetailsViewState : TransactionDetailsViewState()

data class ErrorTransactionDetailsViewState(val throwable: Throwable) : TransactionDetailsViewState()
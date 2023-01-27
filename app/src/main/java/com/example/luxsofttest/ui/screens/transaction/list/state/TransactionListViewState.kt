package com.example.luxsofttest.ui.screens.transaction.list.state

import com.example.luxsofttest.cloud.model.TransactionResult

sealed class TransactionListViewState

data class DisplayTransactionListViewState(
    var transactionsList: List<TransactionResult>
) : TransactionListViewState()

object LoadingTransactionListViewState : TransactionListViewState()

data class ErrorTransactionListViewState(val throwable: Throwable) : TransactionListViewState()
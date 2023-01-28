package com.example.luxsofttest.ui.screens.transaction.list.state

import com.example.luxsofttest.cloud.model.Transaction

sealed class TransactionListViewState

data class DisplayTransactionListViewState(
    var transactionsList: List<Transaction>
) : TransactionListViewState()

object LoadingTransactionListViewState : TransactionListViewState()

data class ErrorTransactionListViewState(val throwable: Throwable) : TransactionListViewState()
package com.example.luxsofttest.ui.screens.bankAccount.state

import com.example.luxsofttest.cloud.model.CardResult
import com.example.luxsofttest.cloud.model.TransactionResult

sealed class BankAccountViewState

data class DisplayBankAccountViewState(
    var cardList: List<CardResult>?,
    var transactionsList: List<TransactionResult>?
) : BankAccountViewState()

object LoadingBankAccountViewState : BankAccountViewState()

data class ErrorBankAccountViewState(val throwable: Throwable) : BankAccountViewState()
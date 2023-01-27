package com.example.luxsofttest.ui.screens.bankAccount

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luxsofttest.cloud.model.CardResult
import com.example.luxsofttest.cloud.model.TransactionResult
import com.example.luxsofttest.cloud.useCase.card.GetCardsUseCase
import com.example.luxsofttest.cloud.useCase.transaction.GetAllTransactionsUseCase
import com.example.luxsofttest.ui.screens.bankAccount.state.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class BankAccountViewModel @Inject constructor(
    private val getAllTransactionsUseCase: GetAllTransactionsUseCase,
    private val getCardsUseCase: GetCardsUseCase,
) : ViewModel() {

    val bankAccountViewStateFlow: StateFlow<BankAccountViewState> get() = _bankAccountViewStateFlow
    private val _bankAccountViewStateFlow = MutableStateFlow<BankAccountViewState>(LoadingBankAccountViewState)

    fun obtainEvent(event: BankAccountViewEvent) {
        when (val currentState = _bankAccountViewStateFlow.value) {
            is LoadingBankAccountViewState -> handleLoadingState(event)
        }
    }

    private fun handleLoadingState(event: BankAccountViewEvent) {
        when (event) {
            is InitialBankAccountViewState -> initialize()
        }
    }

    private suspend fun getMixedTransactions() : List<TransactionResult>? {
        val transactionResult = getAllTransactionsUseCase.invoke(Unit)
       return transactionResult.getOrElse {
           _bankAccountViewStateFlow.value = ErrorBankAccountViewState(it)
           null
       }
    }

    private suspend fun getCards() : List<CardResult>?{
        val transactionResult =  getCardsUseCase.invoke(Unit)
        return transactionResult.getOrElse {
            _bankAccountViewStateFlow.value = ErrorBankAccountViewState(it)
            null
        }
    }

    private fun initialize(){
        viewModelScope.launch {
            val transactionList = getMixedTransactions()
            val cardList = getCards()

            _bankAccountViewStateFlow.value = DisplayBankAccountViewState(
                cardList,
                transactionList
            )
        }
    }
}
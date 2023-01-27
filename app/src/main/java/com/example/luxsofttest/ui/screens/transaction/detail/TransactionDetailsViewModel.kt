package com.example.luxsofttest.ui.screens.transaction.detail

import androidx.lifecycle.ViewModel
import com.example.luxsofttest.cloud.model.Transaction
import com.example.luxsofttest.ui.screens.transaction.detail.exception.EmptyTransactionDataException
import com.example.luxsofttest.ui.screens.transaction.detail.state.*
import com.example.luxsofttest.ui.screens.transaction.list.state.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TransactionDetailsViewModel @Inject constructor() : ViewModel(){

    val transactionDetailViewStateFlow: StateFlow<TransactionDetailsViewState> get() = _transactionDetailViewStateFlow
    private val _transactionDetailViewStateFlow = MutableStateFlow<TransactionDetailsViewState>(LoadingTransactionDetailsViewState)

    fun obtainEvent(event: TransactionDetailsViewEvent) {
        when (val currentState = _transactionDetailViewStateFlow.value) {
            is LoadingTransactionDetailsViewState -> handleLoadingState(event)
        }
    }

    private fun handleLoadingState(event: TransactionDetailsViewEvent) {
        when (event) {
            is InitialTransactionDetailsViewEvent -> initialize(event.transaction)
        }
    }

    private fun initialize(transaction: Transaction?){
        if(transaction != null){
            _transactionDetailViewStateFlow.value = DisplayTransactionDetailsViewState(transaction)
        } else {
            _transactionDetailViewStateFlow.value = ErrorTransactionDetailsViewState(EmptyTransactionDataException())
        }
    }
}
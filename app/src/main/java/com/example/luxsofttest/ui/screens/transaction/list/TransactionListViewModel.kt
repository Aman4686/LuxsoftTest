package com.example.luxsofttest.ui.screens.transaction.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luxsofttest.cloud.model.Transaction
import com.example.luxsofttest.cloud.useCase.transaction.GetAllTransactionsUseCase
import com.example.luxsofttest.ui.screens.transaction.list.state.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionListViewModel  @Inject constructor(
    private val getAllTransactionsUseCase: GetAllTransactionsUseCase,
) : ViewModel(){

    val transactionListViewStateFlow: StateFlow<TransactionListViewState> get() = _transactionListViewStateFlow
    private val _transactionListViewStateFlow = MutableStateFlow<TransactionListViewState>(LoadingTransactionListViewState)

    fun obtainEvent(event: TransactionListViewEvent) {
        when (val currentState = _transactionListViewStateFlow.value) {
            is LoadingTransactionListViewState -> handleLoadingState(event)
        }
    }

    private fun handleLoadingState(event: TransactionListViewEvent) {
        when (event) {
            is InitialTransactionListViewEvent -> initialize()
        }
    }

    private suspend fun getMixedTransactions() : List<Transaction>? {
        val transactionResult = getAllTransactionsUseCase.invoke(Unit)
        return transactionResult.getOrElse {
            _transactionListViewStateFlow.value = ErrorTransactionListViewState(it)
            null
        }
    }

    private fun initialize(){
        viewModelScope.launch {
           getMixedTransactions()?.let { list ->
                _transactionListViewStateFlow.value = DisplayTransactionListViewState(
                    list
                )
            }
        }
    }

}
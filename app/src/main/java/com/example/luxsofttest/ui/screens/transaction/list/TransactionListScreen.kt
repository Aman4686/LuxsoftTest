package com.example.luxsofttest.ui.screens.transaction.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.luxsofttest.base.view.FullScreenLoading
import com.example.luxsofttest.ui.screens.transaction.list.state.DisplayTransactionListViewState
import com.example.luxsofttest.ui.screens.transaction.list.state.ErrorTransactionListViewState
import com.example.luxsofttest.ui.screens.transaction.list.state.InitialTransactionListViewEvent
import com.example.luxsofttest.ui.screens.transaction.list.state.LoadingTransactionListViewState
import com.example.luxsofttest.ui.screens.transaction.list.view.TransactionListViewDisplay

@Composable
fun TransactionListScreen(
    viewModel: TransactionListViewModel = hiltViewModel()
) {
    val viewState by viewModel.transactionListViewStateFlow.collectAsState()

    when(val state = viewState){
        is DisplayTransactionListViewState -> {
           TransactionListViewDisplay(state = state)
        }
        is LoadingTransactionListViewState -> {
            FullScreenLoading()
        }
        is ErrorTransactionListViewState -> {
            //TODO Show error screen
        }
    }

    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = InitialTransactionListViewEvent)
    })
}
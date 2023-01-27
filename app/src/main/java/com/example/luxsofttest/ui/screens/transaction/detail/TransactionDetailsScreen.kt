package com.example.luxsofttest.ui.screens.transaction.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.luxsofttest.base.view.FullScreenLoading
import com.example.luxsofttest.cloud.model.Transaction
import com.example.luxsofttest.ui.screens.transaction.detail.state.DisplayTransactionDetailsViewState
import com.example.luxsofttest.ui.screens.transaction.detail.state.ErrorTransactionDetailsViewState
import com.example.luxsofttest.ui.screens.transaction.detail.state.InitialTransactionDetailsViewEvent
import com.example.luxsofttest.ui.screens.transaction.detail.state.LoadingTransactionDetailsViewState
import com.example.luxsofttest.ui.screens.transaction.detail.view.TransactionDetailsViewDisplay
import com.example.luxsofttest.ui.screens.transaction.list.state.DisplayTransactionListViewState
import com.example.luxsofttest.ui.screens.transaction.list.state.ErrorTransactionListViewState
import com.example.luxsofttest.ui.screens.transaction.list.state.InitialTransactionListViewEvent
import com.example.luxsofttest.ui.screens.transaction.list.state.LoadingTransactionListViewState
import com.example.luxsofttest.ui.screens.transaction.list.view.TransactionListViewDisplay

@Composable
fun TransactionDetailsScreen(
    transaction: Transaction?,
    viewModel: TransactionDetailsViewModel = hiltViewModel()
) {
    val viewState by viewModel.transactionDetailViewStateFlow.collectAsState()

    when(val state = viewState){
        is DisplayTransactionDetailsViewState -> {
           TransactionDetailsViewDisplay(viewState = state)
        }
        is LoadingTransactionDetailsViewState -> {
            FullScreenLoading()
        }
        is ErrorTransactionDetailsViewState -> {
            //TODO Show error screen
        }
    }

    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = InitialTransactionDetailsViewEvent(transaction))
    })
}
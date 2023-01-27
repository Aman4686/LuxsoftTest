package com.example.luxsofttest.ui.screens.bankAccount

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.luxsofttest.base.view.FullScreenLoading
import com.example.luxsofttest.cloud.model.Transaction
import com.example.luxsofttest.ui.screens.bankAccount.state.DisplayBankAccountViewState
import com.example.luxsofttest.ui.screens.bankAccount.state.ErrorBankAccountViewState
import com.example.luxsofttest.ui.screens.bankAccount.state.InitialBankAccountViewState
import com.example.luxsofttest.ui.screens.bankAccount.state.LoadingBankAccountViewState
import com.example.luxsofttest.ui.screens.bankAccount.view.BankAccountViewDisplay
import com.example.luxsofttest.ui.screens.transaction.list.state.ErrorTransactionListViewState

@Composable
fun BankAccountScreen(
    navController: NavController,
    onTransactionClick: (Transaction) -> Unit,
    viewModel: BankAccountViewModel = hiltViewModel()
) {

    val viewState by viewModel.bankAccountViewStateFlow.collectAsState()

    when(val state = viewState){
        is DisplayBankAccountViewState -> {
            BankAccountViewDisplay(state,
                onViewAllClick = {
                    navController.navigate("transactionList")
                }, onTransactionClick)
        }
        is LoadingBankAccountViewState -> {
            FullScreenLoading()
        }
        is ErrorBankAccountViewState -> {
            //TODO Show error screen
        }
    }

    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = InitialBankAccountViewState)
    })
}
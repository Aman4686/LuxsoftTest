package com.example.luxsofttest.ui.screens.bankAccount

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.luxsofttest.navigation.NavRoutes
import com.example.luxsofttest.ui.component.FullScreenLoading
import com.example.luxsofttest.ui.screens.bankAccount.state.DisplayBankAccountViewState
import com.example.luxsofttest.ui.screens.bankAccount.state.ErrorBankAccountViewState
import com.example.luxsofttest.ui.screens.bankAccount.state.InitialBankAccountViewState
import com.example.luxsofttest.ui.screens.bankAccount.state.LoadingBankAccountViewState
import com.example.luxsofttest.ui.screens.bankAccount.view.BankAccountViewDisplay
import com.google.gson.Gson

@Composable
fun BankAccountScreen(
    navController: NavController,
    viewModel: BankAccountViewModel = hiltViewModel()
) {

    val viewState by viewModel.bankAccountViewStateFlow.collectAsState()

    when (val state = viewState) {
        is DisplayBankAccountViewState -> {
            BankAccountViewDisplay(state,
                onViewAllClick = {
                    navController.navigate(NavRoutes.TransactionList.route)
                }, onTransactionClick = {
                    val transaction = Uri.encode(Gson().toJson(it))
                    navController.navigate(NavRoutes.TransactionDetails(transaction).route)
                })
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
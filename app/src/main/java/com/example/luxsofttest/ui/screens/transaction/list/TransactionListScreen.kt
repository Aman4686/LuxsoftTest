package com.example.luxsofttest.ui.screens.transaction.list

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.luxsofttest.navigation.NavRoutes
import com.example.luxsofttest.ui.component.FullScreenLoading
import com.example.luxsofttest.ui.screens.transaction.list.state.DisplayTransactionListViewState
import com.example.luxsofttest.ui.screens.transaction.list.state.ErrorTransactionListViewState
import com.example.luxsofttest.ui.screens.transaction.list.state.InitialTransactionListViewEvent
import com.example.luxsofttest.ui.screens.transaction.list.state.LoadingTransactionListViewState
import com.example.luxsofttest.ui.screens.transaction.list.view.TransactionListViewDisplay
import com.google.gson.Gson

@Composable
fun TransactionListScreen(
    navController: NavController,
    viewModel: TransactionListViewModel = hiltViewModel()
) {
    val viewState by viewModel.transactionListViewStateFlow.collectAsState()

    when(val state = viewState){
        is DisplayTransactionListViewState -> {
           TransactionListViewDisplay(state = state, onTransactionClick = {
               val transaction = Uri.encode(Gson().toJson(it))
               navController.navigate(NavRoutes.TransactionDetails(transaction).route)
           })
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
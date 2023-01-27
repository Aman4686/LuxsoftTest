package com.example.luxsofttest.ui.screens.transaction.list.view

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.luxsofttest.ui.component.TransactionList
import com.example.luxsofttest.ui.screens.transaction.list.state.DisplayTransactionListViewState

@Composable
fun TransactionListViewDisplay(
    state: DisplayTransactionListViewState
) {
    Surface {
        TransactionList(transactionList = state.transactionsList, onTransactionClick = {})
    }
}
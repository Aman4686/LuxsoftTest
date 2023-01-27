package com.example.luxsofttest.ui.screens.transaction.detail.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.luxsofttest.ui.component.AmountOfMoney
import com.example.luxsofttest.ui.component.TransactionImage
import com.example.luxsofttest.ui.screens.transaction.detail.state.DisplayTransactionDetailsViewState
import com.example.luxsofttest.utils.ColorUtils

@Composable
fun TransactionDetailsViewDisplay(
    viewState: DisplayTransactionDetailsViewState
) {

    val transactionData = viewState.transaction

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val pendingTransactionColor = ColorUtils.getPendingColor(status = transactionData.status)
            TransactionImage(transactionData.category, pendingTransactionColor)
            Text(text = viewState.transaction.merchand, color = pendingTransactionColor)
            AmountOfMoney(money = transactionData.amount, isMinus = true, textColor = pendingTransactionColor)
        }
    }
}
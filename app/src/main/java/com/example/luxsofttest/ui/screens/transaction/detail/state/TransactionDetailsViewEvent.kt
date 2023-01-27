package com.example.luxsofttest.ui.screens.transaction.detail.state

import com.example.luxsofttest.cloud.model.Transaction

sealed class TransactionDetailsViewEvent

data class InitialTransactionDetailsViewEvent(val transaction: Transaction?) : TransactionDetailsViewEvent()
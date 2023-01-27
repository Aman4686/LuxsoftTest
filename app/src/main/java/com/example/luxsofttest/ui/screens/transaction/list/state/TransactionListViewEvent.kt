package com.example.luxsofttest.ui.screens.transaction.list.state

import com.example.luxsofttest.cloud.model.Transaction

sealed class TransactionListViewEvent

object InitialTransactionListViewEvent : TransactionListViewEvent()
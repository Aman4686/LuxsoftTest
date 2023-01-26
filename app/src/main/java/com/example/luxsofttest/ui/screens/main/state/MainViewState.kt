package com.example.luxsofttest.ui.screens.main.state

import com.example.luxsofttest.cloud.model.CardResult

sealed class MainViewState

data class DisplayMainViewState(
    val cardList :List<CardResult>,
//    val pendingTransactions :List<pe>,
//    val executedTransactions :List<CardResult>
) : MainViewState()

object LoadingMainViewState : MainViewState()

data class ErrorMainViewState(val exception: Exception) : MainViewState()
package com.example.luxsofttest.navigation

import com.example.luxsofttest.cloud.model.Transaction
import com.example.luxsofttest.cloud.model.TransactionCategory
import com.example.luxsofttest.cloud.model.TransactionStatus

sealed class NavRoutes(val route: String) {
    object BankAccount : NavRoutes("main")

    object TransactionList : NavRoutes("transactionList")

    data class TransactionDetails(
        val transaction: String,
    ) : NavRoutes("transactionDetails/$transaction")
}
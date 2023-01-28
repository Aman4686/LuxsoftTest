package com.example.luxsofttest.navigation

sealed class NavRoutes(val route: String) {
    object BankAccount : NavRoutes("main")

    object TransactionList : NavRoutes("transactionList")

    data class TransactionDetails(
        val transaction: String,
    ) : NavRoutes("transactionDetails/$transaction")
}
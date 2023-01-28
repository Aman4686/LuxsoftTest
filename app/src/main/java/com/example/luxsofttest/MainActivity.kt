package com.example.luxsofttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.luxsofttest.cloud.model.BaseTransaction

import com.example.luxsofttest.navigation.NavRoutes
import com.example.luxsofttest.navigation.TransactionNavType
import com.example.luxsofttest.ui.screens.bankAccount.BankAccountScreen
import com.example.luxsofttest.ui.screens.transaction.detail.TransactionDetailsScreen
import com.example.luxsofttest.ui.screens.transaction.list.TransactionListScreen
import com.example.luxsofttest.ui.theme.MainTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                InitializeNavHost()
            }
        }
    }

    @Composable
    fun InitializeNavHost() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = NavRoutes.BankAccount.route) {
            composable(NavRoutes.BankAccount.route) {
                BankAccountScreen(navController)
            }

            composable(NavRoutes.TransactionList.route) {
                TransactionListScreen(navController)
            }

            composable("transactionDetails/{transaction}",
                arguments = listOf(
                    navArgument("transaction") { type = TransactionNavType() },
                )
            ) { backStackEntry ->
                val result = backStackEntry.arguments?.getParcelable<BaseTransaction>("transaction")
                TransactionDetailsScreen(result)
            }
        }
    }
}
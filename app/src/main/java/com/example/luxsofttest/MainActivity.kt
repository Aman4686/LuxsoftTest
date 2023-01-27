package com.example.luxsofttest

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.luxsofttest.cloud.model.Transaction

import com.example.luxsofttest.navigation.NavRoutes
import com.example.luxsofttest.navigation.PostType
import com.example.luxsofttest.ui.screens.bankAccount.BankAccountScreen
import com.example.luxsofttest.ui.screens.transaction.detail.TransactionDetailsScreen
import com.example.luxsofttest.ui.screens.transaction.list.TransactionListScreen
import com.example.luxsofttest.ui.theme.LuxsoftTestTheme
import com.example.luxsofttest.ui.theme.MainTheme
import com.google.gson.Gson
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
                BankAccountScreen(navController, onTransactionClick = {
                    val transaction = Uri.encode(Gson().toJson(it))
                    navController.navigate(NavRoutes.TransactionDetails(transaction).route)
                })
            }

            composable(NavRoutes.TransactionList.route) {
                TransactionListScreen()
            }

            composable("transactionDetails/{transaction}",
                arguments = listOf(
                    navArgument("transaction") { type = PostType() },
                )
            ) { backStackEntry ->
                val result = backStackEntry.arguments?.getParcelable<Transaction>("transaction")
                TransactionDetailsScreen(result)
            }
        }
    }
}
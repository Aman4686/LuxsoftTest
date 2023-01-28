package com.example.luxsofttest.cloud

import com.example.luxsofttest.cloud.model.*
import javax.inject.Inject

private const val TAG = "MainRepository"

class MainRepository @Inject constructor(
    private val bankAPI: BankAPI
) {

    suspend fun getCards(): List<CardResult> =
        bankAPI.getCards().map { response ->
            CardResult(
                amount = response.amount.toInt(),
                currency = response.currency
            )
        }

    suspend fun getPendingTransactions(): List<PendingTransactionResult> =
        bankAPI.getPendingTransactions().map { transition ->
            PendingTransactionResult(
                merchand = transition.merchand,
                amount = transition.amount.toInt(),
                currency = transition.currency,
                category = transition.category,
            )
        }

    suspend fun getExecutedTransactions(): List<ExecutedTransactionResult> =
        bankAPI.getExecutedTransactions().map { transition ->
            ExecutedTransactionResult(
                merchand = transition.merchand,
                amount = transition.amount.toInt(),
                currency = transition.currency,
                category = transition.category
            )
        }
}
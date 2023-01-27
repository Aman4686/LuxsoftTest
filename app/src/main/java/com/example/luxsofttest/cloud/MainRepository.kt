package com.example.luxsofttest.cloud

import com.example.luxsofttest.cloud.model.*
import com.example.luxsofttest.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val TAG = "MainRepository"

class MainRepository @Inject constructor(
    private val mainAPI: MainAPI
) {

    suspend fun getCards(): List<CardResult> =
        mainAPI.getCards().map { response ->
            CardResult(
                response.amount.toInt()
            )
        }

    suspend fun getPendingTransactions(): List<PendingTransactionResult> =
        mainAPI.getPendingTransactions().map { transition ->
            PendingTransactionResult(
                merchand = transition.merchand,
                amount = transition.amount.toInt(),
                category = transition.category
            )
        }

    suspend fun getExecutedTransactions(): List<ExecutedTransactionResult> =
        mainAPI.getExecutedTransactions().map { transition ->
            ExecutedTransactionResult(
                merchand = transition.merchand,
                amount = transition.amount.toInt(),
                category = transition.category
            )
        }
}
package com.example.luxsofttest.cloud

import com.example.luxsofttest.cloud.model.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.GET


class MainRepository(
    private val mainAPI: MainAPI,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getCards(): List<CardResult> = withContext(ioDispatcher) {
        mainAPI.getCards().map {
            CardResult()
        }
    }

    suspend fun getPendingTransactions(): List<PendingTransactionResult> = withContext(ioDispatcher) {
        mainAPI.getPendingTransactions().map {
            PendingTransactionResult()
        }
    }

    suspend fun getExecutedTransactions(): List<ExecutedTransactionResult> = withContext(ioDispatcher) {
        mainAPI.getExecutedTransactions().map {
            ExecutedTransactionResult()
        }
    }

}
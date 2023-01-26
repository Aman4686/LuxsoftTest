package com.example.luxsofttest.cloud

import com.example.luxsofttest.cloud.model.CardResponse
import com.example.luxsofttest.cloud.model.ExecutedTransactionResponse
import com.example.luxsofttest.cloud.model.PendingTransactionResponse
import retrofit2.http.GET

interface MainAPI {

    @GET("c145c7af-b1ea-42f3-ae85-f6fabe6793c1")
    suspend fun getCards() : List<CardResponse>

    @GET("22812b7a-d2dc-4377-bef9-843b674852c0")
    suspend fun getPendingTransactions() : List<PendingTransactionResponse>

    @GET("b4dbd7be-2ea0-4fc2-837f-be4458f4dbc5")
    suspend fun getExecutedTransactions() : List<ExecutedTransactionResponse>

}
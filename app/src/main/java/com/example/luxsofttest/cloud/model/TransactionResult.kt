package com.example.luxsofttest.cloud.model

import com.google.gson.annotations.SerializedName

data class TransactionResult(
    val merchand: String,
    val money: Int,
    val status: TransactionStatus,
    val category: TransactionCategory
)

enum class TransactionStatus {
    PENDING,
    EXECUTED
}

enum class TransactionCategory {

    @SerializedName("transport")
    TRANSPORT,

    @SerializedName("shopping")
    SHOPPING,

    @SerializedName("service")
    SERVICE,
}
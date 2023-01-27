package com.example.luxsofttest.cloud.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

interface TransactionResult {
    val merchand: String
    val amount: Int
    val category: TransactionCategory
    val status: TransactionStatus
}

@Parcelize
data class Transaction(
    override val merchand: String,
    override val amount: Int,
    override val category: TransactionCategory,
    override val status: TransactionStatus
) : TransactionResult, Parcelable

fun TransactionResult.mapToTransaction() : Transaction {
    return Transaction(merchand = this.merchand,
    amount = this.amount,
    category = this.category,
    status = this.status)
}

@Parcelize
enum class TransactionStatus : Parcelable{
    PENDING,
    EXECUTED
}

@Parcelize
enum class TransactionCategory : Parcelable {

    @SerializedName("transport")
    TRANSPORT,

    @SerializedName("shopping")
    SHOPPING,

    @SerializedName("service")
    SERVICE,

    @SerializedName("energy")
    ENERGY,
}

fun TransactionStatus.toText() : String {
    return when(this){
        TransactionStatus.PENDING -> "Pending"
        TransactionStatus.EXECUTED -> "Executed"
    }
}
package com.example.luxsofttest.cloud.model

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.luxsofttest.R
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

interface Transaction {
    val merchand: String
    val amount: Int
    val currency: String
    val category: TransactionCategory
    val status: TransactionStatus
}

@Parcelize
data class BaseTransaction(
    override val merchand: String,
    override val amount: Int,
    override val currency: String,
    override val category: TransactionCategory,
    override val status: TransactionStatus
) : Transaction, Parcelable

fun Transaction.mapToTransaction(): Transaction {
    return BaseTransaction(
        merchand = this.merchand,
        amount = this.amount,
        currency = this.currency,
        category = this.category,
        status = this.status
    )
}

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

    @SerializedName("energy")
    ENERGY,
}

@Composable
fun TransactionStatus.toText(): String {
    return when (this) {
        TransactionStatus.PENDING -> stringResource(id = R.string.pending)
        TransactionStatus.EXECUTED -> stringResource(id = R.string.executed)
    }
}
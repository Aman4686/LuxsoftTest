package com.example.luxsofttest.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.luxsofttest.R
import com.example.luxsofttest.cloud.model.*
import com.example.luxsofttest.ui.theme.LuxsoftTestTheme
import com.example.luxsofttest.utils.ColorUtils
import java.math.BigDecimal
import java.math.RoundingMode


@Composable
fun TransactionList(
    transactionList: List<Transaction>,
    onTransactionClick: (Transaction) -> Unit
) {
    LazyColumn(modifier = Modifier.background(color = LuxsoftTestTheme.colors.secondaryBackground)) {
        transactionList.forEach { transaction ->
            item {
                TransactionItem(transaction, onTransactionClick)
            }
        }
    }
}

@Composable
private fun TransactionItem(
    transaction: Transaction,
    onTransactionClick: (Transaction) -> Unit
) {
    val pendingTransactionColor = ColorUtils.getPendingColor(status = transaction.status)

    Box(
        modifier = Modifier
            .padding(vertical = 6.dp, horizontal = 20.dp)
            .clickable(onClick = { onTransactionClick.invoke(transaction.mapToTransaction()) })
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
        ) {
            TransactionImage(transaction.category, pendingTransactionColor)
            Spacer(modifier = Modifier.width(width = 24.dp))
            Text(
                text = transaction.merchand,
                style = LuxsoftTestTheme.typography.body,
                color = LuxsoftTestTheme.colors.primaryText
            )
        }

        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            Column(
                horizontalAlignment = Alignment.End,
            ) {
                AmountOfMoney(
                    money = transaction.amount,
                    currency = transaction.currency,
                    isTransaction = true,
                    textColor = pendingTransactionColor,
                    textStyle = LuxsoftTestTheme.typography.body
                )
                Text(
                    text = transaction.status.toText(),
                    style = LuxsoftTestTheme.typography.captionBold,
                    color = pendingTransactionColor,
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
                contentDescription = "Arrow image"
            )
        }
    }
}

@Composable
fun TransactionImage(category: TransactionCategory, imageColor: Color) {
    val transactionImageId = when (category) {
        TransactionCategory.TRANSPORT -> R.drawable.ic_baseline_train_24
        TransactionCategory.SHOPPING -> R.drawable.ic_baseline_shopping_basket_24
        TransactionCategory.SERVICE -> R.drawable.ic_baseline_miscellaneous_services_24
        TransactionCategory.ENERGY -> R.drawable.ic_baseline_bolt_24
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(42.dp)
            .background(LuxsoftTestTheme.colors.primaryBackground, shape = CircleShape)
    ) {
        Image(
            painter = painterResource(id = transactionImageId),
            colorFilter = ColorFilter.tint(imageColor),
            contentDescription = "transactionImage",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(32.dp)
        )
    }
}

@Composable
fun AmountOfMoney(
    money: Int,
    currency: String,
    isTransaction: Boolean,
    textColor: Color = LuxsoftTestTheme.colors.primaryText,
    textStyle: TextStyle = LuxsoftTestTheme.typography.body
) {
    val moneyNumResult = if (isTransaction) money.unaryMinus() else money
    val moneyBigDecimalResult = BigDecimal(moneyNumResult).setScale(2, RoundingMode.CEILING)

    Row {
        Text(text = "$moneyBigDecimalResult", style = textStyle, color = textColor)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = currency, style = textStyle, color = textColor)
    }
}
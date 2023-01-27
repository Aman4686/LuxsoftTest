package com.example.luxsofttest.ui.screens.bankAccount.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.luxsofttest.R
import com.example.luxsofttest.cloud.model.*
import com.example.luxsofttest.ui.component.AmountOfMoney
import com.example.luxsofttest.ui.component.TransactionList
import com.example.luxsofttest.ui.screens.bankAccount.state.DisplayBankAccountViewState
import com.example.luxsofttest.ui.theme.LuxsoftTestTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@Composable
fun BankAccountViewDisplay(
    viewState: DisplayBankAccountViewState,
    onViewAllClick: () -> Unit,
    onTransactionClick: (Transaction) -> Unit
) {
    Surface(
        color = LuxsoftTestTheme.colors.primaryBackground
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CardPager(viewState.cardList)
            Spacer(modifier = Modifier.height(24.dp))
            ServiceButtons()
            TransactionView(viewState.transactionsList, onViewAllClick, onTransactionClick)
        }
    }
}

@Composable
private fun TransactionView(
    transactionsList: List<TransactionResult>?,
    onViewAllClick: () -> Unit,
    onTransactionClick: (Transaction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(shape = LuxsoftTestTheme.shapes.cornersStyle)
            .background(color = LuxsoftTestTheme.colors.secondaryBackground)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = stringResource(R.string.card_transaction),
                modifier = Modifier.align(Alignment.CenterStart),
                style = LuxsoftTestTheme.typography.bodyBold
            )

            ClickableText(
                text = AnnotatedString(stringResource(R.string.view_all)),
                style = TextStyle(color = Color.Red),
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = {
                    onViewAllClick.invoke()
                })
        }
        transactionsList?.let {
            TransactionList(transactionsList, onTransactionClick)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CardPager(cardList: List<CardResult>?) {
    cardList?.let {
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = cardList.size,
            contentPadding = PaddingValues(horizontal = 32.dp),
            state = pagerState,
            modifier = Modifier.height(220.dp)
        ) { page ->
            Image(
                painter = painterResource(id = R.drawable.pngwing_com),
                contentScale = ContentScale.Crop,
                contentDescription = "Card image",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        AvailableCardAmount(cardList, pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun AvailableCardAmount(cardList: List<CardResult>, pagerState: PagerState) {
    val amountOfCardMoney = cardList[pagerState.currentPage].amount

    AmountOfMoney(
        money = amountOfCardMoney,
        isMinus = false,
        textStyle = LuxsoftTestTheme.typography.heading
    )
    Row {
        Text(text = stringResource(R.string.available_amount))
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_outline_info_24),
            contentDescription = "gf",
            colorFilter = ColorFilter.tint(Color.Blue),
            modifier = Modifier
                .size(16.dp)
        )

    }
}

@Composable
private fun ServiceButtons() {
    Row {
        BaseServiceButton(
            text = stringResource(R.string.lock_card),
            icon = painterResource(R.drawable.ic_outline_lock_24)
        ) {

        }
        Spacer(modifier = Modifier.width(64.dp))
        BaseServiceButton(
            text = stringResource(R.string.settings),
            icon = painterResource(R.drawable.ic_outline_settings_24)
        ) {

        }
    }
}

@Composable
private fun BaseServiceButton(text: String, icon: Painter, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .background(LuxsoftTestTheme.colors.secondaryBackground, shape = CircleShape)
                .size(40.dp)
        ) {
            Icon(
                icon,
                contentDescription = "Service Button",
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(text = text, style = LuxsoftTestTheme.typography.body)
    }
}
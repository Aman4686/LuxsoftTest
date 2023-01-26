package com.example.luxsofttest.ui.screens.main.view

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.luxsofttest.R
import com.example.luxsofttest.cloud.model.PendingTransactionResult
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import org.w3c.dom.Text
import java.lang.reflect.Type
import java.math.BigDecimal
import java.math.RoundingMode

@Preview
@Composable
fun MainScreenDisplay() {
    Surface(
        color = Color.Gray
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CardPager()
            Spacer(modifier = Modifier.height(24.dp))
            AvailableCardAmount()
            Spacer(modifier = Modifier.height(24.dp))
            TwoButtons()
            PrimaryTransactionView()
        }
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CardPager(){
    HorizontalPager(
        count = 3,
        contentPadding = PaddingValues(horizontal = 32.dp),
        modifier = Modifier.height(220.dp)

    ) { page ->
        Image(painter = painterResource(id = R.drawable.pngwing_com),
            contentScale = ContentScale.Crop,
            contentDescription = "gdfg",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth())
    }
}

@Composable
fun AvailableCardAmount() {
    AmountOfMoney(isMinus = false, textStyle = TextStyle(fontSize = 30.sp))
    Row {
        Text(text = "Available amount")
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
fun TwoButtons() {
    Row {
        ServiceButton(text = "Lock card", icon = painterResource(R.drawable.ic_outline_lock_24)) {

        }
        Spacer(modifier = Modifier.width(50.dp))
        ServiceButton(
            text = "Settings",
            icon = painterResource(R.drawable.ic_outline_settings_24)
        ) {

        }
    }
}

@Composable
fun ServiceButton(text: String, icon: Painter, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .background(Color.White, shape = CircleShape)
                .size(40.dp)
        ) {
            Icon(
                icon,
                contentDescription = "content description",
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(text = text)
    }
}

fun createTransactionList(): List<PendingTransactionResult> {
    return listOf(
        PendingTransactionResult(),
        PendingTransactionResult(),
        PendingTransactionResult(),
        PendingTransactionResult(),
    )
}

@Composable
fun TransactionList(transactionList: List<PendingTransactionResult> = createTransactionList()) {
    LazyColumn {
        items(items = transactionList) {
            TransactionItem()
        }
    }
}

@Composable
fun PrimaryTransactionView() {
    Column(
        modifier = Modifier
            .height(270.dp)
            .fillMaxWidth()
            .padding(12.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = "Card transaction",
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Text(
                text = "View all",
                color = Color.Red,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
        TransactionList()
    }
}


//TODO Better to pass currency here
@Composable
fun AmountOfMoney(
    money: BigDecimal = BigDecimal(500)
        //BigDecimal(500).setScale(2, RoundingMode.HALF_EVEN)
    ,
    isMinus: Boolean,
    textStyle: TextStyle = TextStyle()
) {
    Row {
        if (isMinus) {
            Text(text = "-")
        }
        Text(text = "$money", style = textStyle)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "CHF", style = textStyle)
    }
}

@Composable
fun TransactionItem() {
    Box(modifier = Modifier.padding(6.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_home_24),
                contentDescription = "gf",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.width(width = 24.dp))
            Text(text = "gfdgdfg")
        }

        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            Column(
                horizontalAlignment = Alignment.End,
            ) {
                AmountOfMoney(isMinus = true)
                Text(text = "Executed", fontSize = 8.sp)
            }
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
                contentDescription = "g"
            )
        }
    }


}
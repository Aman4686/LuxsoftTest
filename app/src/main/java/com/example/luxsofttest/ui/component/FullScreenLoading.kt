package com.example.luxsofttest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun FullScreenLoading() {
    Box(
        modifier = Modifier.fillMaxSize()
            //  .background(JetHabitTheme.colors.primaryBackground)
            .background(Color.White)

    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            // color = JetHabitTheme.colors.tintColor
            color = Color.Black
        )
    }
}
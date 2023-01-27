package com.example.luxsofttest.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.luxsofttest.cloud.model.TransactionStatus
import com.example.luxsofttest.ui.theme.LuxsoftTestTheme

object ColorUtils {

    @Composable
    fun getPendingColor(status: TransactionStatus) : Color {
        val isPending = status == TransactionStatus.PENDING
        return if (isPending) {
            LuxsoftTestTheme.colors.secondaryText
        } else {
            LuxsoftTestTheme.colors.primaryText
        }
    }
}
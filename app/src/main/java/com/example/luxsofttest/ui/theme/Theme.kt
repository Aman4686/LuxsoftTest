package com.example.luxsofttest.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainTheme(
    textSize: LuxsoftTestSize = LuxsoftTestSize.Medium,
    paddingSize: LuxsoftTestSize = LuxsoftTestSize.Medium,
    corners: LuxsoftTestCorners = LuxsoftTestCorners.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        baseDarkPalette
    } else {
        baseLightPalette
    }

    val typography = LuxsoftTestTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                LuxsoftTestSize.Small -> 20.sp
                LuxsoftTestSize.Medium -> 22.sp
                LuxsoftTestSize.Big -> 24.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                LuxsoftTestSize.Small -> 14.sp
                LuxsoftTestSize.Medium -> 16.sp
                LuxsoftTestSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        bodyBold = TextStyle(
            fontSize = when (textSize) {
                LuxsoftTestSize.Small -> 14.sp
                LuxsoftTestSize.Medium -> 16.sp
                LuxsoftTestSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Bold
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                LuxsoftTestSize.Small -> 14.sp
                LuxsoftTestSize.Medium -> 16.sp
                LuxsoftTestSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                LuxsoftTestSize.Small -> 10.sp
                LuxsoftTestSize.Medium -> 12.sp
                LuxsoftTestSize.Big -> 14.sp
            }
        ),
        captionBold = TextStyle(
            fontSize = when (textSize) {
                LuxsoftTestSize.Small -> 10.sp
                LuxsoftTestSize.Medium -> 12.sp
                LuxsoftTestSize.Big -> 14.sp
            },
            fontWeight = FontWeight.Bold
        ),

        )

    val shapes = LuxsoftTestShape(
        padding = when (paddingSize) {
            LuxsoftTestSize.Small -> 12.dp
            LuxsoftTestSize.Medium -> 16.dp
            LuxsoftTestSize.Big -> 20.dp
        },
        cornersStyle = when (corners) {
            LuxsoftTestCorners.Flat -> RoundedCornerShape(0.dp)
            LuxsoftTestCorners.Rounded -> RoundedCornerShape(16.dp)
        }
    )

    CompositionLocalProvider(
        LocalLuxsoftTestColors provides colors,
        LocalLuxsoftTestTypography provides typography,
        LocalLuxsoftTestShape provides shapes,
        content = content
    )
}
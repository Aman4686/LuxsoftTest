package com.example.luxsofttest.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat

@Composable
fun MainTheme(
    style: LuxsoftTestStyle = LuxsoftTestStyle.Purple,
    textSize: LuxsoftTestSize = LuxsoftTestSize.Medium,
    paddingSize: LuxsoftTestSize = LuxsoftTestSize.Medium,
    corners: LuxsoftTestCorners = LuxsoftTestCorners.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (darkTheme) {
        true -> {
            when (style) {
                LuxsoftTestStyle.Purple -> purpleDarkPalette
                LuxsoftTestStyle.Blue -> blueDarkPalette
                LuxsoftTestStyle.Orange -> orangeDarkPalette
                LuxsoftTestStyle.Red -> redDarkPalette
                LuxsoftTestStyle.Green -> greenDarkPalette
            }
        }
        false -> {
            when (style) {
                LuxsoftTestStyle.Purple -> purpleLightPalette
                LuxsoftTestStyle.Blue -> blueLightPalette
                LuxsoftTestStyle.Orange -> orangeLightPalette
                LuxsoftTestStyle.Red -> redLightPalette
                LuxsoftTestStyle.Green -> greenLightPalette
            }
        }
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
            } ,
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
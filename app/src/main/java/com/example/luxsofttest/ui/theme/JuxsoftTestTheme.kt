package com.example.luxsofttest.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class LuxsoftTestColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color
)

data class LuxsoftTestTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val bodyBold: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle,
    val captionBold: TextStyle
)

data class LuxsoftTestShape(
    val padding: Dp,
    val cornersStyle: Shape
)

object LuxsoftTestTheme {
    val colors: LuxsoftTestColors
        @Composable
        get() = LocalLuxsoftTestColors.current

    val typography: LuxsoftTestTypography
        @Composable
        get() = LocalLuxsoftTestTypography.current

    val shapes: LuxsoftTestShape
        @Composable
        get() = LocalLuxsoftTestShape.current
}

val LocalLuxsoftTestColors = staticCompositionLocalOf<LuxsoftTestColors> {
    error("No colors provided")
}

val LocalLuxsoftTestTypography = staticCompositionLocalOf<LuxsoftTestTypography> {
    error("No font provided")
}

val LocalLuxsoftTestShape = staticCompositionLocalOf<LuxsoftTestShape> {
    error("No shapes provided")
}

enum class LuxsoftTestSize {
    Small, Medium, Big
}

enum class LuxsoftTestCorners {
    Flat, Rounded
}

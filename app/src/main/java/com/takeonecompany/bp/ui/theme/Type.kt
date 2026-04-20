package com.takeonecompany.bp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.takeonecompany.bp.R

val AppFontFamily = FontFamily(
    Font(R.font.font, FontWeight.Normal),
    Font(R.font.font, FontWeight.Medium),
    Font(R.font.font, FontWeight.SemiBold),
    Font(R.font.font, FontWeight.Bold)
)

val Typography = Typography(
    displayLarge = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold, fontSize = 40.sp, lineHeight = 48.sp),
    displayMedium = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold, fontSize = 32.sp, lineHeight = 40.sp),
    displaySmall = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 28.sp, lineHeight = 36.sp),
    headlineLarge = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold, fontSize = 26.sp, lineHeight = 34.sp),
    headlineMedium = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 22.sp, lineHeight = 30.sp),
    headlineSmall = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 19.sp, lineHeight = 26.sp),
    titleLarge = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 18.sp, lineHeight = 24.sp, letterSpacing = 0.1.sp),
    titleMedium = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp, lineHeight = 22.sp, letterSpacing = 0.1.sp),
    titleSmall = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp),
    bodyLarge = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.25.sp),
    bodyMedium = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.25.sp),
    bodySmall = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.3.sp),
    labelLarge = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.5.sp),
    labelMedium = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp),
    labelSmall = TextStyle(fontFamily = AppFontFamily, fontWeight = FontWeight.Medium, fontSize = 11.sp, lineHeight = 14.sp, letterSpacing = 0.5.sp),
)

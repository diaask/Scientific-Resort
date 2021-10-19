package com.app.longevityresort.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.longevityresort.R


val HelveticaNeueArabicFontFamily = FontFamily(
    listOf(
        Font(R.font.arb_regular),
        Font(R.font.arb_bold, FontWeight.Bold)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 42.sp,
    ),
    h2 = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 42.sp,
    ),
    h3 = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
    ),
    h4 = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    ),
    h5 = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    h6 = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
    ),
    body1 = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),
    button = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
    ),
    caption = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp
    ),
    overline = TextStyle(
        fontFamily = HelveticaNeueArabicFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp
    )
)
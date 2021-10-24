package com.app.longevityresort.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun MainTitleText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.White,
    style: TextStyle = MaterialTheme.typography.h5
) {
    Text(modifier = modifier,text = text, color = color, style = style)
}

@Composable
fun SubTitleText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.White,
    style: TextStyle = MaterialTheme.typography.body1
) {
    Text(modifier = modifier,text = text, color = color, style = style)
}
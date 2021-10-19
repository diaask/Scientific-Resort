package com.app.longevityresort.features.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.longevityresort.R
import com.app.longevityresort.ui.theme.Blue
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun HomeTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
        Icon(
            modifier = Modifier.fillMaxWidth().weight(1f),
            painter = painterResource(id = R.drawable.ic_logo), contentDescription = "App Logo",
            tint = Blue
        )
        Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
    }
}


@ExperimentalFoundationApi
@ExperimentalPagerApi
@Preview
@Composable
fun HomeTopBarPreview() {
    HomeTopBar()
}
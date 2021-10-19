package com.app.longevityresort.features.locations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.longevityresort.features.home.HomeViewModel
import com.app.longevityresort.ui.theme.Blue
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun LocationsScreen(viewModel: HomeViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Blue,
                contentPadding = PaddingValues(start = 16.dp),
                contentColor = Color.White,
            ) {
                Text(text = "Locations")
            }
        }
    ) {
        LocationsListView(viewModel.locations.value)
    }
}

@Preview
@Composable
fun LocationsScreenPreview() {
//    LocationsScreen()
}
package com.app.longevityresort.features.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState, modifier = Modifier,contentPadding = PaddingValues(top = 16.dp,bottom = 16.dp)) {
        item {
            HomeTopBar()
        }
        item {
            HomeSlider(viewModel.homeSlider.value)
        }
        item {
            LongevityFactorsSection(viewModel.longevityFactors.value)
        }
        item {
            OurServicesSection(viewModel.services.value)
        }
    }
}


@ExperimentalFoundationApi
@ExperimentalPagerApi
@Preview
@Composable
fun HomeScreenPreview() {
//    HomeScreen(ViewModel())
}
package com.app.longevityresort.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.longevityresort.R
import com.app.longevityresort.base.model.HomeSliderView
import com.app.longevityresort.extensions.loadPicture
import com.app.longevityresort.ui.theme.Blue
import com.app.longevityresort.ui.theme.MainTitleText
import com.app.longevityresort.ui.theme.SubTitleText
import com.google.accompanist.pager.*

@ExperimentalPagerApi
@Composable
fun HomeSlider(homeSlider: List<HomeSliderView>) {
    val pagerState = rememberPagerState()

    Box(
        modifier = Modifier
            .height(230.dp)
            .padding(top = 16.dp)
    ) {
        HorizontalPager(count = homeSlider.size, state = pagerState) { page ->
            SliderPage(homeSlider[page])
        }
        PagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun SliderPage(sliderView: HomeSliderView) {
    Card(
        shape = MaterialTheme.shapes.large.copy(CornerSize(20.dp)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .background(MaterialTheme.colors.surface),
        elevation = 4.dp,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            val image = loadPicture(
                url = sliderView.url,
                defaultImage = R.drawable.ic_launcher_foreground
            ).value
            image?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "Slider Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )

            }
            Surface(
                color = Color(0xAA000000), modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.5f)
            ){}
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                MainTitleText(text = sliderView.title)
                SubTitleText(text = sliderView.subtitle)
            }
        }
    }

}

@ExperimentalPagerApi
@Composable
fun PagerIndicator(pagerState: PagerState, modifier: Modifier = Modifier) {
    HorizontalPagerIndicator(
        pagerState = pagerState,
        modifier = modifier,
        activeColor = Blue,
        indicatorWidth = 12.dp,
        indicatorHeight = 4.dp,
        spacing = 4.dp,
        indicatorShape = RoundedCornerShape(2.dp)
    )

}

@ExperimentalPagerApi
@Composable
@Preview
fun PreviewHomeSlider(){
    HomeSlider(homeSlider =
    arrayListOf(
        HomeSliderView(0, "", "", "", ""),
        HomeSliderView(0, "", "", "", ""),
        HomeSliderView(0, "", "", "", ""),
        HomeSliderView(0, "", "", "", ""),
    )
    )
}
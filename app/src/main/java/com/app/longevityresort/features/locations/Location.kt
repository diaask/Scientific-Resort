package com.app.longevityresort.features.locations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
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
import androidx.compose.ui.unit.dp
import com.app.longevityresort.R
import com.app.longevityresort.base.model.HomeSliderView
import com.app.longevityresort.base.model.LocationView
import com.app.longevityresort.extensions.loadPicture
import com.app.longevityresort.features.home.HomeSlider
import com.app.longevityresort.features.home.HomeTopBar
import com.app.longevityresort.features.home.LongevityFactorsSection
import com.app.longevityresort.features.home.OurServicesSection
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun LocationsListView(locations: List<LocationView>) {
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState, modifier = Modifier,contentPadding = PaddingValues(top = 16.dp,bottom = 70.dp)) {
//        item {
//            HomeTopBar()
//        }
        items(locations.size) { index ->
            ResortLocation(sliderView = locations[index])
        }
    }

}

@Composable
fun ResortLocation(sliderView: LocationView) {
    Card(
        shape = MaterialTheme.shapes.large.copy(CornerSize(20.dp)),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .background(MaterialTheme.colors.surface),
        elevation = 4.dp,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            val image = loadPicture(
                url = sliderView.image,
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
            ) {}
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Text(text = sliderView.title, color = Color.White,style = MaterialTheme.typography.h5)
                Text(text = sliderView.description, color = Color.White,style = MaterialTheme.typography.body1)
            }
        }
    }

}
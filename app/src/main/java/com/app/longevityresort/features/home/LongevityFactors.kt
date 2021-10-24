package com.app.longevityresort.features.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.longevityresort.R
import com.app.longevityresort.base.model.FactorsView
import com.app.longevityresort.ui.theme.Blue
import com.app.longevityresort.ui.theme.MainTitleText

@ExperimentalFoundationApi
@Composable
fun LongevityFactorsSection(factors: List<FactorsView>) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        MainTitleText(modifier = Modifier.padding(start = 16.dp, top = 16.dp), text = stringResource(R.string.longevity_factors))
        LazyRow(
            modifier = Modifier,
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(factors.size) { index ->
                LongevityFactorsRow(
                    factor = factors[index]
                )
            }
        }
    }
}

@Composable
fun LongevityFactorsRow(factor: FactorsView) {
    Card {
        Row(Modifier.padding(10.dp)) {
            Card(
                modifier = Modifier
                    .size(50.dp, 50.dp)
                    .background(color = Blue, shape = CircleShape)
                    .align(CenterVertically),
                shape = CircleShape,
                backgroundColor = Blue
            ) {
                Icon(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.ic_tab_home),
                    tint = Color.White,
                    contentDescription = "longevity factory"
                )
            }
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .align(CenterVertically)
                    .padding(start = 10.dp)
            ) {
                Text(
                    modifier = Modifier.width(200.dp),
                    text = factor.title,
                    style = MaterialTheme.typography.h5,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(
                    modifier = Modifier.width(150.dp),
                    text = factor.description,
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun LongevityFactorsPreview() {
    LongevityFactorsRow(FactorsView(0, "Title", "Long Description", ""))
}
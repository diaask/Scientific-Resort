package com.app.longevityresort.features.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.longevityresort.R
import com.app.longevityresort.base.model.ServiceView
import com.app.longevityresort.ui.theme.MainTitleText
import com.app.longevityresort.ui.theme.SubTitleText

@ExperimentalFoundationApi
@Composable
fun OurServicesSection(service: List<ServiceView>) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        MainTitleText(text = stringResource(R.string.our_services))
        Column {
            service.forEach { service ->
                OurServicesRow(service = service)
            }
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Composable
fun OurServicesRow(service: ServiceView) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        shape = MaterialTheme.shapes.large.copy(CornerSize(15.dp)),
    ) {
        SubTitleText(modifier = Modifier.padding(10.dp), text = service.title, color = Color.Black)
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun OurServicesPreview() {
    OurServicesRow(ServiceView(0, "Service name"))
}
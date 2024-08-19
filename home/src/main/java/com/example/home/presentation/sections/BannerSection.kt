package com.example.home.presentation.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.core.utils.Constants.VALUE_3000
import com.example.home.domain.model.BannerItem
import com.example.home.presentation.uievent.HomeUIEvent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerSection(
    bannerItems: List<BannerItem>,
    onBannerClicked: (HomeUIEvent) -> Unit,
) {
    val pagerStage = rememberPagerState(initialPage = 0)

    AutoScrollBanner(
        pagerState = pagerStage,
        itemCount = bannerItems.size,
    )

    HorizontalPager(
        count = bannerItems.size,
        state = pagerStage,
        modifier = Modifier
            .padding(10.dp)
            .height(200.dp)
            .fillMaxWidth(),
    ) { page ->
        val bannerItem = bannerItems[page]
        CoilImageComponent(
            imageUrl = bannerItem.image,
            contentScale = ContentScale.Fit,
            contentDescription = "Banner Image",
            onClick = {
                bannerItem.navigationData.run {
                    onBannerClicked(HomeUIEvent.OnBannerClicked)
                }
            },
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun AutoScrollBanner(
    pagerState: PagerState,
    itemCount: Int,
) {
    LaunchedEffect(pagerState) {
        while (isActive) {
            delay(VALUE_3000.toLong())
            val nextPage = (pagerState.currentPage + 1) % itemCount
            pagerState.animateScrollToPage(nextPage)
        }
    }
}

@Preview
@Composable
fun TestBannerSection() {
    BannerSection(
        bannerItems = listOf(
            BannerItem(
                image = "https://www.example.com/image1.jpg",
                navigationData = "https://www.example.com/product1",
            ),
            BannerItem(
                image = "https://www.example.com/image2.jpg",
                navigationData = "https://www.example.com/product2",
            ),
            BannerItem(
                image = "https://www.example.com/image3.jpg",
                navigationData = "https://www.example.com/product3",
            ),
        ),
        onBannerClicked = {},
    )
}

package com.example.home.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.home.domain.model.HomeSectionItem
import com.example.home.presentation.sections.BannerSection
import com.example.home.presentation.sections.SectionTitle
import com.example.home.presentation.sections.SlidableSection
import com.example.home.presentation.uievent.HomeUIEvent

@Composable
fun SectionList(
    sections: List<HomeSectionItem>?,
    onEvent: (HomeUIEvent) -> Unit,
) {
    sections?.let {
        LazyColumn {
            items(sections, key = { sectionItem ->
                when (sectionItem) {
                    is HomeSectionItem.Banner -> "Banner - ${sectionItem.bannerItem.joinToString(
                        "-",
                    ){it.navigationData}}"
                    is HomeSectionItem.SlideBarProject -> "Slideble - ${sectionItem.id}"
                    is HomeSectionItem.VerticalProducts -> "Vertical - ${sectionItem.sectionTitle}"
                }
            }) { section ->
                when (section) {
                    is HomeSectionItem.Banner -> BannerSection(
                        bannerItems = section.bannerItem,
                        onEvent,
                    )

                    is HomeSectionItem.SlideBarProject -> SlidableSection(
                        productItems = section.productItem,
                        sectionTitle = section.sectionTitle,
                        onEvent,
                    )

                    is HomeSectionItem.VerticalProducts -> VerticalSection(
                        section = section,
                        onEvent,
                    )
                }
            }
        }
    }
}

@Composable
fun VerticalSection(
    section: HomeSectionItem.VerticalProducts,
    onEvent: (HomeUIEvent) -> Unit,
) {
    SectionTitle(title = section.sectionTitle)
    val products = remember { section.productItem }
    products.forEach { productItem ->
        VerticalItemCard(
            item = productItem,
            onItemClicked = { onEvent(HomeUIEvent.OnVerticalProductClicked(productItem)) },
        )
    }
}

@Preview
@Composable
fun TestVerticalSection() {
    VerticalSection(
        section = HomeSectionItem.VerticalProducts(
            productItem = emptyList(),
            sectionTitle = "Vertical Products",
            id = 1,
        ),
        onEvent = {},
    )
}

package com.example.home.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class HomeSection(
    val sectionItems: List<HomeSectionItem>,
)

sealed class HomeSectionItem {
    abstract val viewType: Int

    @Immutable
    data class Banner(
        override val viewType: Int = VIEW_TYPE_BANNER,
        val bannerItem: List<BannerItem>,
    ) : HomeSectionItem()

    @Immutable
    data class SlideBarProject(
        override val viewType: Int = VIEW_TYPE_SLIDE_BAR_PRODUCTS,
        val productItem: List<ProductItem>,
        val sectionTitle: String,
        val id: Int,
    ) : HomeSectionItem()

    @Immutable
    data class VerticalProducts(
        override val viewType: Int = VIEW_TYPE_VERTICAL_PRODUCTS,
        val productItem: List<ProductItem>,
        val sectionTitle: String,
        val id: Int,
    ) : HomeSectionItem()

    companion object {
        const val VIEW_TYPE_BANNER = 1
        const val VIEW_TYPE_SLIDE_BAR_PRODUCTS = 2
        const val VIEW_TYPE_VERTICAL_PRODUCTS = 4
    }
}

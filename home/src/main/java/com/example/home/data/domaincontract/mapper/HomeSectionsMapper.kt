package com.example.home.data.domaincontract.mapper

import com.example.home.data.datasource.model.HomeResponse
import com.example.home.data.datasource.model.HomeSectionResponse
import com.example.home.domain.model.BannerItem
import com.example.home.domain.model.HomeSection
import com.example.home.domain.model.HomeSectionItem
import com.example.home.domain.model.ProductItem

fun HomeResponse.mapToHomeSections(): HomeSection {
    val homeSectionsItems = mutableListOf<HomeSectionItem>()

    this.sections.forEach { section ->
        val viewType = when (section.type) {
            1 -> HomeSectionItem.VIEW_TYPE_BANNER
            2 -> HomeSectionItem.VIEW_TYPE_SLIDE_BAR_PRODUCTS
            4 -> HomeSectionItem.VIEW_TYPE_VERTICAL_PRODUCTS
            else -> -1
        }
        fun mapHomeSectionToBannerItem(homeSection: HomeSectionResponse): BannerItem {
            return BannerItem(
                image = homeSection.image,
                navigationData = homeSection.navigationData
            )
        }
        fun mapToProductItem(response: HomeSectionResponse): ProductItem {
            return ProductItem(
                productId = response.productId,
                productImage = response.productImage,
                text = response.text,
                subText = response.subText,
                review = response.review,
                questions = response.questions,
                rating = response.rating,
                share = response.share,
                piece = response.piece,
                soldOutText = response.soldOutText
            )
        }

        val sectionItem = when (viewType) {
            HomeSectionItem.VIEW_TYPE_BANNER -> HomeSectionItem.Banner(
                viewType = viewType,
                bannerItem = section.sectionData.map { banner ->
                    mapHomeSectionToBannerItem(banner)
                }
            )
            HomeSectionItem.VIEW_TYPE_SLIDE_BAR_PRODUCTS -> HomeSectionItem.SlideBarProject(
                viewType = viewType,
                productItem = section.sectionData.map {
                    mapToProductItem(it)
                },
                sectionTitle = section.sectionTitle ?: "",
                id = section.id
            )
            HomeSectionItem.VIEW_TYPE_VERTICAL_PRODUCTS -> HomeSectionItem.VerticalProducts(
                viewType = viewType,
                productItem = section.sectionData.map {
                    mapToProductItem(it)
                },
                sectionTitle = section.sectionTitle ?: "",
                id = section.id
            )
            else -> null
        }
        sectionItem?.let { homeSectionsItems.add(it) }
    }

    return HomeSection(sectionItems = homeSectionsItems)
}

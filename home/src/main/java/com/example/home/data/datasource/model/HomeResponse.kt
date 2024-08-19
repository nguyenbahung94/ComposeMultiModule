package com.example.home.data.datasource.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("sections")
    val sections: List<Section>
)

data class Section(
    @SerializedName("sectionData")
    val sectionData: List<HomeSectionResponse>,
    val sectionTitle: String? = null,
    val type: Int,
    val id: Int
)

data class HomeSectionResponse(
    val icon: String? = null,
    val image: String,
    val navigationData: String = "ND_49581L",
    val productId: String = "PI_845481EI",
    val productImage: String,
    val questions: String? = null,
    val rating: String? = null,
    val review: String? = null,
    val share: String? = null,
    val subText: String? = null,
    val text: String? = null,
    val piece: String? = null,
    val soldOutText: String? = null
)

package com.example.home.presentation.components

import androidx.compose.runtime.Composable
import com.example.home.domain.model.HomeSection
import com.example.home.presentation.uievent.HomeUIEvent

@Composable
fun HomeScreenContent(
    homeData: HomeSection,
    onEvent: (HomeUIEvent) -> Unit,
) {
    SectionList(homeData.sectionItems, onEvent)
}

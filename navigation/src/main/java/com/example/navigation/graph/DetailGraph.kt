package com.example.navigation.graph

import com.example.navigation.utils.NavigationGraph

object DetailGraph : NavigationGraph {
    override val route: String
        get() = "detailgraph"
    override val startDestination: String
        get() = detailMain.destination(Unit)

    private val detailMain = DetailMain
    private val detailSearch = DetailSearch
}

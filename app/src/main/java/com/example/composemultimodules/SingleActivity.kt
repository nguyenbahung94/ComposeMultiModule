package com.example.composemultimodules

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composemultimodules.ui.theme.ComposeFeatureBaseMultiModuleTheme
import com.example.detail.presentation.DetailScreen
import com.example.detail.presentation.DetailSearchScreen
import com.example.home.presentation.HomeScreen
import com.example.list.presentation.ListScreen
import com.example.navigation.AppNavigation
import com.example.navigation.Navigator
import com.example.navigation.graph.DetailScreens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SingleActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFeatureBaseMultiModuleTheme {
                AppNavigation(
                    navigator = navigator,
                    homeScreen = {
                        HomeScreen()
                    },
                    listScreen = {
                        ListScreen()
                    },
                    detailScreen = { isOpenSheet ->
                        DetailScreen()
                    },
                    detailScreenWithGraph = DetailScreens(
                        detailMain = {
                            DetailScreen()
                        },
                        detailSearch = {
                            DetailSearchScreen()
                        },
                    ),
                )
            }
        }
    }
}

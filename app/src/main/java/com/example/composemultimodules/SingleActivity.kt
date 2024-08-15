package com.example.composemultimodules

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composemultimodules.ui.theme.ComposeFeatureBaseMultiModuleTheme
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
                        Text(
                            text = "Home Screen",
                            modifier = Modifier.padding(16.dp)
                        )
                    },
                    listScreen = {
                        Text(
                            text = "List Screen",
                            modifier = Modifier.padding(16.dp)
                        )
                    },
                    detailScreen = { isOpenSheet ->
                        Text(
                            text = "Detail Screen",
                            modifier = Modifier.padding(16.dp)
                        )
                    },
                    detailScreenWithGraph = DetailScreens(
                        detailMain = {},
                        detailSearch = {}
                    )
                )
            }
        }
    }
}

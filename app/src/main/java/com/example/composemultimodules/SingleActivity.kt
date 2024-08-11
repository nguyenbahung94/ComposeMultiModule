package com.example.composemultimodules

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composemultimodules.ui.theme.ComposeFeatureBaseMultiModuleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFeatureBaseMultiModuleTheme {
                Text("Hello world!", modifier = Modifier.padding(30.dp))
            }
        }
    }
}

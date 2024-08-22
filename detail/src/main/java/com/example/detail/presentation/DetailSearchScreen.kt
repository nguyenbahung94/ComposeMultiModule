package com.example.detail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailSearchScreen() {
    var searchText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Search") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
fun TestSearchBar() {
    DetailSearchScreen()
}

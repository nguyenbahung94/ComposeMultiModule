package com.example.detail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
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
        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            decorationBox = { innerTextField ->
                if (searchText.isEmpty()) {
                    Text("Search..")
                }
                innerTextField()
            },
        )
    }
}

@Preview
@Composable
fun TestSearchBar() {
    DetailSearchScreen()
}

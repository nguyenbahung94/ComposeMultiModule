package com.example.detail.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.detail.domain.model.ItemDetail
import com.example.detail.presentation.uievent.DetailUIEvent

@Composable
fun DetailContent(
    itemData: ItemDetail,
    onSearchClicked: (DetailUIEvent) -> Unit,
) {
    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            CoilImageComponent(
                imageUrl = itemData.productImage,
                contentDescription = "Detail Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(itemData.productName, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(itemData.subText, style = MaterialTheme.typography.bodyMedium)
            Button(
                onClick = { onSearchClicked(DetailUIEvent.SearchDetailClick) },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Blue,
                    containerColor = Color.White,
                ),
            ) {
                Text("Route with Nav Graph to Search Detail")
            }
        }
    }
}

@Preview
@Composable
fun testDetailContent() {
    DetailContent(
        itemData = ItemDetail(
            productImage = "https://picsum.photos/200/300",
            productName = "Product Name",
            subText = "Sub Text",
            productId = "1",
            productOptions = listOf("motor", "car"),
            share = "Share",
        ),
        onSearchClicked = {},
    )
}

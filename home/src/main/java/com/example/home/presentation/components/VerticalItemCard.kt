package com.example.home.presentation.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.home.domain.model.ProductItem

@Composable
fun VerticalItemCard(
    item: ProductItem,
    onItemClicked: (ProductItem) -> Unit
) {
    val cardModifier = remember {
        Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClicked(item) }
    }

    val imageModifier = remember {
        Modifier.size(88.dp)
    }

    val textModifier = remember {
        Modifier.padding(start =8.dp)
            .fillMaxWidth()
    }

    Card(
        modifier = cardModifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CoilImageComponent(
                imageUrl = item.productImage,
                contentDescription = "product image",
                modifier = imageModifier
            )
            Column(
                modifier = Modifier.padding(8.dp)
                    .fillMaxWidth()
            ) {
                item.text?.let {
                    Text(
                        text = it,
                        modifier = textModifier,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Start,
                    )
                }
                item.subText?.let {
                    Text(
                        text = it,
                        modifier = textModifier,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun displayProductItem() {
    VerticalItemCard(
        item = ProductItem(
            productId = "",
            productImage = "https://example.com/image.jpg",
            text = "this is text",
            subText = "this is sub text",
            review = null,
            questions = null,
            rating = null,
            share = null,
            piece = null,
            soldOutText = null

        )
    ) {
        Toast.makeText(null, "Item clicked", Toast.LENGTH_SHORT).show()
    }
}

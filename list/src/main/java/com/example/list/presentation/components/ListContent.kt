package com.example.list.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.list.domain.model.ListProductsModel
import com.example.list.presentation.event.ListUIEvent

@Composable
fun ListContent(
    productsList: List<ListProductsModel>,
    onProductClicked: (ListUIEvent) -> Unit,
) {
    AnimatedVisibility(
        visible = productsList.isNotEmpty(),
        enter = expandVertically() + fadeIn(),
        exit = shrinkVertically() + fadeOut(),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(all = 8.dp),
            modifier = Modifier.padding(8.dp),
        ) {
            items(items = productsList, key = { product ->
                product.productId
            }) {
                ProductCard(product = it, onProductClicked)
            }
        }
    }
}

@Composable
fun ProductCard(
    product: ListProductsModel,
    onProductClicked: (ListUIEvent) -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(250.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        onClick = {
            onProductClicked(ListUIEvent.OnProductClicked)
        },
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            CoilImageComponent(
                imageUrl = product.productImage,
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Fit,
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = product.text,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 4.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = product.subText,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 4.dp),
                    maxLines = 2,
                    color = MaterialTheme.colorScheme.secondary,
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun testListContent() {
    ListContent(
        productsList = listOf(
            ListProductsModel(
                productId = "1",
                productImage = "https://picsum.photos/200/300",
                text = "Product 1",
                subText = "Product 1 Subtext",
                review = "alia",
                questions = "deserunt",
                rating = "odio",

            ),
            ListProductsModel(
                productId = "2",
                productImage = "https://picsum.photos/200/300",
                text = "Product 2",
                subText = "Product 2 Subtext",
                review = "lectus",
                questions = "semper",
                rating = "augue",

            ),
        ),
        onProductClicked = {
        },
    )
}

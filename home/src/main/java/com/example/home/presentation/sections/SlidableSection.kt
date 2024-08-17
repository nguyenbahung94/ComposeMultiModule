package com.example.home.presentation.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.home.domain.model.ProductItem
import com.example.home.presentation.uievent.HomeUIEvent

@Composable
fun SlidableSection(
    productItems: List<ProductItem>,
    sectionTitle: String,
    onProductClicked: (HomeUIEvent) -> Unit
) {
    Column {
        SectionTitle(title = sectionTitle)
        LazyRow {
            items(items = productItems, key = { product ->
                product.productId
            }) { product ->
                HorizontalCard(
                    imageUrl = product.productImage,
                    title = product.text,
                    subtitle = product.subText,
                    onClick = { onProductClicked(HomeUIEvent.OnProductClicked) }
                )
            }
        }
    }
}

@Composable
fun HorizontalCard(
    imageUrl: String,
    title: String?,
    subtitle: String?,
    onClick: () -> Unit
) {
    val cardModifier = remember {
        Modifier
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable(onClick = onClick)
    }

    val textModifier = remember {
        Modifier
            .padding(start = 4.dp)
            .fillMaxWidth()
    }

    Card(
        modifier = cardModifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            CoilImageComponent(
                imageUrl = imageUrl,
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            title?.let {
                Text(
                    text = it,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                    modifier = textModifier.align(Alignment.Start)
                )
            }
            subtitle?.let {
                Text(
                    text = it,
                    color = Color.Gray,
                    textAlign = TextAlign.Left,
                    modifier = textModifier.align(Alignment.Start)
                )
            }
        }
    }
}

@Preview
@Composable
fun testSlidableSection() {
    SlidableSection(
        productItems = listOf(
            ProductItem(
                productId = "1",
                productImage = "https://picsum.photos/200/300",
                text = "Product 1",
                subText = "Product 1 Subtitle",
                review = null,
                questions = null,
                rating = null,
                share = null,
                piece = null,
                soldOutText = null
            ),
            ProductItem(
                productId = "2",
                productImage = "https://picsum.photos/200/300",
                text = "Product 2",
                subText = "Product 2 Subtitle",
                review = null,
                questions = null,
                rating = null,
                share = null,
                piece = null,
                soldOutText = null
            ),
        ),
        sectionTitle = "Products"
    ) {}
}

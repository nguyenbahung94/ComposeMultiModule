package com.example.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.SubcomposeAsyncImage

@Composable
fun CoilImageComponent(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Inside,
    onClick: (() -> Unit)? = null,
    contentDescription: String,
) {
    val imageModifier = modifier.then(
        if (onClick != null) Modifier.clickable { onClick.invoke() } else Modifier
    ).fillMaxSize()

    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = imageModifier,
        contentScale = contentScale,
        loading = { CircularProgressIndicator() }
    )

   /* Image(
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = contentDescription,
        modifier = imageModifier,
        contentScale = contentScale
    )*/
}

package com.lavajaw.edge_ai

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.rememberAsyncImagePainter

@Composable
actual fun rememberSharedImage(image: SharedImage?): Painter? {
    return image?.let { rememberAsyncImagePainter(it.uri) }
}
package com.lavajaw.edge_ai

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toComposeImageBitmap
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.readBytes
import org.jetbrains.skia.Image
import platform.Foundation.NSData
import platform.UIKit.UIImage
import platform.UIKit.UIImagePNGRepresentation

// Function to convert UIImage to ImageBitmap
@OptIn(ExperimentalForeignApi::class)
fun toImageBitmap(image: UIImage): ImageBitmap {
    val data: NSData = UIImagePNGRepresentation(image) ?: error("could not get PNG representation of UIImage")
    val bytes = data.bytes?.readBytes(data.length.toInt()) ?: error("could not get bytes from NSData")
    return Image.makeFromEncoded(bytes).toComposeImageBitmap()
}

@Composable
actual fun rememberSharedImage(image: SharedImage?): Painter? {
    return image?.let {
        remember(it) {
            BitmapPainter(toImageBitmap(it.image))
        }
    }
}
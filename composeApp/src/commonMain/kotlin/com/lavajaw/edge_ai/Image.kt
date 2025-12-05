package com.lavajaw.edge_ai

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable
expect fun rememberSharedImage(image: SharedImage?): Painter?
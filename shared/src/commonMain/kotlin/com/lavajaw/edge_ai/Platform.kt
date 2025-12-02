package com.lavajaw.edge_ai

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
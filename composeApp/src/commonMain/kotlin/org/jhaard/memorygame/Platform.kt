package org.jhaard.memorygame

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform